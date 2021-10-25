package lesson.lesson07.ex03;

public class Lesson07 {

    public static void main(String[] args) {
        //Лекция 07: Наследование и полиморфизм
        //Размещение наследуемых классов в объектах
        //Использование ссылки на супер класс
        classPersonTest();

    }

    private static void classPersonTest() {
        Person person = new Person();
        Employee employeeE = new Employee();
        Person clientP = new Client();
        clientP.setName("Анна");
        //employee.setSalary(100) не видит метод
        // Можно преобразовать если объект изначально был потомком
        Client client = (Client) clientP;
        // Employee employee1 = (Employee) person; //уже нельзя, так как он не был им никогда

        //Массив со ссылочными объектами
        Person person1 = new Person();
        person1.setName("Иван");
        Employee person2 = new Employee();
        person2.setName("Вика");
        Person[] persons ={ person1,person2,clientP,client};
        printName(persons);

        //Вызов методов из объектов ссылочного типа
        Manual dog = new Dog();
        dog.sayHello();
        Manual manual = new Manual();
        manual.sayHello();
        Manual human = new Human();
        human.sayHello();

        File file = new ImageFile("\\patch\\ggg\\qwe.png",200,300);
        file.printFileInfo();

    }

    public static void printName(Person[] people){
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }
}


class  File{
    protected String fullName;
    public File(String fullName){
        this.fullName=fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void printFileInfo(){
        String info = this.getFullFile();
        System.out.println(info);
    }
    private String getFullFile(){
        return "File " + fullName;
    }
}

class ImageFile extends File {
    protected int wight;
    protected int height;
    public byte[] content;

    public ImageFile(String fullName, int wight, int height) {
        super(fullName);
        this.wight = wight;
        this.height = height;
    }
    public int getWidth() {
        return wight;
    }

    public void setWidth(int wight) {
        this.wight = wight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
    @Override
    public String getFullName() {
        return "Картинка " + wight + " " + height;
    }
}











class Manual {
    public void sayHello(){
        System.out.println("hello in mammal");

    }
    public static String sayHelloStat(){
        return "hello in mammal";
    }
}
class  Dog extends Manual {
    public void sayHello() {
        System.out.println("waf");
    }

    public static String sayHelloStat() {
        return "waf";
    }
}
class  Human extends Manual {
    @Override
    public void sayHello() {
        System.out.println("Человек");
        super.sayHello();
    }
}
