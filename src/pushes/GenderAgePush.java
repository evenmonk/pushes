package pushes;

public class GenderAgePush extends Push {
    private Gender gender;
    private int age;

    public GenderAgePush(String text, Gender gender, int age) {
        super(text, PushType.GenderAgePush);
        this.gender = gender;
        this.age = age;
    }
}
