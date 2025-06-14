package util;

import Model.Vehicle;
import java.util.Scanner;

public class ControlUtil {

    /**
     * Helper - Get Vehicle Input No ID
     *
     * @param name, color, price, brand, type, year (NO ID)
     *
     * @return Vehicle
     */
    public static Vehicle getVehicleInputNoID() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);

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
}
