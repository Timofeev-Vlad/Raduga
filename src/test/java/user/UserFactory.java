package user;

import utils.PropertyReader;

public class UserFactory {

    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("raduga.user"), PropertyReader.getProperty("raduga.password"));
    }
    public static User withWrongPassword() {
        return new User(PropertyReader.getProperty("raduga.user"), PropertyReader.getProperty("raduga.wrongpassword"));
    }
}
