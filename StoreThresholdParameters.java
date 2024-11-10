import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoreThresholdParameters {

    private double avgRentPerUnitPerDay;
    private double stdDeviation;

    private List<Box> pastData;

    public StoreThresholdParameters(){
        pastData = new ArrayList<>();
        simulatePastData();
    }

    public double getAvgRentPerUnitPerDay() {
        return avgRentPerUnitPerDay;
    }

    public double getStdDeviation() {
        return stdDeviation;
    }

    private void simulatePastData(){
        Random rand = new Random();

        double sum = 0.0;
        double squareSum = 0.0;
        int count = 30;
        //simulating past data
        for(int i=0;i<30;i++) {
            int x = rand.nextInt(10) + 1;
            int y = rand.nextInt(10) + 1;
            int duration = rand.nextInt(7) + 1;
            int rent = (10 + rand.nextInt(10) + 10);
            pastData.add(new Box(x,y,rent,duration));
            double rentPerUnitPerDay = (double) (rent)/(x*y*duration);
            sum+=rentPerUnitPerDay;
            squareSum +=(rentPerUnitPerDay * rentPerUnitPerDay);
        }
        //avg rent per day
        avgRentPerUnitPerDay=sum/30;
       // System.out.println("dev "+avgRentPerUnitPerDay+" "+squareSum+" "+count);
        // standard deviation to allow some swing
        stdDeviation = Math.sqrt((squareSum / count) - ( avgRentPerUnitPerDay*avgRentPerUnitPerDay));
        //System.out.println("sdev "+stdDeviation+" "+((squareSum / count)-( avgRentPerUnitPerDay*avgRentPerUnitPerDay)));

    }

}
