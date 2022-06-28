package pages;

public enum User {
    Alex("testUser","lt1TestPass#");
    private String login;
    private String password;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
