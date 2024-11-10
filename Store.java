import java.util.*;

public class Store {
    private int n;
    private int m;

    //maintain a map to know the allocation details at each endtime
    private Map<Integer, List<BoxCoordinates>> allocationDetails;
    public Store(int n, int m)
    {
        this.n = n;
        this.m = m;
        allocationDetails = new HashMap<>();
    }

    public boolean hasSpace(int currentDay, Box incomingBox){
        System.out.println("day "+currentDay);
        int endTime = currentDay + incomingBox.getDuration() - 1;// -1 to adjust for 0 indexing

        //each day few boxes may be taken back and clear up the space
        //so checking vacancy with the matrix
        boolean[][] vacancyMatrix = new boolean[this.n][this.m];

        //check map to know the details
        Iterator<Map.Entry<Integer,List<BoxCoordinates>>> iterator = allocationDetails.entrySet().iterator();
        //based on the expiry time, boxes are stored in the map.
        while(iterator.hasNext())
        {
            Map.Entry<Integer,List<BoxCoordinates>> entry = iterator.next();
            if(entry.getKey()<=endTime)
            {
                System.out.println("removing expired vals "+endTime);
                iterator.remove();
                continue;
            }
            //only mark the spaces occupied by non expired storage durations.
            for (BoxCoordinates box : entry.getValue()) {
                System.out.println("occupied "+box.startX+" "+box.startY);
                updateOccupancy(vacancyMatrix,box);
            }

        }

        for(int i=0;i<=n-incomingBox.getX();i++)
        {
            for(int j=0;j<=m-incomingBox.getY();j++)
            {
                //System.out.println("check1");
                //check for position to store the box
                if(notoccupied(i,j,incomingBox.getX(),incomingBox.getY(),vacancyMatrix)) {
                    BoxCoordinates newBox = new BoxCoordinates(i, j, incomingBox);
                    if (!allocationDetails.containsKey(endTime))
                    {
                        allocationDetails.put(endTime,new ArrayList<>());
                    }
                    allocationDetails.get(endTime).add(newBox);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean notoccupied(int curr_x, int curr_y,int x,int y,boolean[][] vacancyMatrix)
    {
        for(int i=curr_x;i<curr_x+x;i++)
        {
            for(int j=curr_y;j<curr_y+y;j++)
            {
                //System.out.println("check2");
                if(vacancyMatrix[i][j]) return false;
            }
        }
        return true;
    }
    public void updateOccupancy(boolean[][] vacancyMatrix,BoxCoordinates boxInfo)
    {
        for(int i=boxInfo.startX;i<boxInfo.startX+boxInfo.box.getX();i++)
        {
            for(int j=boxInfo.startY;j<boxInfo.startY+boxInfo.box.getY();j++)
            {
                vacancyMatrix[i][j]=true;
            }
        }
    }


}
