package lesson.lesson07.ex01;

import lesson.lesson07.ex01.Employee;

public class Programmer extends Employee {
    protected String[] lang;

    public String[] getLang() {
        return lang;
    }

    public void setLang(String[] lang) {
        this.lang = lang;
    }
}
