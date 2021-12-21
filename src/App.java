
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class App  extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        try {
            
       // load design from scene builder
        Parent root = FXMLLoader.load(getClass().getResource("designPlotter.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    } 
        catch (Exception e) {
            
            // if we have any error with loading the desin
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("sorry!..Some thing went wrong");
            alert.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
