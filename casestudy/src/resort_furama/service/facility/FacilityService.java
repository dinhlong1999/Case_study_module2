package resort_furama.service.facility;

import resort_furama.controller.FuramaController;
import resort_furama.model.facilities.Facility;
import resort_furama.model.facilities.House;
import resort_furama.model.facilities.Room;
import resort_furama.model.facilities.Villa;
import resort_furama.repository.facility.FacilityRepository;
import resort_furama.repository.facility.IFacilityRepository;
import resort_furama.until.ReadAndWrite;
import resort_furama.until.Regex;
import resort_furama.until.TypeError;

import java.util.Map;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void displayFacility() {
        Map<Facility, Integer> displayFacility = facilityRepository.displayListFacility();
        for (Map.Entry<Facility, Integer> entry : displayFacility.entrySet()) {
            System.out.println(entry.getKey() + ". Number of uses: " + entry.getValue());
        }
    }

    @Override
    public void addFacility() {
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                int choice;
                System.out.println("-----------MENU ADD FACILITY----------");
                System.out.println("1. Add new Villa");
                System.out.println("2. Add new House");
                System.out.println("3. Add new Room");
                System.out.println("4. Back to menu");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        String id;
                        String name;
                        Double usableArea;
                        int rentalCosts;
                        int maxPeople;
                        String typeRental;
                        String roomStandard;
                        double poolArea;
                        int floor;
                        do {
                            System.out.println("Enter a ID Service");
                            id = scanner.nextLine();
                            if (!Regex.checkIdServiceVilla(id)) {
                                System.err.println(TypeError.ERROR_ID_VILLA);
                            }
                        } while (!Regex.checkIdServiceVilla(id));

                        do {
                            System.out.println("Enter name ");
                            name = scanner.nextLine();
                            if (!Regex.checkNameFacility(name)) {
                                System.err.println(TypeError.ERROR_NAME_SERVICE);
                            }
                        } while (!Regex.checkNameFacility(name));

                        do {
                            System.out.println("Enter  area uses:");
                            usableArea = Double.parseDouble(scanner.nextLine());
                            if (!Regex.checkArea(usableArea)) {
                                System.err.println(TypeError.ERROR_AREA);
                            }
                        } while (!Regex.checkArea(usableArea));

                        do {
                            System.out.println("Enter rentalCosts ");
                            rentalCosts = Integer.parseInt(scanner.nextLine());
                            if (!Regex.checkRentalCost(rentalCosts)) {
                                System.err.println(TypeError.ERROR_COST);
                            }
                        } while (!Regex.checkRentalCost(rentalCosts));

                        do {
                            System.out.println("Enter quality people");
                            maxPeople = Integer.parseInt(scanner.nextLine());
                            if (!Regex.checkMaxPeople(maxPeople)) {
                                System.err.println(TypeError.ERROR_PEOPLE);
                            }
                        } while (!Regex.checkMaxPeople(maxPeople));

                        do {
                            System.out.println("Enter type rental");
                            typeRental = scanner.nextLine();
                            if (!Regex.checkNameFacility(typeRental)) {
                                System.err.println(TypeError.ERROR_NAME);
                            }
                        } while (!Regex.checkNameFacility(typeRental));

                        do {
                            System.out.println("Enter room standard");
                            roomStandard = scanner.nextLine();
                            if (!Regex.checkNameFacility(roomStandard)) {
                                System.err.println(TypeError.ERROR_NAME);
                            }
                        } while (!Regex.checkNameFacility(typeRental));

                        do {
                            System.out.println("Enter pool area");
                            poolArea = Double.parseDouble(scanner.nextLine());
                            if (!Regex.checkArea(poolArea)) {
                                System.err.println(TypeError.ERROR_AREA);
                            }
                        } while (!Regex.checkArea(poolArea));

                        do {
                            System.out.println("Enter floor villa");
                            floor = Integer.parseInt(scanner.nextLine());
                            if (!Regex.checkFloor(floor)) {
                                System.err.println(TypeError.ERROR_FLOOR);
                            }
                        } while (!Regex.checkFloor(floor));

                        Villa villa = new Villa(id, name, usableArea, rentalCosts, maxPeople, typeRental, roomStandard, poolArea, floor);
                        facilityRepository.add(villa);
                        break;

                    case 2:
                        String idHouse;
                        String nameHouse;
                        Double usableAreaHouse;
                        int rentalCostHouse;
                        int maxPeopleHouse;
                        String typeRentalHouse;
                        String roomStandardHouse;
                        int floorHouse;
                        do {
                            System.out.println("Enter a ID of house  ");
                            idHouse = scanner.nextLine();
                            if (!Regex.checkIdServiceHouse(idHouse)) {
                                System.err.println(TypeError.ERROR_ID_HOUSE);
                            }
                        } while (!Regex.checkIdServiceHouse(idHouse));

                        do {
                            System.out.println("Enter a name house ");
                            nameHouse = scanner.nextLine();
                            if (!Regex.checkNameFacility(nameHouse)) {
                                System.err.println(TypeError.ERROR_NAME);
                            }
                        } while (!Regex.checkNameFacility(nameHouse));

                        do {
                            System.out.println("Enter an area uses of house");
                            usableAreaHouse = Double.parseDouble(scanner.nextLine());
                            if (!Regex.checkArea(usableAreaHouse)) {
                                System.err.println(TypeError.ERROR_AREA);
                            }
                        } while (!Regex.checkArea(usableAreaHouse));

                        do {
                            System.out.println("Enter rental cost of house ");
                            rentalCostHouse = Integer.parseInt(scanner.nextLine());
                            if (!Regex.checkRentalCost(rentalCostHouse)) {
                                System.err.println(TypeError.ERROR_COST);
                            }
                        } while (!Regex.checkRentalCost(rentalCostHouse));

                        do {
                            System.out.println("Enter quality people of house");
                            maxPeopleHouse = Integer.parseInt(scanner.nextLine());
                            if (!Regex.checkMaxPeople(maxPeopleHouse)) {
                                System.err.println(TypeError.ERROR_PEOPLE);
                            }
                        } while (!Regex.checkMaxPeople(maxPeopleHouse));

                        do {
                            System.out.println("Enter type rental of house");
                            typeRentalHouse = scanner.nextLine();
                            if (!Regex.checkNameFacility(typeRentalHouse)) {
                                System.err.println(TypeError.ERROR_NAME);
                            }
                        } while (!Regex.checkNameFacility(typeRentalHouse));

                        do {
                            System.out.println("Enter a standard room of house");
                            roomStandardHouse = scanner.nextLine();
                            if (!Regex.checkName(roomStandardHouse)) {
                                System.err.println(TypeError.ERROR_NAME);
                            }
                        } while (!Regex.checkName(roomStandardHouse));

                        do {
                            System.out.println("Enter a floor of house");
                            floorHouse = Integer.parseInt(scanner.nextLine());
                            if (!Regex.checkFloor(floorHouse)) {
                                System.err.println(TypeError.ERROR_FLOOR);
                            }
                        } while (!Regex.checkFloor(floorHouse));
                        House house = new House(idHouse, nameHouse, usableAreaHouse, rentalCostHouse, maxPeopleHouse, typeRentalHouse, roomStandardHouse, floorHouse);
                        facilityRepository.add(house);
                        break;

                    case 3:
                        String idRoom;
                        String nameRoom;
                        Double usableAreaRoom;
                        int rentalCostsRoom;
                        int maxPeopleRoom;
                        String typeRentalRoom;
                        String serviceRoom;
                        do {
                            System.out.println("Enter a ID of ROOM");
                            idRoom = scanner.nextLine();
                            if (!Regex.checkIdServiceRoom(idRoom)) {
                                System.err.println(TypeError.ERROR_ID_ROOM);
                            }
                        } while (!Regex.checkIdServiceRoom(idRoom));

                        do {
                            System.out.println("Enter a name of ROOM");
                            nameRoom = scanner.nextLine();
                            if (!Regex.checkNameFacility(nameRoom)) {
                                System.err.println(TypeError.ERROR_NAME);
                            }
                        } while (!Regex.checkIdServiceRoom(idRoom));

                        do {
                            System.out.println("Enter uses area of ROOM");
                            usableAreaRoom = Double.parseDouble(scanner.nextLine());
                            if (!Regex.checkArea(usableAreaRoom)) {
                                System.err.println(TypeError.ERROR_AREA);
                            }
                        } while (!Regex.checkArea(usableAreaRoom));

                        do {
                            System.out.println("Enter rental costs of ROOM");
                            rentalCostsRoom = Integer.parseInt(scanner.nextLine());
                            if (!Regex.checkRentalCost(rentalCostsRoom)) {
                                System.err.println(TypeError.ERROR_COST);
                            }
                        } while (!Regex.checkRentalCost(rentalCostsRoom));

                        do {
                            System.out.println("Enter quality people of ROOM");
                            maxPeopleRoom = Integer.parseInt(scanner.nextLine());
                            if (!Regex.checkMaxPeople(maxPeopleRoom)) {
                                System.err.println(TypeError.ERROR_PEOPLE);
                            }
                        } while (!Regex.checkMaxPeople(maxPeopleRoom));

                        do {
                            System.out.println("Enter type rental of ROOM");
                            typeRentalRoom = scanner.nextLine();
                            if (!Regex.checkNameFacility(typeRentalRoom)) {
                                System.err.println(TypeError.ERROR_NAME);
                            }
                        } while (!Regex.checkMaxPeople(maxPeopleRoom));

                        System.out.println("Enter a service free of ROOM");
                        serviceRoom = scanner.nextLine();

                        Room room = new Room(idRoom, nameRoom, usableAreaRoom, rentalCostsRoom, maxPeopleRoom, typeRentalRoom, serviceRoom);
                        facilityRepository.add(room);
                        break;
                    case 4:
                        FuramaController.facilityManagement();
                        break;

                }
            } catch (NumberFormatException e) {
                System.err.println("NO VALID, PLEASE ENTER AGAIN");
            }
        } while (true);


    }

    @Override
    public void displayListMaintenance() {
        Map<Facility, Integer> displayListMaintenance = facilityRepository.displayListMaintenance();
        for (Map.Entry<Facility, Integer> facilityIntegerEntry : displayListMaintenance.entrySet()) {
            System.out.println(facilityIntegerEntry.getKey() + ". Number of uses : " + facilityIntegerEntry.getValue());
        }
    }

    @Override
    public void deleteFacility() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter  Id facily to delete");
        String id = scanner.nextLine();
        Facility facility = facilityRepository.getById(id);
        if (facility == null){
            System.out.println("NO FOUND");
        }else {
            facilityRepository.deleteFacility(facility);
        }
        
    }
}
