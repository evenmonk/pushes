package pushes;

public enum Gender {
    Male,
    Female;

    public static Gender parse(String gender) {
        return gender.equals("m") ? Male : Female;
    }
}
