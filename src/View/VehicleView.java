package view;

import java.util.List;
import java.util.Scanner;
import Model.Vehicle;

public class VehicleView {
    private Scanner scanner = new Scanner(System.in);

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

    public Vehicle getVehicleInput() {
        System.out.println("\n---Input Vehicle Details---");
        System.out.print("Input ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Input Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Input Color: ");
        String color = scanner.nextLine();
        
        System.out.print("Input Price: ");
        double price     = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Input Brand: ");
        String brand = scanner.nextLine();
        
        System.out.print("Input Type: ");
        String type = scanner.nextLine();
        
        System.out.print("Input Production Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        return new Vehicle(id, name, color, price, brand, type, year);
    }

    public void displayVehicleList(List<Vehicle> vehicles) {
        System.out.println("\n=== VEHICLE LIST ===");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("| ID       | Name           | Color     | Price     | Brand     | Type     | Year |");
        System.out.println("-----------------------------------------------------------------------------");
        
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
        
        System.out.println("-----------------------------------------------------------------------------");
    }

    public String getSearchId() {
        System.out.print("\nEnter Vehicle ID to search: ");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}