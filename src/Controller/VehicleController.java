package Controller;

import java.util.Scanner;
import Model.Vehicle;

public class VehicleController {
    Scanner scanner = new Scanner(System.in);

    public Vehicle getVehicleInput() {
        
        System.out.println("\n---Input Vehicle Details---");
        System.out.print("Input ID: ");
        String id = scanner.nextLine();

        System.out.print("Input Name: ");
        String name = scanner.nextLine();

        System.out.print("Input Color: ");
        String color = scanner.nextLine();

        System.out.print("Input Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Input Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Input Type: ");
        String type = scanner.nextLine();

        System.out.print("Input Production Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        return new Vehicle(id, name, color, price, brand, type, year);
    }

    public String getSearchId() {
        System.out.print("\nEnter Vehicle ID to search: ");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

}
