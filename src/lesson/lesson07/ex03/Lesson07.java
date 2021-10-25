package lesson.lesson07.ex03;

import java.sql.Array;
import java.util.ArrayList;

public class Lesson07 {

    public static void main(String[] args) {
        //Лекция 07: Наследование и полиморфизм
        //Размещение наследуемых классов в объектах
        //Использование ссылки на супер класс
        classPersonTest();


        //Списки массивы
        arrayListTest();

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


    public static void arrayListTest(){
        ArrayList<Integer> list = new ArrayList<>(50);
        ArrayList<Integer> list2 = new ArrayList<Integer>(list);
        System.out.println(list2.size()); //размер
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        System.out.println(list2.contains(2)); //первое вхождение 2 есть или нет true
        System.out.println(list2.lastIndexOf(1)); //последнее вхождение 1 вернет индекс
        System.out.println(list2.indexOf(2)); //вернет первый индекс для 2
        System.out.println(list2.indexOf(5)); //вернет первый индекс для 5
        System.out.println(list2.get(2)); //вернет эл-т по индексу 2

        //Перебор эл-тов
        ArrayList<Long> arrayList = new ArrayList<>();
        int count =6;
        for (int i = 0; i < count; i++) {
            long pow = (long) Math.pow(5,i);
            arrayList.add(pow);
        }
        for (Long value : arrayList){
            System.out.println(value + " ");
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
