import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.XYChart;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class EquationFromData {
    


    public EquationFromData() {
    }

    public List<XYChart.Data<String,Number>> getData(double minX ,double maxX , String func){
        List<XYChart.Data<String,Number>> result = new ArrayList<>();

        for(double x = minX; x <= maxX; x++){
            try {
                Expression expression = new ExpressionBuilder(func)
        .variables("x")
        .build()
        .setVariable("x", x);

      double d = expression.evaluate();
   
            result.add(new XYChart.Data<>(String.valueOf(x), d));
            } catch (Exception e) {
                result = null;
                break;
            }
        }
        return result;

    }
}
