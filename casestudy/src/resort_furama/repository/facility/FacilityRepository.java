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
        Facility house1 = new House("SVHO-1111", "House-1", 100.0, 3500000, 5, "Day", "Luxury", 2);
        Facility house2 = new House("SVHO-2222", "HOUSE-2", 120.0, 4200000, 7, "Day", "Premium", 3);
        Facility villa1 = new Villa("SVVL-3333", "VILLA-1", 90.0, 2000000, 2, "Day", "Luxury", 20.5, 1);
        Facility villa2 = new Villa("SVVL-4444", "VILLA-2", 95.5, 2500000, 4, "Day", "Premium", 35.0, 2);
        Facility room1 = new Room("SVRO-5555", "ROOM-1", 40.0, 1500000, 2, "Day", "fruit-water");
        Facility room2 = new Room("SVRO-6666", "ROOM-2", 35.5, 1700000, 3, "Day", "massage");
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
       facilityMap.remove(facility);
    }

    @Override
    public boolean checkFacility(Facility facility) {
        if (facilityMap.containsKey(facility)){
            return true;
        }
        return false;
    }

    @Override
    public Facility getById(String id) {
        for (Map.Entry<Facility, Integer> entry: facilityMap.entrySet()) {
            if (entry.getKey().getId().equals(id)){
               return entry.getKey();
            }
        }
        return null;
    }


}
