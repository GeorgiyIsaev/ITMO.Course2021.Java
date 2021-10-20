package lesson.lesson06;
// Локальный внутренний класс

public class Outer {
    private int number = 10;
    void someMethod(){
        final int x = 5; //локальный класс видит переменную

        //Создаем класс внутри метода
        class Local{
            private void print(){
                System.out.println("local number " + Outer.this.number);
                System.out.println("x " + x);
            }
        }

        Local localInner = new Local();
        localInner.print();

    }
}
