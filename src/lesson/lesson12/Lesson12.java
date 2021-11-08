package lesson.lesson12;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        //setPriority(int propriety): устанавливает приоритет потока.
        //isAlive(): возвращает true, если поток активен
        //isInterrupted(): возвращает true, если поток был прерван
        //join(): ожидает завершение потока
        //run(): определяет точку входа в поток
        //sleep(): приостанавливает поток на заданное количество миллисекунд
        //start(): запускает поток, вызывая его метод run()

        //Ожидание потоков
        //wait(); // ждать пока другой поток не разрешить продолжить
        //notify(); // разрешает случайному остановленному потоку запустится
        //notifyAll(); // запускает все остановленные потоки
        //Всегда должны вызваться в блоке synchronized


        /**ПОТОКИ - Пример работы:*/
        //Все о текущем потоке
        testCurrentThread();

        //Текст поток наследника и интерфейса ран
        testThread();

        //Тест пользовательского потока счетчика
        testCountThread();

        //Усыпление класса
        testThreadSleep();

        //Прерывание потока
        testInteract();

        //10 потоков
        testRun10Thread();

        //Theatre и Runnable - Для создания задач
        //MassageQueue - Очередь сообщений из задач
        //Looper - перемещается по очереди MassageQueue и отправляет
        // сообщения в соответствующие обработчики для выполнения
        //Handler - помещают задачи в очередь MassageQueue
        testExecutorService();

    }
    public static void testCurrentThread(){
        //Отображение информации о текущем потоке
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
        //Создание потока
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
        });
        lambdaTread.start();
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
        //Усыпление потока
        Thread t1 = new FirstThread();
        t1.start();
        //Слип
        System.out.println("Старт");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Конец");

        //TimeUnit позволяет выбрать интервал остановки
        System.out.println("Старт");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Конец");

        //Главный поток будит ждать завершение запущенного потока,
        //но не больше указанного количества мс
        //Время можно не указывать, тогда будит ждать до конца
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Конец выполнения программы");
    }
    public static void testInteract(){
        //Прерывание потока
        //Работает только если у потока установлено
        // условие с проверкой на прерывание потока
        //НЕ ПРЕРЫВАЕТ ПОТОК, а создает условие для плавного завершения
        Thread t1 = new Thread(new CountNun());
        t1.start();
        System.out.println("isAlive: " + t1.isAlive());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt(); //прервать работу потока
        System.out.println("isAlive: " + t1.isAlive());
        System.out.println("Конец выполнения программы");
    }

    public static void testRun10Thread(){
        //Вызов потоков из класса PrintNumbers и SimpleString
        PrintNumbers printNumbers = new PrintNumbers();
        printNumbers.start();
        SimpleString simpleString = new SimpleString();
        simpleString.start();

        //10 потоков в лямбде выражении
        run10Thread();
    }
    public static void run10Thread(){
        //Вызов 10 потоков с действием в лямбда-выражении
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++){
                        System.out.println(i);
                    }
                }
            });
        }
    }
    public static void testExecutorService(){
        //Поток Экзекютор
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(()->System.out.println("java print"));

    }
}

class PrintNumbers extends Thread{
    @Override
    public void run() {
        for (int i = 100; i > 90 ; i--) {
            System.out.println("number - " + i);
        }
    }
}
class SimpleString extends Thread{
    @Override
    public void run() {
            System.out.println("SimpleString");

    }
}





class CountNun implements Runnable{
    @Override
    public void run() {
        System.out.println("start count");
        int i = 1;
        try {
            while(!Thread.interrupted()){
                System.out.println(i++);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
            System.out.println("sleep iterator");
        }
        System.out.println("end count");
    }
}



class FirstThread extends Thread {

    @Override
    public void run() {
        String threadMsg = String.format("My name is 1 %s", getName());
        System.out.println(threadMsg);

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Конец выполнения потока");
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
