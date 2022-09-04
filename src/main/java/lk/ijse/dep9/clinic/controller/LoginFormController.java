package lk.ijse.dep9.clinic.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.dep9.clinic.security.SecurityContextHolder;
import lk.ijse.dep9.clinic.security.User;
import lk.ijse.dep9.clinic.security.UserRole;

import java.io.IOException;
import java.sql.*;

public class LoginFormController {
    public TextField txtUserName;
    public TextField txtPassword;
    public Button btnLogIn;

    public void btnLogInOnAction(ActionEvent actionEvent) throws ClassNotFoundException, IOException {
        String userName=txtUserName.getText();
        String passwordText=txtPassword.getText();

        if (userName.isBlank()){
            new Alert(Alert.AlertType.ERROR,"User name can't be empty").show();
            txtUserName.requestFocus();
            txtUserName.selectAll();
            return;
        } else if (passwordText.isBlank()) {
            new Alert(Alert.AlertType.ERROR,"Password can't be empty").show();
            txtPassword.requestFocus();
            txtPassword.selectAll();
            return;
        } else if (!userName.matches("[A-z0-9]+$")) {
            new Alert(Alert.AlertType.ERROR,"Invalid Log in credentials.").show();
            txtUserName.requestFocus();
            txtUserName.selectAll();
            return;
        }
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_clinic", "root", "Rashmi@1997")) {
            String sql="SELECT role FROM User WHERE username='%s' AND password='%s'";
            sql=String.format(sql,userName,passwordText);
            System.out.println(sql);
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            if (resultSet.next()){
                String role=resultSet.getString("role");
                SecurityContextHolder.setPrincipal(new User(userName, UserRole.valueOf(role)));

                Scene scene=null;
                switch (role){
                    case "Admin":
                        scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/AdminDashboardForm.fxml")));
                        break;
                    case "Doctor":
                        scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/DoctorDashboardForm.fxml")));
                        break;
                    case "Receptionist":
                        scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/ReceptionistDashboardForm.fxml")));
                        break;
                    default:
                        break;
                }
                Stage stage=new Stage();
                stage.setTitle("Open Source Medical Clinic");
                stage.setScene(scene);
                stage.show();
                stage.centerOnScreen();

                btnLogIn.getScene().getWindow().hide();

            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid Login Credentials").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to connect with the Database, try again").show();
        }
    }
}
