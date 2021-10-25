package lesson.lesson07.ex01;

import lesson.lesson07.ex01.Employee;

public class Manager extends Employee {
    protected  boolean smile;

    public boolean isSmile() {
        return smile;
    }

    public void setSmile(boolean smile) {
        this.smile = smile;
    }
}
