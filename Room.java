public abstract class Room {
    private int number;
    private String type;
    private String status;

    public Room(int number, String type) {
        this.number = number;
        this.type = type;
        this.status = "Available";
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public boolean isOccupied() {
        return status.equals("Occupied");
    }

    public boolean isAvailable() {
        return status.equals("Available");
    }

    public void setOccupied() {
        status = "Occupied";
    }

    public void setAvailable() {
        status = "Available";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
