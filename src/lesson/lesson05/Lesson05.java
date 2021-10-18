package lesson.lesson05;

public class Lesson05 {
    public static void main(String[] args) {
        //Лекция 05: Классы

        // Создание классов
        createClass();
        // !!! Имена пакетов с маленькой буквы (внезапно!)

        //Конструктор класса
        designerClass();
        classMachina();

        //Статический блок
        StaticInit staticInit =new StaticInit();
        System.out.println(StaticInit.dateField + " " + StaticInit.str);

        //Блок инициализации класса
        // (идет перед конструктором, но перед супер классом)
        InitExample initExample = new InitExample();
        initExample.print();

        //Cтатические переменные и методы
        SomeClass.staticInt = 10;
        System.out.println(SomeClass.staticInt);

        //Ссылки на объект
        refClass();

        //Геттеры и Сеттеры


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
    public static void designerClass(){
        //Конструктор с параметрами
        Student student1 = new Student("Anna", 21, 89.6f,"Kotlin");
        System.out.println(student1);

        //Конструктор без параметров
        Student student2 = new Student();
        System.out.println(student2);
    }
    public static void classMachina(){
        Machina anonymous = new Machina();
        System.out.println(anonymous);

        Machina aide = new Machina("Ауди","Б-5");
        System.out.println(aide);

        Machina lexus = new Machina("Lexus","Lx570", 2016, "Black");
        System.out.println(lexus);

    }

    public static void refClass(){
        Patient patient = new Patient();
        patient.name = "Anna";
        patient.age = 22;
        System.out.print(patient.name + " " + patient.age);

        Patient patient1 = patient;
        System.out.print(patient1.name + " " + patient1.age);

        patient.age =25;
        System.out.print(patient.name + " " + patient.age);
        System.out.print(patient1.name + " " + patient1.age); //тоже изменится

        Project p = null; //можно присвоить нулл


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
    String subject;
    public Student(){
        this.name = "Anonymous";
        this.age = 0;
        this.mark = 0;
        this.subject = "No subject";
    }


    public Student(String name, int age, float mark, String subject){
        this.name = name;
        this.age = age;
        this.mark = mark;
        this.subject = subject;
    }


    @Override
    public String toString() {
        //Сгенерированный метод туСтринг
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                ", subject='" + subject + '\'' +
                '}';
    }
}