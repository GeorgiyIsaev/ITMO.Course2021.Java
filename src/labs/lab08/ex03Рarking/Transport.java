package labs.lab08.ex03Рarking;

public class Transport {
    protected String name;
    protected int minParking;
    public String getName() {
        return name;
    }
    public Transport(String name,int minParking ){
        this.name = name;
        this.minParking = minParking;
    }

    @Override
    public String toString() {
        return name + ": будит находиться " + minParking + " мин.";
    }
}
