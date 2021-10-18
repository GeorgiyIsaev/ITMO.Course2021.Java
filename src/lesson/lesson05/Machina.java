package lesson.lesson05;

public class Machina {
    String name;
    String model;
    int year;
    String color;



    public Machina() {
        this.name = "No name";
        this.model = "No model";
    }

    public Machina(String name, String model) {
        //Конструктор, который вызывает конструктор
        this(name, model, 2020);
    }
    public Machina(String name, String model, int year) {
        this(name, model, 2020, "Red");
    }

    public Machina(String name, String model, int year, String color) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Machina{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }
}
