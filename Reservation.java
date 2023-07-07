import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private Room room;
    private Date startDate;
    private Date endDate;
    private Guest guest;
    private LocalDate reservationTimeStamp;

    public Reservation(Room room, Date startDate, Date endDate, Guest guest, LocalDate reservationTimeStamp) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.reservationTimeStamp = LocalDate.now();
    }

    public Room getRoom() {
        return room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getReservationTimeStamp() {
        return reservationTimeStamp;
    }
}
