public class BoxCoordinates {
    int startX;

    int startY;
    //maintain the coordinates in the store for a box - based on where it is placed.
    Box box;

    //this class maintains the starting coordinates when a box is accepted and stored
    // this is to later clear up the space after duration and to track space availability.
    public BoxCoordinates(int x, int y,Box box)
    {
        this.startX = x;
        this.startY = y;
        this.box = box;
    }
}
