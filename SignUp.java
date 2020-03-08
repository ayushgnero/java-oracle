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
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SignUp extends Application {
    @FXML
    Button exit2;
    @FXML
    private javafx.scene.control.TextField fx_name1,fx_Mobile1,fx_Dob1,fx_userid;
    @FXML
    private javafx.scene.control.Button btn_Signup;
    @FXML
    private PasswordField fx_password1,fx_re_password;
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(new Group(), 950, 400);
        stage.setScene(scene);

        stage.show();
    }
    @FXML
    public void exit2(ActionEvent event)
    {
        Stage stage = (Stage) exit2.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void signupButtonPressed(ActionEvent event)
    {
        String Username = fx_userid.getText();
        String Password = fx_password1.getText();
        String Password2 = fx_re_password.getText();
        String Name = fx_name1.getText();
        int Mobile = Integer.parseInt(fx_Mobile1.getText());
        Scanner s = new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","amanaditya");
            Statement stmt=con.createStatement();
            //change activity
            {
                System.out.println("Sucessfully Signed Up");
                System.out.println(Username);
                stmt.executeQuery("insert into emp_info values('"+Username+"','"+Mobile+"','"+Password+"','"+Name+"')");
                System.out.println("done");
                Parent LoginParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                Scene Loginscene = new Scene(LoginParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(Loginscene);
                window.show();

            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    @FXML
    private void backfromsignup(ActionEvent event1) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
}
