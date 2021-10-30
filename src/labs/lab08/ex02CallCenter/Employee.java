package labs.lab08.ex02CallCenter;

abstract public class Employee {
    protected String name;
    protected String post;
    protected boolean isBusyIt = false;


    public Employee(String name, String post) {
        this.name = name;
        this.post = post;
    }

    boolean isBusy(){
        return isBusyIt;
    }
    public void startCall(){
        isBusyIt = true;
    }
    public void endCall(){
        isBusyIt = false;
    }

    @Override
    public String toString() {
        return  post + ": " + name;
    }
}
