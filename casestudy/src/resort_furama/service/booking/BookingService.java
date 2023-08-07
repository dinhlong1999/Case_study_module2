package resort_furama.service.booking;

import resort_furama.model.booking.Booking;
import resort_furama.repository.booking.BookingRepository;
import resort_furama.repository.booking.IBookingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class BookingService implements IBookingService {
    private static IBookingRepository bookingRepository = new BookingRepository();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addNewBooking() {
        System.out.println("Enter ID booking ");
        String idBooking = scanner.nextLine();
        System.out.println("Enter day booking");
        LocalDate dayBooking = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter day check-in");
        LocalDate dayCheckIn = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter day check-out");
        LocalDate dayCheckOut = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter ID of customer");
        String idCustomer = scanner.nextLine();
        System.out.println("Enter ID of service");
        String idService = scanner.nextLine();
        Booking booking = new Booking(idBooking,dayBooking,dayCheckIn,dayCheckOut,idCustomer,idService);
        bookingRepository.addNewBooking(booking);
    }

    @Override
    public void showAllBooking() {
        Set<Booking> bookings = bookingRepository.showAllBooking();
        for (Booking booking: bookings) {
            System.out.println(booking);
        }
    }

    @Override
    public void deleteBooking() {
        System.out.println("Enter ID booking to delete");
        String idDelete = scanner.nextLine();
        bookingRepository.deleteBooking(idDelete);
    }
}
