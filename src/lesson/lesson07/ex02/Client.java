package lesson.lesson07.ex02;

public class Client extends Person {
    protected String number;
    protected boolean gold;

    public Client(String name, int year, String address, String number, boolean gold) {
        super(name, year, address);
        this.number = number;
        this.gold = gold;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isGold() {
        return gold;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }
}
