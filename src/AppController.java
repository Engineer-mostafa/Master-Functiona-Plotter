import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;



public class AppController  implements Initializable{

     EquationFromData qEquationFromData;

     
    // void setQEquationFromData(EquationFromData q){
    //     qEquationFromData = q;
    // }

    // EquationFromData getEquationFromData(){
    //     return qEquationFromData;
    // }
    @FXML
    private Pane AppController;

    @FXML
    private Button plot;

    @FXML
    private TextField fx;

    @FXML
    private TextField min;

    @FXML
    private TextField max;

    @FXML
    private ProgressBar progress;

    @FXML
    private LineChart<String,Number> graph;

    @FXML
    private ProgressBar hidePbar;

    @FXML
    public void plot(ActionEvent event){
        String fxS = fx.getText();
        String minS = min.getText();
        String maxS = max.getText();
        Alert alert = new Alert(AlertType.ERROR);

        // check for the first field
        
        if(fxS.isEmpty())
        {
            alert.setContentText("You have to fill function field First with real data");
            alert.showAndWait();
            return;

        }else{
            progress.setProgress(0.6);
        }

    
       


        // check for the minimum filed 
        try {
            if(minS.isEmpty())
        {
            alert.setContentText("You have to fill minimum field First with real data");
            alert.showAndWait();
            return;

        }else{
            Double.parseDouble(minS);
            progress.setProgress(0.6);
            
        }

        } catch (Exception e) {
            alert.setContentText("You have to fill minimum field First with real data");
            alert.showAndWait();
            return;
        }
        
        // check for maximum field
        try {
            if(maxS.isEmpty())
            {
                // -- interface
                alert.setContentText("You have to fill maximum field First");
                alert.showAndWait();
                progress.setProgress(0.6);
                return;
    
            }else{
                progress.setProgress(1);
                Double.parseDouble(maxS);
            }
        } catch (Exception e) {
            alert.setContentText("You have to fill maximum field First");
            alert.showAndWait();
        }
       
        double min , max ;
        min = Double.valueOf(minS);
        max = Double.valueOf(maxS);

        // if minimum > maximum
        if( min > max){
            alert.setContentText("How come minimum > maximum !?");
            alert.showAndWait();
            progress.setProgress(0.6);
            return;
        }
        List<XYChart.Data<String,Number>> xy = new ArrayList<XYChart.Data<String,Number>>();

        qEquationFromData = new EquationFromData();

        xy = qEquationFromData.getData(min , max , fxS);

        // check if we have any error with function that passed 
        if(xy == null) {
            alert.setContentText("Check your function again \n\nsome notes:- \n"+
            "1- you have to choose variable x only within the equation\n"+
            "2- variable x should be small\n" +
            "3- if you but x in denominator check your range to exclude 0 minimum x > 0\n\n" +
            "if your function is correct, then we don't support this function now");
            alert.showAndWait();
            return;
        }

        // add data to line chart
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>(); 
        for(int i = 0 ; i < xy.size(); i++){
            series.getData().add(xy.get(i));
        }
        graph.getData().add(series);
    }

    

   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
}
