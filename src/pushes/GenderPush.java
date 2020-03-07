package pushes;

public class GenderPush extends Push {
    private Gender gender;

    public GenderPush(String text, Gender gender) {
        super(text, PushType.GenderPush);
        this.gender = gender;
    }
}
