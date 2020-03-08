package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Update implements Initializable {
    String searchText,c1;
    ActionEvent event;
    @FXML
    TextField search;
    @FXML
    Button back,delete;
    @FXML private TableView<car> tableView;
    @FXML private TableColumn<car,String> EngineNumber;
    @FXML private TableColumn<car,String> Model;
    @FXML private TableColumn<car,String> Color;
    @FXML private TableColumn<car,String> Manufacturer;
    @FXML private TableColumn<car,String> Owner;
    private final ObservableList<car> dataList = FXCollections.observableArrayList();

    ObservableList<car> cars = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "amanaditya");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from car_info");
            while (rs.next()) {
                String en = rs.getString(1);
                String mo = rs.getString(2);
                String co = rs.getString(3);
                String ma = rs.getString(4);
                String ow = rs.getString(5);
                cars.add(new car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        tableView.setItems(cars);
        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);

        EngineNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        Model.setCellFactory(TextFieldTableCell.forTableColumn());
        Color.setCellFactory(TextFieldTableCell.forTableColumn());
        Manufacturer.setCellFactory(TextFieldTableCell.forTableColumn());
        Owner.setCellFactory(TextFieldTableCell.forTableColumn());
//makes columns editable
        EngineNumber.setCellValueFactory(new PropertyValueFactory<>("EngineNumber"));
        Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        Color.setCellValueFactory(new PropertyValueFactory<>("Color"));
        Manufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        Owner.setCellValueFactory(new PropertyValueFactory<>("Owner"));
        Model.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<car, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<car, String> event) {
                updataData();
            }
        });

        tableView.setItems(null);
        tableView.setItems(cars);
    }
    @FXML
    public void mainscreen(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("Car.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    public void updataData() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://37.128.148.113:3306/FYS", "FYS", "Kcj8g87~");
            Statement con = connection.createStatement();
            //connection
            TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            TableColumn col = pos.getTableColumn();
            String data1 = (String) col.getCellObservableValue(row).getValue();
            //cell
            car row1 = tableView.getSelectionModel().getSelectedItem();
            c1 = row1.getEngineNumber();
            //row
            //tableview variables
            con.execute("UPDATE gevonden_bagage SET  type = 'data1' WHERE koffer_id = 'c1' ");
            //Query
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
    }
    @FXML
    public void getRow() {

        TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        TableColumn col = pos.getTableColumn();
// this gives the value in the selected cell:
        String data1 = (String) col.getCellObservableValue(row).getValue();
        System.out.println(data1);
//CURRENTLY UNUSED METHOD
    }
}
