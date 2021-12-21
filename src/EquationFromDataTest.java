
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.scene.chart.XYChart;
public class EquationFromDataTest {
    @Test
    public void testPlus(){
        double minX, maxX ;
        String function;
        minX = 7;
        maxX = 10;
        function = "x + 1";

        EquationFromData eq = new EquationFromData();
        List<XYChart.Data<String,Number>> testOutput = eq.getData(minX, maxX, function);
        
         List<XYChart.Data<String,Number>> expectedResult = new ArrayList<XYChart.Data<String,Number>>();
         expectedResult.add(new XYChart.Data<>("7",8.0)) ;
         expectedResult.add(new XYChart.Data<>("8",9.0)) ;
         expectedResult.add(new XYChart.Data<>("9",10.0)) ;
         expectedResult.add(new XYChart.Data<>("10",11.0)) ;

         for(int i = 0; i < 4 ;i++ ){
             assertEquals(testOutput.get(i).getYValue(), expectedResult.get(i).getYValue() ); 
         }

    }

    @Test
    public void testMinus(){
        double minX, maxX ;
        String function;
        minX = 7;
        maxX = 10;
        function = "x - 1";

        EquationFromData eq = new EquationFromData();
        List<XYChart.Data<String,Number>> testOutput = eq.getData(minX, maxX, function);
        
         List<XYChart.Data<String,Number>> expectedResult = new ArrayList<XYChart.Data<String,Number>>();
         expectedResult.add(new XYChart.Data<>("7",6.0)) ;
         expectedResult.add(new XYChart.Data<>("8",7.0)) ;
         expectedResult.add(new XYChart.Data<>("9",8.0)) ;
         expectedResult.add(new XYChart.Data<>("10",9.0)) ;

         for(int i = 0; i < 4 ;i++ ){
             assertEquals(testOutput.get(i).getYValue(), expectedResult.get(i).getYValue() ); 
         }

    }


    @Test
    public void testMultibly(){
        double minX, maxX ;
        String function;
        minX = 7;
        maxX = 10;
        function = "x * 2";

        EquationFromData eq = new EquationFromData();
        List<XYChart.Data<String,Number>> testOutput = eq.getData(minX, maxX, function);
        
         List<XYChart.Data<String,Number>> expectedResult = new ArrayList<XYChart.Data<String,Number>>();
         expectedResult.add(new XYChart.Data<>("7",14.0)) ;
         expectedResult.add(new XYChart.Data<>("8",16.0)) ;
         expectedResult.add(new XYChart.Data<>("9",18.0)) ;
         expectedResult.add(new XYChart.Data<>("10",20.0)) ;

         for(int i = 0; i < 4 ;i++ ){
             assertEquals(testOutput.get(i).getYValue(), expectedResult.get(i).getYValue() ); 
         }

        }  



        @Test
        public void testDivide(){
        double minX, maxX ;
        String function;
        minX = 7;
        maxX = 10;
        function = "x / 2";

        EquationFromData eq = new EquationFromData();
        List<XYChart.Data<String,Number>> testOutput = eq.getData(minX, maxX, function);
        
         List<XYChart.Data<String,Number>> expectedResult = new ArrayList<XYChart.Data<String,Number>>();
         expectedResult.add(new XYChart.Data<>("7",3.5)) ;
         expectedResult.add(new XYChart.Data<>("8",4.0)) ;
         expectedResult.add(new XYChart.Data<>("9",4.5)) ;
         expectedResult.add(new XYChart.Data<>("10",5.0)) ;

         for(int i = 0; i < 4 ;i++ ){
             assertEquals(testOutput.get(i).getYValue(), expectedResult.get(i).getYValue() ); 
         }
        }
    
        @Test
        public void testPower(){
        double minX, maxX ;
        String function;
        minX = 7;
        maxX = 10;
        function = "x ^ 2";

        EquationFromData eq = new EquationFromData();
        List<XYChart.Data<String,Number>> testOutput = eq.getData(minX, maxX, function);
        
         List<XYChart.Data<String,Number>> expectedResult = new ArrayList<XYChart.Data<String,Number>>();
         expectedResult.add(new XYChart.Data<>("7",49.0)) ;
         expectedResult.add(new XYChart.Data<>("8",64.0)) ;
         expectedResult.add(new XYChart.Data<>("9",81.0)) ;
         expectedResult.add(new XYChart.Data<>("10",100.0)) ;

         for(int i = 0; i < 4 ;i++ ){
             assertEquals(testOutput.get(i).getYValue(), expectedResult.get(i).getYValue() ); 
         }

    }
     public static void main(String[] args) {
        
        EquationFromDataTest test = new EquationFromDataTest();
        test.testPlus();
        test.testMinus();
        test.testMultibly();
        test.testDivide();
        test.testPower();
    }
    
}
