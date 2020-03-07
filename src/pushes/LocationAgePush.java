package pushes;

public class LocationAgePush extends Push{
    private float x;
    private float y;
    private int radius;
    private  int age;

    public LocationAgePush(String text, float x, float y, int radius, int age) {
        super(text, PushType.LocationAgePush);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.age = age;
    }
}
