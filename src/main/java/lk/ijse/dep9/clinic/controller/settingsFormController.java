package lk.ijse.dep9.clinic.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class settingsFormController {
    public Button btnManagePrice;
    public Button btnAddDiscount;
    public Button btnAddField;
    public Button btnChangePw;
    public Button btnAbout;

    public void btnAboutOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/AboutForm.fxml")));
        Stage stage=new Stage();
        stage.setTitle("Change Password");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();

    }

    public void btnChangePwOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/ChangePwForm.fxml")));
        Stage stage=new Stage();
        stage.setTitle("Change Password");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public void btnAddFieldOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/ManageFields.fxml")));
        Stage stage=new Stage();
        stage.setTitle("Add Field");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public void btnAddDiscountOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/AddDiscountForm.fxml")));
        Stage stage=new Stage();
        stage.setTitle("Add Discount");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    public void btnManagePriceOnAction(ActionEvent actionEvent) throws IOException {
        Scene scene=new Scene(FXMLLoader.load(this.getClass().getResource("/view/ManagePricesForm.fxml")));
        Stage stage=new Stage();
        stage.setTitle("Manage Prices");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }
}
