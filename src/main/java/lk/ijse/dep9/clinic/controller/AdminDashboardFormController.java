package lk.ijse.dep9.clinic.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardFormController {
    public Button btnPeopleManagement;
    public Button btnViewRecords;
    public Button btnSettings;
    public Button btnLogout;

    public void btnPeopleManagementOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/PeopleManagementAddModifyProfile.fxml"))));
        stage.setTitle("Open Source MEDICARE: Profile Management");
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
        Stage owner = (Stage) btnSettings.getScene().getWindow();
        owner.hide();
        stage.setOnCloseRequest(windowEvent -> owner.show());
    }

    public void btnViewRecordsOnAction(ActionEvent actionEvent) {

    }

    public void btnSettingsOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/settings.fxml")));
        Stage stage=new Stage();
        stage.setTitle("Open Source Medicare");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        Stage owner=(Stage)btnSettings.getScene().getWindow();
        owner.hide();
        stage.setOnCloseRequest(windowEvent -> owner.show());

    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"))));
        stage.setTitle("Open Source MEDICARE");
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
        btnLogout.getScene().getWindow().hide();
    }
}
