package lesson.lesson07.ex01;

import java.util.Arrays;

public class Lesson07 {
    public static void main(String[] args) {
        //Лекция 07: Наследование и полиморфизм
        //Наследование для класса персон
        classPersonTest();

        //Переопределение полей (super this)
        SuperClassTest();
    }

    private static void classPersonTest() {
        Programmer p = new Programmer();
        p.setName("Ivan");
        p.setYear(1985);
        p.setAddress("Spb");
        p.setSalary(500_000L);
        p.setLang(new String[]{"Java", "kotlin","cs"});
        System.out.println(Arrays.toString(p.getLang()));
        System.out.println(p.getStart());
        System.out.println(p.getName());
    }

    private static void SuperClassTest(){
        SuperClass superClass = new SuperClass();
        superClass.printValue();
        SubClassA subClassA;
        subClassA = new SubClassA(12);
        subClassA.printValue();
        subClassA = new SubClassA();
        subClassA.printValue();
    }




}

//Пример наследования
class SuperClass{
    protected int field;
    protected void printValue(){
        System.out.println(field);
    }
}
class SubClassA extends SuperClass {
    protected int field;
    public SubClassA(){
        this.field = 30;
        field = 38;
        super.field = 20;
    }
    public SubClassA(int field){
        this.field = 30;
        field = 38;
        super.field = 20;
    }
    protected void printValue(){
        System.out.println(field);
        System.out.println(this.field);
        System.out.println(super.field);
        super.printValue();
    }
}
class SubClassB extends SuperClass {}
class SubClassC extends SubClassA {}

