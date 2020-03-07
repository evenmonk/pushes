package pushes;

import java.util.*;

class SystemPropertyNames {
    public static final String Time = "time";
    public static final String Age = "age";
    public static final String Gender = "gender";
    public static final String OsVersion = "os_version";
    public static final String X = "x_coord";
    public static final String Y = "y_coord";
}

class SystemProperties{
    public long time;
    public int age;
    public Gender gender;
    public int osVersion;
    public float x;
    public float y;
}

class PushPropertiesNames {
    public static final String Text = "text";
    public static final String Type = "type";
    public static final String Age = "age";
    public static final String Gender = "gender";
    public static final String OsVersion = "os_version";
    public static final String Radius = "os_version";
    public static final String X = "x_coord";
    public static final String Y = "y_coord";
    public static final String ExpiryDate = "expiry_date";
}


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SystemProperties systemProperties = new SystemProperties();

        for (int i = 0; i < 6; i++) {
            String[] property = scanner.nextLine().split("\\s");
            switch (property[0]){
                case SystemPropertyNames.Time:
                    systemProperties.time = Long.parseLong(property[1]);
                    break;
                case SystemPropertyNames.Age:
                    systemProperties.age = Integer.parseInt(property[1]);
                    break;
                case SystemPropertyNames.Gender:
                    systemProperties.gender = Gender.parse(property[1]);
                    break;
                case SystemPropertyNames.OsVersion:
                    systemProperties.osVersion = Integer.parseInt(property[1]);
                    break;
                case SystemPropertyNames.X:
                    systemProperties.x = Float.parseFloat(property[1]);
                    break;
                case SystemPropertyNames.Y:
                    systemProperties.y = Float.parseFloat(property[1]);
                    break;
                default:
                    throw new MissingFormatArgumentException("Неправильный формат входных данных");
            }
        }

        int pushesCount = Integer.parseInt(scanner.nextLine());
        ArrayList<Push> pushes = new ArrayList<Push>();
        for (int i = 0; i < pushesCount; i++){
            Push push = ParsePush(scanner);

            if (push != null)
                pushes.add(push);
        }

        for (Push push : pushes) {
            System.out.println(push.text);
            System.out.println(push.type);
        }
    }

    private static Push ParsePush(Scanner scanner) {
        int pushPropertiesCount = Integer.parseInt(scanner.nextLine());
        Map<String, String> pushProperties = new HashMap<String, String>();

        for (int j = 0; j < pushPropertiesCount; j++){
            String[] property = scanner.nextLine().split("\\s");
            pushProperties.put(property[0], property[1]);
        }

        String pushType = pushProperties.get(PushPropertiesNames.Type);

        String text = pushProperties.get(PushPropertiesNames.Text);

        float x = Float.parseFloat(pushProperties.get(PushPropertiesNames.X));
        float y = Float.parseFloat(pushProperties.get(PushPropertiesNames.Y));
        int radius = Integer.parseInt(pushProperties.get(PushPropertiesNames.Radius));
        long expiryDate = Integer.parseInt(pushProperties.get(PushPropertiesNames.ExpiryDate));
        int age = Integer.parseInt(pushProperties.get(PushPropertiesNames.Age));
        int osVersion = Integer.parseInt(pushProperties.get(PushPropertiesNames.OsVersion));
        Gender gender = Gender.parse(pushProperties.get(PushPropertiesNames.Gender));

        if (pushType.equals(PushType.LocationPush.name()))
            return new LocationPush(text, x, y, radius, expiryDate);

        if (pushType.equals(PushType.AgeSpecificPush.name()))
            return new AgeSpecificPush(text, age, expiryDate);

        if (pushType.equals(PushType.TechPush.name()))
            return new TechPush(text, osVersion);

        if (pushType.equals(PushType.LocationAgePush.name()))
            return new LocationAgePush(text, x, y, radius, age);

        if (pushType.equals(PushType.GenderAgePush.name()))
            return new GenderAgePush(text, gender, age);

        if (pushType.equals(PushType.GenderPush.name()))
            return new GenderPush(text, gender);

        return null;
    }
}
