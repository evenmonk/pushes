package pushes;

public class LocationPush extends Push{
    private float x;
    private float y;
    private int radius;
    private long expiryDate;

    public LocationPush(String text, float x, float y, int radius, long expiryDate){
        super(text, PushType.LocationPush);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.expiryDate = expiryDate;
    }
}
