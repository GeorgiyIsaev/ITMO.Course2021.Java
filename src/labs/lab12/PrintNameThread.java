package labs.lab12;

import labs.lab08.ex02CallCenter.Operator;

public class PrintNameThread  extends Thread {
   // static private int counter = 1;

    private Object log;

    PrintNameThread(Object log){
       // super("Поток для вывода № " + counter);
       // counter++;
        this.log = log;
    }
    public void run(){
        System.out.println(getName() + " запущен!");
        while (true){
            synchronized (log){
                try {
                    Thread.sleep(1000);
                    System.out.println("Выполняется: " + getName());
                    log.notify();
                    log.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
       // System.out.println(Thread.currentThread().getName() + " завершен!");
    }
}
