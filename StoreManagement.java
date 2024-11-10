import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreManagement {
    private static int daysCounter = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            //store dimensions.
            int storeX = 5;
            int storeY = 5;

            //initiate store and allocator to allocate incoming boxes
            StoreAllocation allocator = new StoreAllocation(storeX, storeY);

            while(true) {
                System.out.print("Please provide box dimensions: x y");
                System.out.println();
                String[] dimensions = br.readLine().split(" ");
                System.out.println("Please enter rent:");
                int rent = Integer.parseInt(br.readLine());
                System.out.println("Please enter duration for storage:");
                int duration = Integer.parseInt(br.readLine());
                Box newBox = new Box(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]), rent, duration);
                System.out.println(allocator.canAccept(daysCounter, newBox));
                daysCounter++;
            }
        } catch (IOException e) {
            throw new IOException(e);
        }



    }
}
