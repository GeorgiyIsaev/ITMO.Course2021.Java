package labs.lab08.ex02CallCenter;

abstract public class Employee {
    protected String name;
    protected String post;


    public Employee(String name, String post) {
        this.name = name;
        this.post = post;
    }

    abstract boolean isBusy();

    @Override
    public String toString() {
        return  post + ": " + name;
    }
}
