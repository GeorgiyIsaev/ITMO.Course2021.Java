package labs.lab12;

public class CountIncrementThread extends Thread {
    Counter counter;

    CountIncrementThread(String name, Counter counter){
        super(name);
        counter = counter;
    }

    public void run(){
        System.out.println("Поток " + Thread.currentThread().getName() + " запущен!");
        for (int i = 1; i <= 100 ; i++) {
            counter.increment();
        }
        //System.out.println(counter.getCount());
        System.out.println("Поток " + Thread.currentThread().getName() + " завершен!");
    }
}