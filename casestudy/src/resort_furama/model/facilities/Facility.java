package resort_furama.model.facilities;

public abstract class Facility {
    private String id;
    private String name;
    private Double usableArea;
    private int rentalCosts;
    private int maxPeople;
    private String typeRental;

     public Facility(String id, String name, Double usableArea, int rentalCosts, int maxPeople, String typeRental) {
          this.id = id;
          this.name = name;
          this.usableArea = usableArea;
          this.rentalCosts = rentalCosts;
          this.maxPeople = maxPeople;
          this.typeRental = typeRental;
     }

    public Facility() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeRental() {
        return typeRental;
    }

    public void setTypeRental(String typeRental) {
        this.typeRental = typeRental;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", usableArea =" + usableArea +
                ", rentalCosts =" + rentalCosts +
                ", maxPeople = " + maxPeople +
                ", typeRental= " + typeRental ;

    }
}
