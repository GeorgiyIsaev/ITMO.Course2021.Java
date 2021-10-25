package lesson.lesson07.ex02;

import java.util.Date;

public class Manager extends Employee {
    protected  boolean smile;

    public Manager(String name, int year, String address, Date start, Long salary, boolean smile) {
        super(name, year, address, start, salary);
        this.smile = smile;
    }

    public boolean isSmile() {
        return smile;
    }

    public void setSmile(boolean smile) {
        this.smile = smile;
    }
}
