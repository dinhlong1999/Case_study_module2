package resort_furama.model.facilities;

public class Room extends Facility {
    private String service;

    public Room(String id, String name, Double usableArea, int rentalCosts, int maxPeople, String typeRental, String service) {
        super(id, name, usableArea, rentalCosts, maxPeople, typeRental);
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return " Room : " + super.toString() + " service =" + service;
    }
}
