import java.util.Calendar;
import java.util.Scanner;
import java.time.LocalDateTime; // import the LocalDateTime class

public class Administrator {
    public static void main(String[] args) {
        HotelManagementSystem hotelSystem = new HotelManagementSystem();

        Scanner scanner = new Scanner(System.in);

        // Ingresar la cantidad de habitaciones de cada tipo
        System.out.print("Ingrese la cantidad de habitaciones estándar: ");
        int standardRoomCount = scanner.nextInt();

        System.out.print("Ingrese la cantidad de habitaciones de lujo: ");
        int deluxeRoomCount = scanner.nextInt();

        System.out.print("Ingrese la cantidad de suites: ");
        int suiteRoomCount = scanner.nextInt();

        // Crear las habitaciones según la cantidad ingresada
        for (int i = 1; i <= standardRoomCount; i++) {
            Room room = new StandardRoom(i, "Habitación Estándar");
            hotelSystem.addRoom(room);
        }

        for (int i = 1; i <= deluxeRoomCount; i++) {
            Room room = new DeluxeRoom(i, "Habitación de Lujo");
            hotelSystem.addRoom(room);
        }

        for (int i = 1; i <= suiteRoomCount; i++) {
            Room room = new SuiteRoom(i, "Suite");
            hotelSystem.addRoom(room);
        }

        // Crear una instancia del administrador del hotel
        HotelAdministrator admin = new HotelAdministrator(hotelSystem);

        // Iniciar sesión como administrador
        boolean loggedIn = admin.login();
        if (!loggedIn) {
            System.out.println("Inicio de sesión fallido. El programa finalizará.");
        }

        // Menú del administrador
        int choice;
        do {
            System.out.println("\n--- Menú del Administrador ---");
            System.out.println("1. Agregar reserva");
            System.out.println("2. Mostrar habitaciones ocupadas");
            System.out.println("3. Mostrar habitaciones disponibles");
            System.out.println("4. Cantidad de Invitados");
            System.out.println("0. Salir");
            System.out.print("Ingrese su elección: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    admin.addReservation(scanner);
                    break;
                case 2:
                    admin.displayOccupiedRooms();
                    break;
                case 3:
                    admin.displayAvailableRooms();
                    break;
                case 4:
                    admin.displayGuestCount();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Elección inválida. Inténtelo nuevamente.");
            }
        } while (choice != 0);
    }
}

class HotelAdministrator {
    private HotelManagementSystem hotelSystem;

    public HotelAdministrator(HotelManagementSystem hotelSystem) {
        this.hotelSystem = hotelSystem;
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Inicio de Sesión del Administrador ---");

        System.out.print("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String password = scanner.nextLine();

        scanner.close();

        // Verificar las credenciales
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Inicio de sesión fallido. Credenciales incorrectas.");
        }

        return isAuthenticated;
    }

    public void addReservation(Scanner scanner) {
        System.out.println("--- Agregar Reserva ---");

        // Obtener los detalles de la reserva
        System.out.print("Ingrese el número de habitación: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de la entrada

        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        Calendar startDate = parseDate(startDateStr);

        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();
        Calendar endDate = parseDate(endDateStr);

        System.out.print("Ingrese el nombre del huésped: ");
        String guestName = scanner.nextLine();

        System.out.print("Ingrese el DNI del huésped: ");
        String guestDNI = scanner.nextLine();

        System.out.print("Ingrese el origen del huésped: ");
        String guestOrigin = scanner.nextLine();

        System.out.print("Ingrese el domicilio de origen del huésped: ");
        String guestAddress = scanner.nextLine();

        // Crear el objeto Guest y Reservation
        Guest guest = new Guest(guestName, guestDNI, guestOrigin, guestAddress);
        Room room = hotelSystem.getRoomByNumber(roomNumber); // Obtiene el numero de la habitacion solicitada (Cargar
                                                             // previamente en archivo main o ingresar aca por metodo
                                                             // scanner)
        LocalDateTime tiempodereserva = LocalDateTime.now();

        if (room == null) {
            System.out.println("El número de habitación ingresado no existe. La reserva no se pudo agregar.");
            return;
        }

        Reservation reservation = new Reservation(room, startDate.getTime(), endDate.getTime(), guest, tiempodereserva); // Indefinido
        // arreglar
        hotelSystem.addReservation(reservation);

        System.out.println("Reserva agregada exitosamente.");
    }

    private Calendar parseDate(String dateStr) {
        Calendar calendar = Calendar.getInstance();
        String[] parts = dateStr.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1; // Los meses en Calendar comienzan desde 0
        int day = Integer.parseInt(parts[2]);
        calendar.set(year, month, day);
        return calendar;
    }

    public void displayOccupiedRooms() {
        Room[] occupiedRooms = hotelSystem.getOccupiedRooms();
        System.out.println("--- Habitaciones Ocupadas ---");
        for (Room room : occupiedRooms) {
            System.out.println("Habitación " + room.getNumber() + " - Tipo: " + room.getType());
        }
    }

    public void displayAvailableRooms() {
        Room[] availableRooms = hotelSystem.getAvailableRooms();
        System.out.println("--- Habitaciones Disponibles ---");
        for (Room room : availableRooms) {
            System.out.println("Habitación " + room.getNumber() + " - Tipo: " + room.getType());
        }
    }

    public void displayGuestCount() {
        int guestCount = hotelSystem.getGuestCount();
        System.out.println("Cantidad de guests: " + guestCount);
    }

    // Metodo de autenticacion
    private boolean authenticate(String username, String password) {
        // implementar logica con exceptions
        return username.equals("admin") && password.equals("password"); // admin y password son las credenciales por
                                                                        // defecto
    }
}
