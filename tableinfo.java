package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class tableinfo implements Initializable {
    @FXML
    Button back;
    @FXML private TableView<car> tableView;
    @FXML private TableColumn<car,String> EngineNumber;
    @FXML private TableColumn<car,String> Model;
    @FXML private TableColumn<car,String> Color;
    @FXML private TableColumn<car,String> Manufacturer;
    @FXML private TableColumn<car,String> Owner;

    ObservableList<car> cars = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EngineNumber.setCellValueFactory(new PropertyValueFactory<>("EngineNumber"));
        Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        Color.setCellValueFactory(new PropertyValueFactory<>("Color"));
        Manufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        Owner.setCellValueFactory(new PropertyValueFactory<>("Owner"));
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","amanaditya");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from car_info");
            while(rs.next())
            {
                String en = rs.getString(1);
                String mo = rs.getString(2);
                String co = rs.getString(3);
                String ma = rs.getString(4);
                String ow = rs.getString(5);
                cars.add(new car(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        tableView.setItems(cars);
    }
    @FXML
    public void mainscreen(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("car.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
}
