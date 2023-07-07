public class User extends Guest {
    private String username;
    private String password;
    private String role;
    private boolean canMakeReservations;

    public User(String name, String dni, String origin, String address, String username, String password, String role,
            boolean canMakeReservations) {
        super(name, dni, origin, address);
        this.username = username;
        this.password = password;
        this.role = role;
        this.canMakeReservations = canMakeReservations;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean canMakeReservations() {
        return canMakeReservations;
    }
}
