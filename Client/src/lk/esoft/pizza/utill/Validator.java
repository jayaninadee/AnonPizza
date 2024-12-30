package lk.esoft.pizza.utill;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Validator {
    public static boolean isNumeric(TextField input) {
        if (!input.getText().matches("[0-9]")) {
            input.requestFocus();
            AppUtil.showAlert(
                    Alert.AlertType.ERROR,
                    "Error!",
                    "Please enter a valid number!"
            );
            return false;
        }
        return true;
    }

    public static boolean isValidPhoneNumber(TextField input) {
        if (!input.getText().matches("[0-9]{10}")) {
            input.requestFocus();
            AppUtil.showAlert(
                    Alert.AlertType.ERROR,
                    "Error!",
                    "Please enter a valid phone number!"
            );
            return false;
        }
        return true;
    }

    public static boolean isNumericIgnoreZero(TextField input) {
        if (!input.getText().matches("[1-9]")) {
            input.requestFocus();
            AppUtil.showAlert(
                    Alert.AlertType.ERROR,
                    "Error!",
                    "Please enter a valid number!"
            );
            return false;
        }
        return true;
    }

    public static boolean isInputEmpty(Node input) {
        if (input instanceof TextField) {
            if (((TextField) input).getText().isEmpty()) {
                input.requestFocus();
                AppUtil.showAlert(
                        Alert.AlertType.ERROR,
                        "Error!",
                        "This field cannot be empty!"
                );
                return false;
            } else {
                return true;
            }
        } else if (input instanceof TextArea) {
            if (((TextArea) input).getText().isEmpty()) {
                input.requestFocus();
                AppUtil.showAlert(
                        Alert.AlertType.ERROR,
                        "Error!",
                        "This field cannot be empty!"
                );
                return false;
            } else {
                return true;
            }
        } else if (input instanceof ComboBox) {
            if (((ComboBox) input).getSelectionModel().isEmpty()) {
                input.requestFocus();
                AppUtil.showAlert(
                        Alert.AlertType.ERROR,
                        "Error!",
                        "This field cannot be empty!"
                );
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}
