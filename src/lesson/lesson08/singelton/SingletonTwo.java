package lesson.lesson08.singelton;

//Паттерн (другая реализация)
public class SingletonTwo {
    private static SingletonTwo instance; // не создаем
    private SingletonTwo() {}

    public static SingletonTwo getInstance(){
        if(instance == null){
            instance = new SingletonTwo(); // создается если нет
        }
        return instance;
    }


}

