package lesson.lesson07.ex03;

import java.util.Date;

public class Employee extends Person {
    protected Date start;
    protected Long salary;



    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
