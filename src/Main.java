import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage stage;
    private int height = 600;
    private int width = 900;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene/Main.fxml"));
        this.stage = stage;
        stage.setScene(new Scene(root));
        stage.show();
        stage.setWidth(width);
        stage.setHeight(height);
    }
}