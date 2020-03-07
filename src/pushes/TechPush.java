package pushes;

public class TechPush extends Push{
    private int osVersion;

    public TechPush(String text, int osVersion) {
        super(text, PushType.TechPush);
        this.osVersion = osVersion;
    }
}

