public class StandardRoom extends Room {
    public StandardRoom(int number, String type) {
        super(number, type);
    }

    @Override
    public String getType() {
        return "Standard Room";
    }
}
