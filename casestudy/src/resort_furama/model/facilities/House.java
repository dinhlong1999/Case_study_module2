package resort_furama.model.facilities;

public class House  extends Facility {
    private String roomStandard;
    private int floor;

    public House(String id, String name, Double usableArea, int rentalCosts, int maxPeople, String typeRental, String roomStandard, int floor) {
        super(id, name, usableArea, rentalCosts, maxPeople, typeRental);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House : " + super.toString() + " roomStandard = " + roomStandard + " , " + "floor = " + floor;
    }
}
