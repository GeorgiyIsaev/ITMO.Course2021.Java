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
            System.out.println("Добавление " + employee + " - не выполнено!");
            System.out.println("У фирму уже есть директор!");
            return;
        }
        employees.add(employee);
    }
    public void print(){
        int count = 1;
        for(Employee employee : employees){
           System.out.println((count++) + ") "  + employee);
        }
    }

    public void dispatchCall(){
        System.out.println("Вы дозвонились до кол-цента, ожидайте ответ оператора!");
        for(Employee employee : employees){
            if(employee instanceof Operator && !employee.isBusy()){
                System.out.println("--> Вам отвечает " + employee + ". Спасибо за ожидание!");
                employee.startCall();
                return;
            }
        }
        System.out.println("В данный момент все операторы заняты! Подожди еще несколько минут!");

        for(Employee employee : employees){
            if(employee instanceof Manager && !employee.isBusy()){
                System.out.println("--> Вам отвечает " + employee + ". Спасибо за ожидание!");
                employee.startCall();
                return;
            }
        }
        System.out.println("В данный момент все операторы и менеджеры заняты! Подожди еще несколько минут!");
        for(Employee employee : employees){
            if(employee instanceof Director && !employee.isBusy()){
                System.out.println("--> Вам отвечает " + employee + ". Спасибо за ожидание!");
                employee.startCall();
                return;
            }
        }
        System.out.println("К сожалению линия звонков переполнена. Попробуйте дозвонится в другой раз");
    }



}

