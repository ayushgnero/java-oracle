package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class search implements Initializable {

    String searchText;
    ActionEvent event;
    @FXML
    TextField search;
    @FXML
    Button back,seach;
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
        System.out.println(searchText);
        String model = search.getText();
        EngineNumber.setCellValueFactory(new PropertyValueFactory<>("EngineNumber"));
        Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        Color.setCellValueFactory(new PropertyValueFactory<>("Color"));
        Manufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        Owner.setCellValueFactory(new PropertyValueFactory<>("Owner"));
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","amanaditya");
            Statement stmt=con.createStatement();
            String query[] = {"SELECT * FROM car_info"};
            for(String q : query) {
                ResultSet rs = stmt.executeQuery(q);
                while (rs.next()) {
                    String en = rs.getString(1);
                    String mo = rs.getString(2);
                    String co = rs.getString(3);
                    String ma = rs.getString(4);
                    String ow = rs.getString(5);
                    cars.add(new car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                }
            }
            dataList.addAll(cars);
            FilteredList<car> filteredData = new FilteredList<>(dataList, b -> true);

            // 2. Set the filter Predicate whenever the filter changes.
            search.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(employee -> {
                    // If filter text is empty, display all persons.

                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (employee.getEngineNumber().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                        return true; // Filter matches first name.
                    } else if (employee.getModel().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches last name.
                    }
                    else if (employee.getColor().toLowerCase().indexOf(lowerCaseFilter) != -1)
                        return true;
                    else
                        return false; // Does not match.

                });
            });
            SortedList<car> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            // 	  Otherwise, sorting the TableView would have no effect.
            sortedData.comparatorProperty().bind(tableView.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            tableView.setItems(sortedData);
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void mainscreen(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("Car.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
}
