package labs.lab08.ex03Рarking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    List<Transport> transports;
    public Parking(){
        transports = new ArrayList<>();
    }
    public void addCar(Transport transport){
        transports.add(transport);
    }
    public void printParkingCar(){
        for(Transport transport : transports){
            System.out.println(transport);
        }
    }
}
