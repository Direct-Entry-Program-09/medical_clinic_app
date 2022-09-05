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

    public void btnPeopleManagementOnAction(ActionEvent actionEvent) {
    }

    public void btnViewRecordsOnAction(ActionEvent actionEvent) {
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/settings.fxml")));
        Stage stage=new Stage();
        stage.setTitle("Open Source Medical Clinic");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();

    }
}
