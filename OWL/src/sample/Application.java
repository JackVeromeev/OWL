package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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

        stage.close();
        Group root = new Group();
        Label owlLabel = new Label("OWL"),
                regLabel = new Label("To Sign Up!"),
                logLabel = new Label("To Sign In");
        Text loginTxt = new Text("Login: "),
                passwordTxt = new Text("Password: "),
                errorTxt = new Text("There is no hits in DB!");
        TextField loginField = new TextField();
        PasswordField passwordField = new PasswordField();

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

        errorTxt.setTranslateX(280);
        errorTxt.setTranslateY(450);
        errorTxt.setFill(javafx.scene.paint.Color.RED);
        errorTxt.setVisible(false);

        logLabel.setTranslateX(240);
        logLabel.setTranslateY(390);
        logLabel.setScaleX(2);
        logLabel.setScaleY(2);
        logLabel.setOnMouseEntered(event -> {
            logLabel.setTextFill(javafx.scene.paint.Color.BROWN);
        });
        logLabel.setOnMouseExited(event -> {
            logLabel.setTextFill(javafx.scene.paint.Color.BLACK);
        });
        logLabel.setOnMouseClicked(event -> {
            try {
                System.out.println(loginField.getText() +  " " + passwordField.getText());
                if (u.getUser(loginField.getText(), passwordField.getText())) {
                    mainMenu(stage);
                }
                else {
                    errorTxt.setVisible(true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        regLabel.setTranslateX(370);
        regLabel.setTranslateY(390);
        regLabel.setScaleX(2);
        regLabel.setScaleY(2);
        regLabel.setOnMouseEntered(event -> {
            regLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        });
        regLabel.setOnMouseExited(event -> {
            regLabel.setTextFill(javafx.scene.paint.Color.BLACK);
        });
        regLabel.setOnMouseClicked(event -> {

        });

        stage.setTitle("OWL");
        root.getChildren().addAll(owlLabel, loginField,
                passwordField, loginTxt, passwordTxt,
                regLabel, logLabel, errorTxt);
        stage.setScene(new Scene(root, 700, 800));
        stage.show();
        return this.login;
    }

    public void mainMenu(Stage stage) {
        stage.close();
        Group root = new Group();
        Label owlLabel = new Label("OWL"),
                lTeam = new Label("New Team"),
                lGame = new Label("New Game"),
                lStat = new Label("Show Stats");

        owlLabel.setTranslateX(320);
        owlLabel.setTranslateY(250);
        owlLabel.setScaleX(5);
        owlLabel.setScaleY(5);

        lTeam.setTranslateX(305);
        lTeam.setTranslateY(330);
        lTeam.setScaleX(2);
        lTeam.setScaleY(2);
        lTeam.setOnMouseEntered(event -> {
            lTeam.setTextFill(javafx.scene.paint.Color.GREEN);
        });
        lTeam.setOnMouseExited(event -> {
            lTeam.setTextFill(javafx.scene.paint.Color.BLACK);
        });

        lGame.setTranslateX(305);
        lGame.setTranslateY(365);
        lGame.setScaleX(2);
        lGame.setScaleY(2);
        lGame.setOnMouseEntered(event -> {
            lGame.setTextFill(javafx.scene.paint.Color.GREEN);
        });
        lGame.setOnMouseExited(event -> {
            lGame.setTextFill(javafx.scene.paint.Color.BLACK);
        });

        lStat.setTranslateX(305);
        lStat.setTranslateY(400);
        lStat.setScaleX(2);
        lStat.setScaleY(2);
        lStat.setOnMouseEntered(event -> {
            lStat.setTextFill(javafx.scene.paint.Color.GREEN);
        });
        lTeam.setOnMouseExited(event -> {
            lStat.setTextFill(javafx.scene.paint.Color.BLACK);
        });

        stage.setTitle("Main Menu");
        root.getChildren().addAll(owlLabel, lTeam, lGame, lStat);
        stage.setScene(new Scene(root, 700, 800));
        stage.show();
    }
}