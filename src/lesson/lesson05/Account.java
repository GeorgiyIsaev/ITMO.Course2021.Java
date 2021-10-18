package lesson.lesson05;

//Геттеры и Сеттеры
public class Account {
    private long id;
    private String code;
    private boolean open;
    public long getId(){
        return id;
    }
    public void setCode(String code){
        this.code = code;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
}
