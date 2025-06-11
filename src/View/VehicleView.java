package view;

import java.util.List;
import java.util.Scanner;
import Model.Vehicle;

public class VehicleView {

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
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
    
    public int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
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
}
