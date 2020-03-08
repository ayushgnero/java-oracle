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

public class screen1 extends Application {
    @FXML
    Button exit1;
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group(), 950, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onLoginClick(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene Loginscene = new Scene(LoginParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Loginscene);
        window.show();
    }
    @FXML
    public void exit1(ActionEvent event)
    {
        Stage stage = (Stage) exit1.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void onSignUpClick(ActionEvent event) throws IOException
    {
        Parent SignUpparent = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene SignUpscene = new Scene(SignUpparent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(SignUpscene);
        window.show();
    }
}
