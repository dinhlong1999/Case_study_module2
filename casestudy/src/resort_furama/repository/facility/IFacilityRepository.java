package resort_furama.repository.facility;

import resort_furama.model.facilities.Facility;
import resort_furama.model.facilities.House;
import resort_furama.model.facilities.Room;
import resort_furama.model.facilities.Villa;

import java.util.LinkedHashMap;
import java.util.Map;

public interface IFacilityRepository {
    Map<Facility, Integer> displayListFacility();
    void add(Facility facility);

    Map<Facility, Integer> displayListMaintenance();

    void deleteFacility(Facility facility);

}
