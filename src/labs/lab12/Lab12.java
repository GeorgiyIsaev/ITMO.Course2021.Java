package labs.lab12;

public class Lab12 {
    public static void main(String[] args) {
        //ЗАДАЧА 01: Напишите программу, в которой запускается 10 потоков и каждый из них выводит
        //числа от 0 до 100.
       // testCountThread();

        //ЗАДАЧА 02: Выведете состояние потока перед его запуском, после запуска и во время
        //выполнения.
       // testStatusThread();

        //ЗАДАЧА 03: Дан класс Counter:
        //Напишите программу, в которой запускается 100 потоков, каждый из которых
        //вызывает метод increment() 1000 раз.
        //После того, как потоки завершат работу, проверьте, чему равен count .
        //Если обнаружилась проблема, предложите ее решение.
        testCountIncrement();


        //ЗАДАЧА 04: Напишите программу, в которой создаются два потока. Каждый
        // из потоков выводит по очереди на консоль своё имя.
        //Начать можно с написания своего класс-потока, который выводит в бесконечном
        //цикле свое имя. Потом придется добавить синхронизацию с помощью wait() и
        //notify().
    }


    public static void testCountThread(){
        //ЗАДАЧА 01: Напишите программу, в которой запускается 10 потоков и каждый из них выводит
        //числа от 0 до 100.
        //CountThread countThread = new CountThread("Поток 1" , 20);
        //countThread.start();
        //new CountThread("Поток 2" , 10).start();

        for (int i = 1; i <= 10; i++) {
            new CountThread("Поток " + i, 150 - i*10).start();
        }
    }
    public static void testStatusThread(){
        //ЗАДАЧА 02: Выведете состояние потока перед его запуском, после запуска и во время
        //выполнения.
        for (int i = 1; i <= 10; i++) {
            new StatusThread("Поток " + i, 150 - i*10).start();
        }
    }
    static  Counter counter = new Counter();
    public static void testCountIncrement(){
        //ЗАДАЧА 03: Дан класс Counter:
        //Напишите программу, в которой запускается 100 потоков, каждый из которых
        //вызывает метод increment() 1000 раз.
        //После того, как потоки завершат работу, проверьте, чему равен count .
        //Если обнаружилась проблема, предложите ее решение.

//        System.out.println(counter.getCount());
//
//        for (int i = 1; i <= 10; i++) {
//            new CountIncrementThread("Поток " + i, counter).start();
//        }
//        System.out.println(counter.getCount());
        System.out.println("Главный поток - Начало");
        Counter counter = new Counter();
        System.out.println("Состояние для Counter: " + counter.getCount());

        Runnable r = ()->{
            System.out.println("Поток " + Thread.currentThread().getName() + " запущен!");
            for (int i = 1; i <= 1000 ; i++) {
                counter.increment();
            }
            //System.out.println(counter.getCount());
            System.out.println("Состояние для Counter: " + counter.getCount());
            System.out.println("Поток " + Thread.currentThread().getName() + " завершен!");
        };

        //Массив с потоками
        Thread[]counterIncThread = new Thread[100];
        for (int i = 0; i < counterIncThread.length; i++) {
            counterIncThread[i] = new Thread(r,"Поток с инкрементом № " + i);
            counterIncThread[i].start();
        }

//        try {
//            for (int i = 0; i < counterIncThread.length; i++) {
//                counterIncThread[i].join();//ожидать завершение каждого из массива потоков
//            }
//            for (int i = 0; i < counterIncThread.length; i++) {
//                counterIncThread[i].join();//ожидать завершение каждого из массива потоков
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Состояние для Counter: " + counter.getCount());
        System.out.println("Главный поток - Конец");


    }
}
