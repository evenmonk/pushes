package pushes;

public abstract class Push {
    String text;
    PushType type;

    public Push(String text, PushType type){
        this.text = text;
        this.type = type;
    }
}
