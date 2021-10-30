package labs.lab08.ex02CallCenter;

import java.util.ArrayList;
import java.util.List;

public class OfficeCallCenter {
    private List< Employee> employees;

    private boolean isExistsDirector(){
        for(Employee employee : employees){
            if (employee instanceof Director) {
                return true;
            }
        }
        return false;
    }

    public OfficeCallCenter(){
        employees = new ArrayList<>();
    }
    public void add(Employee employee){
        if(isExistsDirector() && (employee instanceof Director)){
            System.out.println("Добавление " + employee + "не выполнено!");
            System.out.println("У фирму уже есть директор!");
        }


        employees.add(employee);
    }
    public void print(){
        int count = 1;
        for(Employee employee : employees){
           System.out.println((count++) + ") "  + employee);
        }
    }



}

