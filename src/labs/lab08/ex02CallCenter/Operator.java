package labs.lab08.ex02CallCenter;

public class Operator extends Employee{
    private static int countOperator = 1;

    public Operator(String name) {
        super(name, "Оператор " + countOperator);
        countOperator++;
    }

    @Override
    boolean isBusy() {
        return false;
    }
}
