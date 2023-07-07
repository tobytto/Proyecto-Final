public class Guest {
    private String name;
    private String dni;
    private String origin;
    private String address;

    public Guest(String name, String dni, String origin, String address) {
        this.name = name;
        this.dni = dni;
        this.origin = origin;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public String getOrigin() {
        return origin;
    }

    public String getAddress() {
        return address;
    }
}
