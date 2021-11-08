package lesson.lesson12;

import java.util.Scanner;

public class Lesson12 {
    public static void main(String[] args) {
        /**ЛЕКЦИЯ 12: ПОТОКИ*/
        //синхронный, асинхронный, параллельный

        //Синхронизация потоков:
        //Если есть переменная к которой обращаются несколько потоков,
        //то не обходимо запретить потокам обращаться к этой переменной,
        //пока другой поток не закончить с ней работу. Можно создать очередь.
        //synchronized (объект){код с объектом} // синхронизация для объекта
        //synchronized void doWork(){код} // синхронизация для метода

        //Создать поток можно двумя путями:
        //Реализовав интерфейс Runnable
        //Расширив класс Thread

        //Основные методы:
        //getName(): возвращает имя потока
        //setName(String name): устанавливает имя потока
        //getPriority(): возвращает приоритет потока
        //setPriority(int proirity): устанавливает приоритет потока.
        //isAlive(): возвращает true, если поток активен
        //isInterrupted(): возвращает true, если поток был прерван
        //join(): ожидает завершение потока
        //run(): определяет точку входа в поток
        //sleep(): приостанавливает поток на заданное количество миллисекунд
        //start(): запускает поток, вызывая его метод run()

        //Ожидание потоков
        //wait(); // ждать пока другой поток не разрешить продолжить
        //natify(); // разрешает случайному остановленному потоку запустится
        //Всегда должны вызваться в блоке synchronized

        //Все о текущем потоке
        //testCurrentThread();

        //Текст поток наследника и интерфейса ран
        //testThread();

        //Тест пользовательского потока счетчика
        //testCountThread();

        //Усыпление класса
        testThreadSleep();
    }
    public static void testCurrentThread(){
        Thread thread = Thread.currentThread(); //получаем текущи поток
        System.out.println("Имя потока: \t" + thread.getName()); // имя потока
        System.out.println("статус: \t\t" +thread.getState()); // статус
        System.out.println("идентификатор: \t" +thread.getId()); // идентификатор
        System.out.println("живой ли: \t\t" +thread.isAlive()); // живой ли поток
        System.out.println("приоритет: \t\t" +thread.getPriority()); // приоритет
        System.out.println("С низким приоритетом?: \t" +thread.isDaemon()); // С низким приоритетом?
        thread.setName("Новое имя для этого потока");
        System.out.println("Имя потока: \t" + thread.getName()); // имя потока
    }
    public static void testThread(){
        Thread thread = new FirstThread();
        thread.start();

        Thread ratable = new Thread(new ByRunnable());
        ratable.start();

        //Можно передать имя
        Thread ratable1 = new Thread(new ByRunnable(), "Новое имя потока");
        ratable1.start();

        //Помещение лямбда-выражения
        Thread lambdaTread = new Thread(() ->{
            System.out.printf("My name is 3 %s%n", Thread.currentThread().getName());
        });        lambdaTread.start();



    }
    public static void  testCountThread(){
        CountThread countThread = new CountThread("Счетчик");
        countThread.start();
        //Позволяет ввести число

        //Главный поток продолжает поток на вывод
        for(long i =0; i<555_555_555_535L; i++){
            if(i% 1_000_000_000L == 0){
                System.out.println("done!");
            }
        }

    }
    public static void  testThreadSleep(){
        Thread t1 = new FirstThread();
        t1.start();
        System.out.println("Старт");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Конец");
    }


    // public static void


}
class FirstThread extends Thread {

    @Override
    public void run() {
        String threadMsg = String.format("My name is 1 %s", getName());
        System.out.println(threadMsg);
    }
}


class ByRunnable implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        String threadMsg = String.format("My name is 2 %s", threadName);
        System.out.println(threadMsg);
    }
}


class CountThread extends Thread{
    public final Scanner scanner = new Scanner(System.in);
    public String name;
    public CountThread(String name){
        super(name);
    }

    @Override
    public void run() {
        while(true){
            int number = scanner.nextInt();
            if(number == 0){
                break;
            }
            System.out.println(number * number);
        }
        System.out.println(getName() + " finished");
    }
}
