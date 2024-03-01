package org.session6;

public class User {
    private final String userName;
    private final String userRole;
    private final boolean userState;

    public User(String userName, String userRole, boolean userState) {
        this.userName = userName;
        this.userRole = userRole;
        this.userState = userState;
    }

    public static User generateAdmin() {
        return generateUser("TestAdmin");
    }

    public static User generateUser() {
        return generateUser("TestAdmin");
    }

    public static User generateGuest() {
        return generateUser("TestAdmin");
    }

    public static User generateUser(String userName) {
        return generateUser(userName, "Admin");
    }

    public static User generateUser(String userName, String userRole) {
        return generateUser(userName, userRole, true);
    }

    public static User generateUser(String userName, String userRole, boolean state) {
        return new User(userName, userRole, state);
    }
}
