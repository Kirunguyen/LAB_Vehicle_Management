package util;

import java.io.*;
import java.util.List;
import Model.Vehicle;

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
            throw new RuntimeException("Failed to load vehicles: " + e.getMessage(), e);
        }
    }
}
