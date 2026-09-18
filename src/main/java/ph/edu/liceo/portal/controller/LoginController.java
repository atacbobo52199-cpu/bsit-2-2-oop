package ph.edu.liceo.portal.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import ph.edu.liceo.portal.MainApp;
import ph.edu.liceo.portal.model.Student;

public class LoginController {

    // TODO 9: the three @FXML fields, named exactly like the fx:id values
    @FXML
    private TextField studentNoField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    // TODO 10: validate, ask the model, then show the error or the profile
    @FXML
    private void handleLogin() {
        String studentNo = studentNoField.getText().trim();
        String password = passwordField.getText();

        if (studentNo.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please fill in both fields.");
            return;
        }

        // 3. asking the "model", then act on the answer
        Student student = MainApp.getDirectory().login(studentNo, password);

        if (student == null) {
            messageLabel.setText("Wrong student number or password.");
            passwordField.clear();
        } else {
            MainApp.showProfile(student);
        }
    }
}