package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class clientInfo implements Initializable
{
    @FXML private TableView<Clienttable> tableView2;
    @FXML private TableColumn<Clienttable,String> name;
    @FXML private TableColumn<Clienttable,String> mobile;
    @FXML private TableColumn<Clienttable,String> usrname;
    @FXML private TableColumn<Clienttable,String> owned;
    ObservableList<Clienttable> Client = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        mobile.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
        usrname.setCellValueFactory(new PropertyValueFactory<>("Usrname"));
        owned.setCellValueFactory(new PropertyValueFactory<>("Carsowned"));
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","amanaditya");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from client_info");
            while(rs.next())
            {
                Client.add(new Clienttable(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                System.out.println(rs.getString(1)+"      "+rs.getString(2)+"    "+rs.getString(3)+"    "+rs.getString(4));

            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        tableView2.setItems(Client);
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
