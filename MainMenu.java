package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.TableView;
import java.awt.*;
import java.io.IOException;

public class MainMenu extends Application
{
    @FXML
    javafx.scene.control.Button  exit4;
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group(), 950, 400);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void clent(ActionEvent event1) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @FXML
    private void car(ActionEvent event1) throws IOException
    {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("Car.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event1.getSource()).getScene().getWindow();
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

}
