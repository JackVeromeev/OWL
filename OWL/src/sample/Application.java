package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by ilyam on 16.12.2016.
 */
class Application {

    private String login;

    String toLogIn(Stage stage) throws IOException {
        User u = new User();

        Group root = new Group();
        Label owlLabel = new Label("OWL");
        Label regLabel = new Label("To Sign Up!");
        Text loginTxt = new Text("Login: ");
        Text passwordTxt = new Text("Password: ");
        TextField loginField = new TextField();
        TextField passwordField = new TextField();

        owlLabel.setTranslateX(320);
        owlLabel.setTranslateY(250);
        owlLabel.setScaleX(5);
        owlLabel.setScaleY(5);

        loginField.setTranslateX(270);
        loginField.setTranslateY(320);

        passwordField.setTranslateX(270);
        passwordField.setTranslateY(350);

        loginTxt.setTranslateX(230);
        loginTxt.setTranslateY(335);

        passwordTxt.setTranslateX(210);
        passwordTxt.setTranslateY(365);

        regLabel.setTranslateX(310);
        regLabel.setTranslateY(390);
        regLabel.setScaleX(2);
        regLabel.setScaleY(2);

        stage.setTitle("OWL");
        root.getChildren().addAll(owlLabel, loginField,
                passwordField, loginTxt, passwordTxt, regLabel);
        stage.setScene(new Scene(root, 700, 800));
        stage.show();
        return this.login;
    }
}
