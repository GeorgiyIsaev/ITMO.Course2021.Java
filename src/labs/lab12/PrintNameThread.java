package labs.lab12;

public class PrintNameThread  extends Thread {
    static private int counter = 1;
    PrintNameThread(){
        super("Поток для вывода № " + counter);
        counter++;
    }
    public void run(){
        System.out.println(getName() + " запущен!");
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Выполняется: " + getName());
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
          //  notify();
        }
        //System.out.println(Thread.currentThread().getName() + " завершен!");
    }
}