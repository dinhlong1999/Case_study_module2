package resort_furama.model.booking;

import java.time.LocalDate;
import java.util.Objects;

public class Booking implements Comparable<Booking>{
    private String idBooking;
    private LocalDate dayBooking;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String idCustomer;
    private String idService;

    public Booking() {
    }

    public Booking(String idBooking, LocalDate dayBooking, LocalDate checkIn, LocalDate checkOut, String idCustomer, String idService) {
        this.idBooking = idBooking;
        this.dayBooking = dayBooking;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getDayBooking() {
        return dayBooking;
    }

    public void setDayBooking(LocalDate dayBooking) {
        this.dayBooking = dayBooking;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", dayBooking=" + dayBooking +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", idCustomer='" + idCustomer + '\'' +
                ", idService='" + idService + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(idBooking, booking.idBooking) && Objects.equals(dayBooking, booking.dayBooking) && Objects.equals(checkIn, booking.checkIn) && Objects.equals(checkOut, booking.checkOut) && Objects.equals(idCustomer, booking.idCustomer) && Objects.equals(idService, booking.idService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, dayBooking, checkIn, checkOut, idCustomer, idService);
    }

    @Override
    public int compareTo(Booking o) {
        return this.getIdBooking().compareTo(o.getIdBooking());

        }
    }

