package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientDivide extends Application {
    @FXML
    Button back;
    @FXML private TableView<car> tableView;
    @FXML private TableColumn<car,String> EngineNumber;
    @FXML private TableColumn<car,String> Model;
    @FXML private TableColumn<car,String> Color;
    @FXML private TableColumn<car,String> Manufacturer;
    @FXML private TableColumn<car,String> Owner;
    @FXML
    private javafx.scene.control.Button cli_table,cli_val,exit4;
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(new Group(), 950, 400);
        stage.setScene(scene);

        stage.show();
    }
    @FXML
    private void ClientTable(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("clientTable.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @FXML
    private void ClientInsert(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("clientInsert.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @FXML
    private void exit4(ActionEvent event1) throws IOException
    {
        Stage stage = (Stage) exit4.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void mainmenu(ActionEvent event1) throws IOException
    {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @FXML
    public void search(ActionEvent event1) throws IOException
    {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
}
