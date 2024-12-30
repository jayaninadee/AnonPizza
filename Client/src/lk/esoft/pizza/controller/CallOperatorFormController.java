package lk.esoft.pizza.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Duration;
import lk.esoft.pizza.connector.ProxyHandler;
import lk.esoft.pizza.dto.CusOrderDTO;
import lk.esoft.pizza.observer.Observer;
import lk.esoft.pizza.service.custom.CallOperatorService;
import lk.esoft.pizza.service.custom.CusOrderService;
import lk.esoft.pizza.utill.AppUtil;
import lk.esoft.pizza.utill.Validator;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ResourceBundle;
import java.time.LocalDate;
import java.time.LocalTime;

public class CallOperatorFormController extends UnicastRemoteObject implements Initializable, Observer, SuperController  {

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDone;

    @FXML
    private JFXButton btnOrderR;

    @FXML
    private ComboBox<?> cmbCrust;

    @FXML
    private ComboBox<String> cmbPizza;

    @FXML
    private ComboBox<?> cmbSause;

    @FXML
    private ComboBox<?> cmbTopping;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblOperatorName;

    @FXML
    private Label lblOperatorUsername;

    @FXML
    private Label lblTime;

    @FXML
    private ListView<CusOrderDTO> lstOrderQueue;

    @FXML
    private TextArea txtCusAddress;

    @FXML
    private TextField txtCusName;

    @FXML
    private TextField txtCusTp;

    @FXML
    private TextField txtQty;

    @FXML
    private JFXButton btnOffers;

    private CallOperatorService callOperatorService;
    private CusOrderService cusOrderService;

    public CallOperatorFormController() throws RemoteException {
        try {
            this.callOperatorService = (CallOperatorService) ProxyHandler
                    .getInstance().getProxy(ProxyHandler.ProxyTypes.CALL_OPERATOR);
            cusOrderService = (CusOrderService) ProxyHandler
                    .getInstance().getProxy(ProxyHandler.ProxyTypes.CUS_ORDER);
        } catch (Exception e) {
            e.printStackTrace();
            AppUtil.showServerError();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.cusOrderService.register(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadAllPizzas();
        loadOperator();
        loadDateTime();
        setActionEvents();
        loadQueue();
    }



    private void setActionEvents() {

        btnDone.setOnAction(event -> {
            if (validateForm()) {
                try {
                    boolean isAdd = cusOrderService.addOrder(new CusOrderDTO(
                            txtCusTp.getText(),
                            txtCusName.getText(),
                            txtCusAddress.getText(),
                            cmbPiza.getSelectionModel().getSelectedItem(),
                            cmbPiza.getSelectionModel().getSelectedItem(),
                            cmbPiza.getSelectionModel().getSelectedItem(),
                            cmbPiza.getSelectionModel().getSelectedItem(),
                            Integer.parseInt(txtQty.getText()),
                            AppUtil.getOperatorUsername(),
                            AppUtil.getCurrentTimestamp()
                    ));
                    if (isAdd) {
                        AppUtil.showAlert(
                                Alert.AlertType.INFORMATION,
                                "Done!",
                                "Oder sent to kitchen successfully!"
                        );
                        AppUtil.clearInputs(
                                txtCusName,
                                txtCusTp,
                                txtCusAddress,
                                cmbPizza,
                                txtQty
                        );
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppUtil.showServerError();
                }
            }
        });

    }

    private void loadDateTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            lblTime.setText(LocalTime.now().toString().split("[.]")[0]);
            lblDate.setText(LocalDate.now().toString());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void loadOperator() {
        lblOperatorName.setText(AppUtil.getOperatorName());
        lblOperatorUsername.setText(AppUtil.getOperatorUsername());
    }

    private void loadAllPizzas() {
        try {
            String[] allPizzas = callOperatorService.getAllPizzas();
            cmbPizza.getItems().setAll(allPizzas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadQueue() {
        Platform.runLater(() -> {
            try {
                lstOrderQueue.getItems().setAll(cusOrderService.getQueue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private boolean validateForm() {
        return (
                Validator.isInputEmpty(txtCusName) &&
                        Validator.isInputEmpty(txtCusTp) &&
                        Validator.isInputEmpty(txtCusTp) &&
                        Validator.isValidPhoneNumber(txtCusTp) &&
                        Validator.isInputEmpty(txtCusAddress) &&
                        Validator.isInputEmpty(cmbPizza) &&
                        Validator.isInputEmpty(txtQty) &&
                        Validator.isNumericIgnoreZero(txtQty)
        );
    }

    @Override
    public void update(String message) throws Exception {
        loadQueue();
    }

    @Override
    public void onClose() {
        try {
            this.cusOrderService.unregister(this);
            UnicastRemoteObject.unexportObject(this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
