public class DeluxeRoom extends Room {
    public DeluxeRoom(int number, String type) {
        super(number, type);
    }

    @Override
    public String getType() {
        return "Deluxe Room";
    }
}
