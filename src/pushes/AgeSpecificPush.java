package pushes;

public class AgeSpecificPush extends Push{
    private int age;
    private long expiryDate;

    public AgeSpecificPush(String text, int age, long expiryDate) {
        super(text, PushType.AgeSpecificPush);
        this.age = age;
        this.expiryDate = expiryDate;
    }
}
