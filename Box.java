public class Box {
    private int x;

    private int y;
    private int rent;
    private int duration;
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRent() {
        return rent;
    }

    public int getDuration() {
        return duration;
    }

    public Box(int _x, int _y, int _rent,int _duration)
    {
        this.x = _x;
        this.y = _y;
        this.rent = _rent;
        this.duration = _duration;
    }


}
