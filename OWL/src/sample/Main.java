package sample;

        import javafx.application.Application;
        import javafx.stage.Stage;

public class Main extends Application {

    private sample.Application app = new sample.Application();

    @Override
    public void start(Stage primaryStage) throws Exception{
        app.toLogIn(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
