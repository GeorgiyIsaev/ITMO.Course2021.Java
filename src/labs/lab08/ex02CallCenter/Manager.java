package labs.lab08.ex02CallCenter;

public class Manager extends Employee{

    public Manager(String name, String post) {
        super(name, "Менеджер " + post);
    }


    @Override
    boolean isBusy() {
        return false;
    }
}
