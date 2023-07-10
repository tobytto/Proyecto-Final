import java.util.ArrayList;
import java.util.List;

public class HotelManagementSystem {
    private List<Room> rooms; // Lista de habitaciones del hotel
    private List<Reservation> reservations; // Lista de reservas realizadas

    public HotelManagementSystem() {
        rooms = new ArrayList<>(); // Inicializar la lista de habitaciones
        reservations = new ArrayList<>(); // Inicializar la lista de reservas
    }

    public void addRoom(Room room) {
        rooms.add(room); // Agregar una habitación a la lista de habitaciones
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation); // Agregar una reserva a la lista de reservas
    }

    public Room[] getOccupiedRooms() {
        List<Room> occupiedRooms = new ArrayList<>();
        for (Reservation reservation : reservations) {
            occupiedRooms.add(reservation.getRoom()); // Obtener las habitaciones ocupadas a partir de las reservas
        }
        return occupiedRooms.toArray(new Room[0]); // Devolver las habitaciones ocupadas como un arreglo
    }

    public Room[] getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!isRoomOccupied(room)) {
                availableRooms.add(room); // Obtener las habitaciones disponibles que no están ocupadas
            }
        }
        return availableRooms.toArray(new Room[0]); // Devolver las habitaciones disponibles como un arreglo
    }

    public int getGuestCount() {
        List<Guest> guests = new ArrayList<>();
        for (Reservation reservation : reservations) {
            guests.add(reservation.getGuest()); // Obtener los huéspedes a partir de las reservas
        }
        return guests.size(); // Devolver la cantidad de huéspedes
    }

    private boolean isRoomOccupied(Room room) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().equals(room)) {
                return true; // Verificar si una habitación está ocupada por medio de las reservas
            }
        }
        return false;
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
            // Logica para recuperar el numero de la habitacion y ver si esta disponible en
            // archivo administrador
        }
        {
            return null;
        }
    }

}
