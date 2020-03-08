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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class CarInsert extends Application
{
    @FXML
    Button carsubmit,exit;
    @FXML
    private javafx.scene.control.TextField en,co,mf,on,mo;
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(new Group(), 950, 400);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void SubmitButton(ActionEvent event)
    {
        String engine = en.getText();
        String color = co.getText();
        String manufacturer = mf.getText();
        String owner = on.getText();
        String model = mo.getText();
        Scanner s = new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","amanaditya");
            Statement stmt=con.createStatement();
            //change activity
            {
                stmt.executeQuery("insert into car_info values('"+engine+"','"+model+"','"+color+"','"+manufacturer+"','"+owner+"')");
                System.out.println("done");
                Parent LoginParent = FXMLLoader.load(getClass().getResource("cartable.fxml"));
                Scene Loginscene = new Scene(LoginParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(Loginscene);
                window.show();
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    @FXML
    private void exit4(ActionEvent event1) throws IOException
    {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void mainmenu(ActionEvent event1) throws IOException
    {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("Car.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }

}
