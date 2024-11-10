public class StoreAllocation {

    Store store;
    public StoreAllocation(int x,int y){
        store = new Store(x,y);
    }

    //calculate thershold after simulating past data with StoreThresholdParameters
    StoreThresholdParameters parameters = new StoreThresholdParameters();

    //Avg rent from past data
    double avgRentPerUnitPerDay = parameters.getAvgRentPerUnitPerDay();

    //std. deviation from past data
    double stdDeviation = parameters.getStdDeviation();


    public boolean canAccept(int currentTime,Box incomingBox){
            //check for space availability
            if(!store.hasSpace(currentTime,incomingBox)) {
                System.out.println("No available space");
                return false; }


           //get the current box's rent per unit per day
            double avgRentForCurrBox = (double)incomingBox.getRent()/(incomingBox.getX() * incomingBox.getY() * incomingBox.getDuration());

            double zscore = (avgRentForCurrBox - avgRentPerUnitPerDay)/stdDeviation;
            double acceptedZscore = -0.6;

            //System.out.println(currentBoxRentThreshold+" "+zscore+" "+stdDeviation+" "+avgRentPerUnitPerDay);
            if(zscore>acceptedZscore) return true;
            return false;
    }
}
