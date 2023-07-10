import java.util.Date;
import java.time.LocalDateTime; // import the LocalDateTime class

public class Reservation {
    private Room room;
    private Date startDate;
    private Date endDate;
    private Guest guest;
    private LocalDateTime reservationTimeStamp;

    public Reservation(Room room, Date startDate, Date endDate, Guest guest, LocalDateTime reservationTimeStamp) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.reservationTimeStamp = reservationTimeStamp;
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

    public LocalDateTime getReservationTimeStamp() {
        return reservationTimeStamp;
    }
}
