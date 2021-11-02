package labs.lab12;

public class Lab12 {
    public static void main(String[] args) {
        //ЗАДАЧА 01: Напишите программу, в которой запускается 10 потоков и каждый из них выводит
        //числа от 0 до 100.
        testCountThread();

        //ЗАДАЧА 02: Выведете состояние потока перед его запуском , после запуска и во время
        //выполнения.

        //ЗАДАЧА 03: Дан класс Counter:
        //Напишите программу, в которой запускается 100 потоков, каждый из которых
        //вызывает метод increment() 1000 раз.
        //После того, как потоки завершат работу, проверьте, чему равен count .
        //Если обнаружилась проблема, предложите ее решение.
        //class Counter {
        //int count = 0 ;
        //public void increment() {
        //count = count + 1 ;
        //}
        //public int getCount() {
        //return count ;
        //}
        //}


        //ЗАДАЧА 04: Напишите программу, в которой создаются два потока. Каждый
        // из потоков выводит по очереди на консоль своё имя.
        //Начать можно с написания своего класс-потока, который выводит в бесконечном
        //цикле свое имя. Потом придется добавить синхронизацию с помощью wait() и
        //notify().
    }


    public static void testCountThread(){
        CountThread countThread = new CountThread("Поток 1" , 10);
        CountThread countThread2 = new CountThread("Поток 2" , 20);
        countThread.start();
        countThread2.start();

    }
}
