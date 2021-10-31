package labs.lab08.ex03Рarking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    List<Transport> transports;
    int countLots;
    public Parking(int countLots){
        this.countLots = countLots;
        transports = new ArrayList<>();
    }
    public void addCar(Transport transport){
        if(transports.size()>countLots-1){
            System.out.println("На парковке нет свободных мест!");
            return;
        }
        transports.add(transport);
    }
    public void printParkingCar(){
        for(Transport transport : transports){
            System.out.println(transport);
        }
    }




}
