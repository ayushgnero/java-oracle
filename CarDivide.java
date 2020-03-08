package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class CarDivide extends Application {
    @FXML
    Button back,car_ser;
    @FXML private TableView<car> tableView;
    @FXML private TableColumn<car,String> EngineNumber;
    @FXML private TableColumn<car,String> Model;
    @FXML private TableColumn<car,String> Color;
    @FXML private TableColumn<car,String> Manufacturer;
    @FXML private TableColumn<car,String> Owner;
    @FXML private  javafx.scene.control.TextField car_search;
    ObservableList<car> cars = FXCollections.observableArrayList();
    @FXML
    private javafx.scene.control.Button car_tab,car_val,exit4;
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(new Group(), 950, 400);
        stage.setScene(scene);

        stage.show();
    }
    @FXML
    private void CarTable(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("cartable.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @FXML
    private void carInsert(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("CarInsert.fxml"));
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
    public void search(ActionEvent event) throws IOException
    {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @FXML
    public void update(ActionEvent event) throws IOException
    {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("update.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @FXML
    public void delete(ActionEvent event) throws IOException
    {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("delete.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
}
