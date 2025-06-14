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
            
        }
    }
    
    
    
    
    
}
