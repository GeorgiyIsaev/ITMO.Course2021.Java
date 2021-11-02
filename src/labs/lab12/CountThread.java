package labs.lab12;

public class CountThread extends Thread {
    int interval;

    CountThread(String name, int interval){
        super(name);
        this.interval = interval;
    }

    public void run(){
        System.out.println("Поток " + Thread.currentThread().getName() + " запущен!");
        for (int i = 1; i <= 100 ; i++) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        System.out.println("Поток " + Thread.currentThread().getName() + " завершен!");
    }
}
