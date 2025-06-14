/**
 * Main Functions:
 *
 * TODO: InputID in View
 *
 * Update vehicle (50 LOC)
 *
 * Delete vehicle (50 LOC)
 *
 * Search vehicle (with sub-functions)
 * * By name (50 LOC)
 * * By ID (50 LOC)
 *
 * Display vehicle list (with sub-functions)
 * * Show all (50 LOC)
 * * Show all descending by price (50 LOC)
 *
 * Save data to file (50 LOC) (in FileUtil)
 *
 * Print vehicle list (with sub-functions)
 * * Print all (50 LOC)
 * * Print all descending by price (50 LOC)
 */
package Controller;

import java.util.Scanner;
import Model.Vehicle;
import java.util.List;

import util.FileUtil;
import util.ControlUtil;

public class VehicleController {

    Scanner scanner = new Scanner(System.in);
    private List<Vehicle> vehicles = FileUtil.loadVehicles();

    /**
     * Check if vehicle exists
     *
     * @param String id
     *
     * @return Boolean
     */
    private boolean doesVehicleExist(String id) {
        return vehicles.stream()
                .anyMatch(v -> v.getId().equalsIgnoreCase(id));
    }

    /**
     * Add new vehicle (50 LOC)
     *
     * @param String id
     *
     * @return Boolean (success/failed)
     */
    public boolean addVehicle(String id) {
        if (doesVehicleExist(id)) {
            System.out.println("Error: Vehicle ID already exists");
            return false;
        }

        Vehicle newVehicle = ControlUtil.getVehicleInputNoID();
        newVehicle.setId(id);
        vehicles.add(newVehicle);
        return true;
    }

    /**
     * Delete vehicle (50 LOC)
     *
     * @param id
     *
     * @return Boolean (success/failed)
     */
    public boolean deleteVehicle(String id) {
        if (!doesVehicleExist(id)) {
            System.out.println("Error: Vehicle ID does not exist");
            return false;
        }

        vehicles.removeIf(v -> v.getId().equalsIgnoreCase(id));
        return true;
    }

    /**
     * TODO: UPDATE = DELETE -> ADD
     *
     * @param String id
     *
     * @return Boolean (success/failed)
     */
    public boolean updateVehicle(String id) {
        if (!doesVehicleExist(id)) {
            System.out.println("Error: Vehicle ID does not exist");
            return false;
        }
        //???
        return true;
    }

}
