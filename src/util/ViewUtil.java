package util;

import Model.Vehicle;
import java.util.List;
import java.util.Scanner;

public class ViewUtil {

    /**
     * MENU
     */
    public void showMenu() {
        System.out.println("\n===== VEHICLE MANAGEMENT SYSTEM =====");
        System.out.println("1. Add new vehicle");
        System.out.println("2. Check if vehicle exists");
        System.out.println("3. Update vehicle");
        System.out.println("4. Delete vehicle");
        System.out.println("5. Search vehicle");
        System.out.println("6. Display vehicle list");
        System.out.println("7. Save data to file");
        System.out.println("8. Print vehicle list");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getMenuChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Input a number: ");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void showSearchSubmenu() {
        System.out.println("\n=== SEARCH OPTIONS ===");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("0. Back to main menu");
        System.out.print("Enter your choice: ");
    }

    public void showDisplaySubmenu() {
        System.out.println("\n=== DISPLAY OPTIONS ===");
        System.out.println("1. Show all vehicles");
        System.out.println("2. Show all vehicles (descending by price)");
        System.out.println("0. Back to main menu");
        System.out.print("Enter your choice: ");
    }

    /**
     * DISPLAY
     */
    public void displayVehicleList(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println("\n=== VEHICLE LIST ===");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("| ID       | Name           | Color     | Price     | Brand     | Type     | Year |");
        System.out.println("-----------------------------------------------------------------------------");

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }

        System.out.println("-----------------------------------------------------------------------------");
    }

    public void displayVehicleDetails(Vehicle vehicle) {
        System.out.println("\n=== VEHICLE DETAILS ===");
        System.out.println("ID: " + vehicle.getId());
        System.out.println("Name: " + vehicle.getName());
        System.out.println("Color: " + vehicle.getColor());
        System.out.printf("Price: $%.2f\n", vehicle.getPrice());
        System.out.println("Brand: " + vehicle.getBrand());
        System.out.println("Type: " + vehicle.getType());
        System.out.println("Production Year: " + vehicle.getProductYear());
    }

    /**
     * INPUT
     */
    public String getVehicleIdInput(Scanner scanner) {
        while (true) {
            System.out.print("Enter vehicle ID: ");
            String input = scanner.nextLine();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Error: ID cannot be empty. Please try again.");
        }
    }

    public String getVehicleNameInput(Scanner scanner) {
        while (true) {
            System.out.print("Enter vehicle name (or partial name): ");
            String input = scanner.nextLine();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Error: Name cannot be empty. Please try again.");
        }
    }

}
