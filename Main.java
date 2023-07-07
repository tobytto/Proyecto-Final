import java.util.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del sistema de administración del hotel
        HotelManagementSystem hotelSystem = new HotelManagementSystem();

        // Crear algunas habitaciones
        Room room1 = new StandardRoom(101, "Habitacion Standard");
        Room room2 = new DeluxeRoom(201, "Habitacion de lujo");
        Room room3 = new SuiteRoom(301, "Habitacion Suite");

        // Agregar las habitaciones al sistema
        hotelSystem.addRoom(room1);
        hotelSystem.addRoom(room2);
        hotelSystem.addRoom(room3);

        // Realizar algunas reservas
        Guest guest1 = new Guest("Juan Perez", "12345678", "Argentina", "Calle 123");
        Guest guest2 = new Guest("Maria Lopez", "87654321", "España", "Calle 456");

        Date startDate1 = new Date(2023, 6, 1);
        Date endDate1 = new Date(2023, 6, 5);

        Reservation reservation1 = new Reservation(room2, startDate1, endDate1, guest1, LocalDate.now());
        hotelSystem.addReservation(reservation1);

        Date startDate2 = new Date(2023, 6, 3);
        Date endDate2 = new Date(2023, 6, 7);

        Reservation reservation2 = new Reservation(room2, startDate2, endDate2, guest2, LocalDate.now());
        hotelSystem.addReservation(reservation2);

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

        // Obtener la cantidad de guests
        int guestCount = hotelSystem.getGuestCount();
        System.out.println("\nCantidad de guests: " + guestCount);
    }
}
