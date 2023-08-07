package resort_furama.repository.booking;

import resort_furama.model.booking.Booking;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class BookingRepository implements IBookingRepository {
    private static final Set<Booking> bookings = new TreeSet<>();

    static {
        Booking booking1 = new Booking("Booking-001", LocalDate.parse("2023-08-25"),
                LocalDate.parse("2023-09-01"), LocalDate.parse("2023-09-03"),
                "KH-0001", "SVVL-0001");
        Booking booking2 = new Booking("Booking-002", LocalDate.parse("2023-08-27"),
                LocalDate.parse("2023-09-05"), LocalDate.parse("2023-09-07"),
                "KH-0002", "SVHO-0002");
        Booking booking3 = new Booking("Booking-003", LocalDate.parse("2023-08-29"),
                LocalDate.parse("2023-09-07"), LocalDate.parse("2023-09-09"),
                "KH-0003", "SVRO-0003");

        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);

    }

    @Override
    public void addNewBooking(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public Set<Booking> showAllBooking() {
        return bookings;
    }

    @Override
    public void deleteBooking(String idBooking) {
        for (Booking booking : bookings) {
            if (booking.getIdBooking().equals(idBooking)) ;
            bookings.remove(booking);
            break;

        }
    }
}
