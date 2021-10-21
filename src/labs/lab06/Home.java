package labs.lab06;

import java.time.LocalDate;
import java.util.Date;

public class Home {
    private int countLevel;
    private int yearBuild;
    private String name;

    public Home(int countLevel, int yearBuild, String name) {
        //Метод (конструктор) - для инициализации всех полей
        this.countLevel = countLevel;
        this.yearBuild = yearBuild;
        this.name = name;
    }
    public Home() {
        this(0,0,"Еще не построен!");
    }
    public void createHome(int countLevel, int yearBuild, String name) {
        //Метод - для инициализации всех полей
        this.countLevel = countLevel;
        this.yearBuild = yearBuild;
        this.name = name;
    }

    public int getCountYearAfterBuild() {
        //метод, возвращающий количество лет с момента постройки
        LocalDate current_date = LocalDate.now();
        return current_date.getYear() - yearBuild;
    }

    @Override
    public String toString() {
        //Метод для вывода всех значений
        return "Дом " + name + "{" +
                "Год постройки: " + yearBuild +
                ", Этажей " + countLevel + '}';
    }
    public void print(){
        //Метод для вывода информации на консоль
        System.out.println(this);
    }



}
