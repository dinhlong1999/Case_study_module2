package resort_furama.repository.booking;

import resort_furama.model.booking.Booking;

import java.util.List;
import java.util.Set;

public interface IBookingRepository {
    void addNewBooking(Booking booking);
    Set<Booking> showAllBooking();
    void deleteBooking(String idBooking);


}
