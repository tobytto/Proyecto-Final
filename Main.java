
/////Realizando cambios para hacerlo dinamico
public class Main {
    public static void main(String[] args) {

        // Crear una instancia del sistema de administración del hotel
        HotelManagementSystem hotelSystem = new HotelManagementSystem();

        // Obtener información del sistema
        Room[] occupiedRooms = hotelSystem.getOccupiedRooms();
        System.out.println("Habitaciones ocupadas:");
        for (Room room : occupiedRooms) {
            System.out.println("Habitación " + room.getNumber());
        }

        Room[] availableRooms = hotelSystem.getAvailableRooms();
        System.out.println("\nHabitaciones disponibles:");
        for (Room room : availableRooms) {
            System.out.println("Habitación " + room.getNumber());
        }

        // Obtener la cantidad de invitados
        int guestCount = hotelSystem.getGuestCount();
        System.out.println("\nCantidad de Invitados: " + guestCount);
    }
}
