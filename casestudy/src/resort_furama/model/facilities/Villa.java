package resort_furama.model.facilities;

public class Villa extends Facility {
    private String roomStandard;
    private double poolArea;
    private int floor;


    public Villa(String id, String name, Double usableArea, int rentalCosts, int maxPeople, String typeRental, String roomStandard, double poolArea, int floor) {
        super(id, name, usableArea, rentalCosts, maxPeople, typeRental);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa : " +super.toString() + " roomStandard = " +  roomStandard + " , "
               + " poolArea = " + poolArea +" , " + "floor = "+ floor;
    }
}
