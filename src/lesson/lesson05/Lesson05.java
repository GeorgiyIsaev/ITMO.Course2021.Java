package lesson.lesson05;

public class Lesson05 {
    public static void main(String[] args) {
        //Лекция 05: Классы

        // Создание классов
        createClass();
        //Имена пакетов с маленькой буквы (внезапно!)

    }

    public static void createClass(){
        Student student = new Student();
        System.out.println(student.name); //null

        Student anna = new Student();
        anna.name = "Anna";
        anna.age = 21;
        System.out.println(anna.name + " " + anna.age);

        Student ivan = new Student();
        ivan.name = "Ivan";
        ivan.age = 23;
        System.out.println(ivan.name + " " + ivan.age);
    }

}

class Empty{
}
class Project{
}
class Student{
    String name; //по умолчанию паблик
    int age;
    float mark;
    String[] subjects;
}