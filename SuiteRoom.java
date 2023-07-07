public class SuiteRoom extends Room {
    public SuiteRoom(int number, String type) {
        super(number, type);
    }

    @Override
    public String getType() {
        return "Suite Room";
    }
}
