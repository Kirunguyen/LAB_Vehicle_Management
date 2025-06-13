/**
 * Main Functions:
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

public class VehicleController {

    Scanner scanner = new Scanner(System.in);
    private List<Vehicle> vehicles = FileUtil.loadVehicles();

    /**
     * 0. Helper - Get Vehicle Input No ID
     *
     * @param name, color, price, brand, type, year (NO ID)
     *
     * @return Vehicle
     */
    private Vehicle getVehicleInputNoID() throws IllegalArgumentException {
        Vehicle vehicle = new Vehicle();

        System.out.print("Name: ");
        vehicle.setName(scanner.nextLine());

        System.out.print("Color: ");
        vehicle.setColor(scanner.nextLine());

        System.out.print("Price: ");
        vehicle.setPrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("Brand: ");
        vehicle.setBrand(scanner.nextLine());

        System.out.print("Type: ");
        vehicle.setType(scanner.nextLine());

        System.out.print("Production Year: ");
        vehicle.setProductYear(Integer.parseInt(scanner.nextLine()));

        return vehicle;
    }

    /**
     * 1. Check if vehicle exists (50 LOC)
     *
     * @param id
     *
     * @return Boolean
     */
    private boolean isVehicleExists(String id) {
        return vehicles.stream()
                .anyMatch(v -> v.getId().equalsIgnoreCase(id));
    }

    /**
     * 2. Add new vehicle (50 LOC)
     *
     * @param none
     *
     * @return Boolean (success/failed)
     */
    public boolean addVehicle() {
        System.out.println("\n--- Add New Vehicle ---");

        //check ID
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        if (isVehicleExists(id)) {
            System.out.println("Error: Vehicle ID already exists");
            return false;
        }

        Vehicle newVehicle = getVehicleInputNoID();
        newVehicle.setId(id);
        vehicles.add(newVehicle);
        
        System.out.println("Vehicle added successfully!");
        return true;
    }

    /** TODO: UPDATE = DELETE -> ADD 
     * 3. Update vehicle (50 LOC)
     *
     * @param none
     * @param Vehicle(id, name, color, price, brand, type, year)
     *
     * @return void
     */
    public void updateVehicle() {
        System.out.println("\n--- Update Vehicle ---");
        
               //check ID
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        if (!isVehicleExists(id)) {
            System.out.println("Error: Vehicle ID does not exist");
            return;
        }

        Vehicle overrideVehicle = getVehicleInputNoID();
        overrideVehicle.setId(id);
        vehicles.add(overrideVehicle);
    }

}
