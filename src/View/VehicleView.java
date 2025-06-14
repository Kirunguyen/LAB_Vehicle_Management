package view;

import java.util.List;
import java.util.Scanner;

import Model.Vehicle;
import Controller.VehicleController;
import util.*;

public class VehicleView {

    private VehicleController controller = new VehicleController();
    private Scanner scanner = new Scanner(System.in);
    private ViewUtil viewUtil = new ViewUtil();

    public static void main(String[] args) {
        VehicleView app = new VehicleView();
        boolean running = true;

        while (running) {
            app.viewUtil.showMenu();
            int choice = app.viewUtil.getMenuChoice(app.scanner);

            switch (choice) {
                case 0: //exit
                    running = false;
                    System.out.println("Exiting System...");
                    break;

                case 1: // Add new vehicle
                    app.moduleAddVehicle();
                    break;

                case 2: // Check if vehicle exists
                    app.moduleCheckVehicleExists();
                    break;

                case 3: // Update vehicle
                    app.moduleUpdateVehicle();
                    break;

                case 4: // Delete vehicle
                    app.moduleDeleteVehicle();
                    break;

                case 5: // Search vehicle
                    app.moduleSearchVehicle();
                    break;

                case 6: // Display vehicle list
                    app.moduleDisplayVehicles();
                    break;

                case 7: // Save data to file
                    app.moduleSaveToFile();
                    break;

                case 8: // Print vehicle list
                    app.modulePrintVehicles();
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        app.scanner.close();
    }
    
    /**
     * Modules
     */
    private void moduleAddVehicle() {
        System.out.println("--- Add Vehicle ---");
        String id = viewUtil.getVehicleIdInput(scanner);
        controller.addVehicle(id);        
    }

    private void moduleCheckVehicleExists() {
        System.out.println("--- Check Vehicle Exists ---");
        String id = viewUtil.getVehicleIdInput(scanner);
        
        Vehicle vehicle = controller.searchById(id);
        if (vehicle != null) {
            System.out.println("Exist Vehicle");
        } else {
            System.out.println("No Vehicle Found!");
        }
    }

    private void moduleUpdateVehicle() {
        System.out.println("--- Update Vehicle ---");
        String id = viewUtil.getVehicleIdInput(scanner);
        controller.updateVehicle(id);
    }
    
    private void moduleDeleteVehicle() {
        System.out.println("--- Delete Vehicle ---");
        String id = viewUtil.getVehicleIdInput(scanner);
        controller.deleteVehicle(id);
    }

    private void moduleSearchVehicle() {
        viewUtil.showSearchSubmenu();
        int choice = viewUtil.getMenuChoice(scanner);
        
        if (choice == 1) {
            String id = viewUtil.getVehicleIdInput(scanner);
            Vehicle vehicle = controller.searchById(id);
            if (vehicle != null) {
                viewUtil.displayVehicleDetails(vehicle);
            } else {
                System.out.println("No vehicle found");
            }
        } else if (choice == 2) {
            String name = viewUtil.getVehicleNameInput(scanner);
            List<Vehicle> vehicles = controller.searchByName(name);
            viewUtil.displayVehicleList(vehicles);
        }
    }

    private void moduleDisplayVehicles() {
        viewUtil.showDisplaySubmenu();
        int choice = viewUtil.getMenuChoice(scanner);
        
        if (choice == 1) {
            List<Vehicle> vehicles = controller.getAllVehicles();
            viewUtil.displayVehicleList(vehicles);
        } else if (choice == 2) {
            List<Vehicle> vehicles = controller.getAllVehiclesSortedByPrice();
            viewUtil.displayVehicleList(vehicles);
        }
    }

    private void moduleSaveToFile() {
        System.out.println("--- Save Data to File ---");
        List<Vehicle> vehicles = controller.getAllVehicles();
        FileUtil.saveVehicle(vehicles);
        System.out.println("Data saved successfully!");
    }

    private void modulePrintVehicles() {
        System.out.println("=== PRINT OPTIONS ===");
        System.out.println("1. Print all vehicles");
        System.out.println("2. Print all vehicles (descending by price)");
        System.out.print("Enter your choice: ");
        
        int choice = viewUtil.getMenuChoice(scanner);
        
        if (choice == 1) {
            List<Vehicle> vehicles = controller.getAllVehicles();
            viewUtil.displayVehicleList(vehicles);
        } else if (choice == 2) {
            List<Vehicle> vehicles = controller.getAllVehiclesSortedByPrice();
            viewUtil.displayVehicleList(vehicles);
        }
    }
}