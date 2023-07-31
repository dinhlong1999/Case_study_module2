package resort_furama.service.facility;

import resort_furama.model.facilities.Facility;
import resort_furama.repository.facility.FacilityRepository;
import resort_furama.repository.facility.IFacilityRepository;

import java.util.Map;

public class FacilityService implements IFacilityService{
    private IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void displayFacility() {
        Map<Facility, Integer> displayFacility = facilityRepository.displayListFacility();
        for (Map.Entry<Facility, Integer> entry: displayFacility.entrySet()) {
            System.out.println(entry.getKey()+ ". Number of uses: "  + entry.getValue());
        }
    }

    @Override
    public void addFacility() {
        System.out.println("------MENU ADD FACILITY");
    }

    @Override
    public void displayListMaintenance() {
    Map<Facility, Integer> displayListMaintenance = facilityRepository.displayListMaintenance();
        for (Map.Entry<Facility, Integer> facilityIntegerEntry: displayListMaintenance.entrySet()) {
            System.out.println(facilityIntegerEntry.getKey() + ". Number of uses : " + facilityIntegerEntry.getValue());
        }
    }

    @Override
    public void deleteFacility() {

    }
}
