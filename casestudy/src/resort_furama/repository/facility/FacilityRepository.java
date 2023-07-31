package resort_furama.repository.facility;

import resort_furama.model.facilities.Facility;
import resort_furama.model.facilities.House;
import resort_furama.model.facilities.Room;
import resort_furama.model.facilities.Villa;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {

    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();


    static {
        Facility house1 = new House("SV-HO", "HOUSE 1", 100.0, 3500000, 5, "day", "LUXURY", 2);
        Facility house2 = new House("SV-HO", "HOUSE-2", 120.0, 4200000, 7, "day", "PREMIUM", 3);
        Facility villa1 = new Villa("SV-VL", "VILLA-1", 90.0, 2000000, 2, "day", "LUXURY", 20.5, 1);
        Facility villa2 = new Villa("SV-VL", "VILLA-2", 95.5, 2500000, 4, "day", "PREMIUM", 35.0, 2);
        Facility room1 = new Room("SV-RO", "ROOM-1", 40.0, 1500000, 2, "day", "fruit-water");
        Facility room2 = new Room("sv-RO", "ROOM-2", 35.5, 1700000, 3, "day", "massage");
        facilityMap.put(house1,3);
        facilityMap.put(house2,5);
        facilityMap.put(villa1,7);
        facilityMap.put(villa2,3);
        facilityMap.put(room1,3);
        facilityMap.put(room2,4);

    }

    @Override
    public Map<Facility, Integer> displayListFacility() {
      return facilityMap;
    }

    @Override
    public void add(Facility facility) {
        facilityMap.put(facility,0);
    }


    @Override
    public Map<Facility, Integer> displayListMaintenance() {
        Map<Facility, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Facility, Integer> key : facilityMap.entrySet()){
            if (key.getValue() >= 5){
                linkedHashMap.put(key.getKey(),key.getValue());
            }
        }
        return linkedHashMap;
    }

    @Override
    public void deleteFacility(Facility facility) {

    }

}
