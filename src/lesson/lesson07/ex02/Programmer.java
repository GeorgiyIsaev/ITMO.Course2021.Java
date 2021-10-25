package lesson.lesson07.ex02;

import java.util.Date;

public class Programmer extends Employee {
    protected String[] lang;

    public Programmer(String name, int year, String address, Date start, Long salary, String[] lang) {
        super(name, year, address, start, salary);
        this.lang = lang;
    }

    public String[] getLang() {
        return lang;
    }

    public void setLang(String[] lang) {
        this.lang = lang;
    }
}
