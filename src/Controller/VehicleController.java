package Controller;

import java.util.Scanner;
import Model.Vehicle;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import util.FileUtil;
import util.ControlUtil;

public class VehicleController {

    Scanner scanner = new Scanner(System.in);
    private List<Vehicle> vehicles = FileUtil.loadVehicles();

    /**
     * Check if vehicle exists
     *
     * @param id ID of vehicle
     *
     * @return Boolean
     */
    private boolean doesVehicleExist(String id) {
        return vehicles.stream()
                .anyMatch(v -> v.getId().equalsIgnoreCase(id));
    }

    /**
     * Add new vehicle
     *
     * @param id ID of vehicle
     *
     * @return Boolean (success/failed)
     */
    public boolean addVehicle(String id) {
        if (doesVehicleExist(id)) {
            System.out.println("Cannot add - Vehicle ID already exists");
            return false;
        }

        Vehicle newVehicle = ControlUtil.getVehicleInputNoID();
        newVehicle.setId(id);
        vehicles.add(newVehicle);
        return true;
    }

    /**
     * Delete vehicle
     *
     * @param id ID of vehicle
     *
     * @return Boolean (success/failed)
     */
    public boolean deleteVehicle(String id) {
        if (!doesVehicleExist(id)) {
            System.out.println("Cannot remove - Vehicle ID does not exist");
            return false;
        }

        vehicles.removeIf(v -> v.getId().equalsIgnoreCase(id));
        return true;
    }

    /**
     * Update vehicle = Delete -> Add (Will change order)
     *
     * @param id ID of vehicle
     *
     * @return Boolean (success/failed)
     */
    public boolean updateVehicle(String id) {
        if (!doesVehicleExist(id)) {
            System.out.println("Cannot update - Vehicle ID does not exist");
            return false;
        }
        if (deleteVehicle(id)) {
            addVehicle(id);
            return true;
        }

        return false;
    }

    /**
     * Searches vehicle by ID
     *
     * @param id ID to search (unique)
     *
     * @return Vehicle if found, null otherwise
     */
    public Vehicle searchById(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Error: ID cannot be empty");
            return null;
        }
        Vehicle found = vehicles.stream()
                .filter(v -> v.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);

        return found;
    }

    /**
     * Searches vehicles by name (partial match)
     *
     * @param name Name or partial name to search
     *
     * @return List<Vehicle>
     */
    public List<Vehicle> searchByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name cannot be empty");
            return Collections.emptyList();
        }

        String searchTerm = name.trim().toLowerCase();
        return vehicles.stream()
                .filter(v -> v.getName().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());

    }
    /**
     * Print vehicle list - All
     * @param none
     *
     * @return vehicles
     */
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    /**
     * Print vehicle list - All - Desc. by price
     * @param none
     *
     * @return vehicles
     */
    public List<Vehicle> getAllVehiclesSortedByPrice() {
        List<Vehicle> sorted = new java.util.ArrayList<>(vehicles);
        sorted.sort((v1, v2) -> Double.compare(v2.getPrice(), v1.getPrice()));
        return sorted;
    }
    
}
