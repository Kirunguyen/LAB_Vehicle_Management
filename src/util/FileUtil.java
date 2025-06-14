package util;

import java.io.*;
import java.util.List;
import Model.Vehicle;
import java.util.ArrayList;

public class FileUtil {

    //relative PATH to file
    private static final String FILE_PATH = "data/vehicle.dat";

    //create directory (if not exists)
    public static void createDataDirectory() {
        File directory = new File("data");
        if (!directory.exists()) {
            boolean created = directory.mkdir();
            if (!created) {
                throw new RuntimeException("Failed to create data directory");
            }
        }
    }

    //save vehicle to file
    public static void saveVehicle(List<Vehicle> vehicles) {
        try {
            createDataDirectory();
            try (ObjectOutputStream oos = new ObjectOutputStream( //adds serialization
                    new FileOutputStream(FILE_PATH))) { //handles raw bytes -> file
                oos.writeObject(vehicles);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to save vehicle: " + e.getMessage(), e);
        }
    }

    //read vehicles from file
    public static List<Vehicle> loadVehicles() {
        try {
            createDataDirectory();
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new java.util.ArrayList<>();
            }

            try (ObjectInputStream ois = new ObjectInputStream( //adds serialization
                    new FileInputStream(FILE_PATH))) { //handles raw bytes -> file
                return (List<Vehicle>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            return createSampleVehicles();
        }
    }

    /**
     * Creates a list of sample vehicles with diverse data - Handles empty .dat
     *
     * @return List of sample vehicles
     */
    private static List<Vehicle> createSampleVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        // Sample cars
        vehicles.add(new Vehicle("CAR001", "Camry", "White", 35000.00, "Toyota", "Sedan", 2023));
        vehicles.add(new Vehicle("CAR002", "Accord", "Black", 32000.00, "Honda", "Sedan", 2022));
        vehicles.add(new Vehicle("CAR003", "Model 3", "Red", 45000.00, "Tesla", "Electric", 2024));
        vehicles.add(new Vehicle("CAR004", "Mustang", "Blue", 55000.00, "Ford", "Sports", 2023));
        vehicles.add(new Vehicle("CAR005", "Civic", "Silver", 25000.00, "Honda", "Compact", 2022));

        // Sample SUVs
        vehicles.add(new Vehicle("SUV001", "RAV4", "Gray", 38000.00, "Toyota", "SUV", 2023));
        vehicles.add(new Vehicle("SUV002", "CR-V", "White", 36000.00, "Honda", "SUV", 2024));
        vehicles.add(new Vehicle("SUV003", "Model Y", "Black", 52000.00, "Tesla", "Electric SUV", 2024));
        vehicles.add(new Vehicle("SUV004", "Explorer", "Blue", 42000.00, "Ford", "SUV", 2022));

        // Sample trucks
        vehicles.add(new Vehicle("TRK001", "F-150", "Red", 48000.00, "Ford", "Pickup", 2023));
        vehicles.add(new Vehicle("TRK002", "Silverado", "Black", 46000.00, "Chevrolet", "Pickup", 2022));
        vehicles.add(new Vehicle("TRK003", "Tacoma", "Green", 44000.00, "Toyota", "Pickup", 2024));

        // Sample motorcycles
        vehicles.add(new Vehicle("MOT001", "Ninja 400", "Green", 12000.00, "Kawasaki", "Motorcycle", 2023));
        vehicles.add(new Vehicle("MOT002", "CBR600RR", "Red", 15000.00, "Honda", "Motorcycle", 2022));
        vehicles.add(new Vehicle("MOT003", "Harley Street", "Black", 18000.00, "Harley-Davidson", "Motorcycle", 2023));

        // Sample luxury cars
        vehicles.add(new Vehicle("LUX001", "A4", "Silver", 42000.00, "Audi", "Luxury", 2024));
        vehicles.add(new Vehicle("LUX002", "3 Series", "White", 45000.00, "BMW", "Luxury", 2023));
        vehicles.add(new Vehicle("LUX003", "C-Class", "Gray", 48000.00, "Mercedes-Benz", "Luxury", 2024));

        // Sample budget cars
        vehicles.add(new Vehicle("BUD001", "Corolla", "Blue", 22000.00, "Toyota", "Compact", 2021));
        vehicles.add(new Vehicle("BUD002", "Sentra", "White", 20000.00, "Nissan", "Compact", 2021));
        vehicles.add(new Vehicle("BUD003", "Elantra", "Silver", 23000.00, "Hyundai", "Compact", 2022));

        return vehicles;
    }
}
