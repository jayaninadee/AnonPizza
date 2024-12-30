package lk.esoft.pizza.utill;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppUtil {
    private static String _operatorName;
    private static String _operatorUsername;

    public static void setOperator(String operatorName, String operatorUsername) {
        _operatorName = operatorName;
        _operatorUsername = operatorUsername;
    }

    public static String getOperatorName() {
        return _operatorName;
    }

    public static String getOperatorUsername() {
        return _operatorUsername;
    }

    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.show();
    }

    public static void showServerError() {
        showAlert(
                Alert.AlertType.ERROR,
                "Server Error!",
                "Something went wrong with the server"
        );
    }

    public static String getCurrentTimestamp() {
        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString().split("[.]")[0];
        return date+" "+time;
    }

    public static void clearInputs(Node...inputs) {
        for (Node input : inputs) {
            if (input instanceof TextField) {
                ((TextField) input).clear();
            } else if (input instanceof TextArea) {
                ((TextArea) input).clear();
            } else if (input instanceof ComboBox) {
                ((ComboBox) input).getSelectionModel().clearSelection();
            }
        }
    }

}
