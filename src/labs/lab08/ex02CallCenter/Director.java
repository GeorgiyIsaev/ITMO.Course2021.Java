package labs.lab08.ex02CallCenter;

public class Director extends Employee{


    public Director(String name) {
        super(name, "Директор Колл-центра");
    }

    @Override
    boolean isBusy() {
        return false;
    }
}
