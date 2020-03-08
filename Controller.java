package sample;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.PasswordField;
import javafx.stage.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Controller extends Application{
    private Parent root;
    ResultSet resultSet =null;
    @FXML
    Scene SignUp;
    @FXML
    private javafx.scene.control.TextField fx_username;
    @FXML
    private PasswordField fx_password;
    @FXML
    private  javafx.scene.control.Button exit3;

    @FXML
    private void LogInButtonPressed(ActionEvent event)
    {
        String Username = fx_username.getText();
        String Password = fx_password.getText();
        boolean flag = false;
        System.out.println(Username);
        Scanner s = new Scanner(System.in);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe","system","amanaditya");
            Statement stmt=con.createStatement();
            resultSet=stmt.executeQuery("select PASSWORD from emp_info where username = '"+Username+"'");
            resultSet.next();
            String Pass = resultSet.getString(1);
            resultSet=stmt.executeQuery("select username from emp_info where username = '"+Username+"'");
            resultSet.next();
            String usr = resultSet.getString(1);
            System.out.println(usr+"   "+Pass);
            if (Username == usr && Password == Pass);
            {
                //change activity
                 System.out.println("Sucessfully Loged in");
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
    public void exit3(ActionEvent event)
    {
        Stage stage = (Stage) exit3.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void backfromlogin(ActionEvent event1) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event1.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group(),950,450);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void client(java.awt.event.ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Client.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    @FXML
    public void car(java.awt.event.ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Car.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
