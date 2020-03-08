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

public class ClientInsert extends Application
{
    @FXML
    Button submit,exit;
    @FXML
    private javafx.scene.control.TextField cli_name,cli_mobile,cli_id,cli_owned;
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(new Group(), 950, 400);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void SubmitButton(ActionEvent event)
    {
        String name = cli_name.getText();
        String mobile = cli_mobile.getText();
        String clientid = cli_id.getText();
        String owned = cli_owned.getText();
        Scanner s = new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","amanaditya");
            Statement stmt=con.createStatement();
            //change activity
            {
                stmt.executeQuery("insert into client_info values('"+name+"','"+mobile+"','"+clientid+"','"+owned+"')");
                System.out.println("done");
                Parent LoginParent = FXMLLoader.load(getClass().getResource("clientTable.fxml"));
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
        Parent LoginParent = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
}
