package lesson.lesson06;

import java.util.Arrays;

public class lesson06 {

    public static void main(String[] args) {
        /**Лекция 06: Структуры данных*/
        // Структур Стек Последним пришел, первый ушел
        // Структур Очередь (Queue) Первым пришел, первым ушел
        // Память Куча (hip) (хранятся объекты)
        // и Память стек (порядок вызываемых методов)

        //Работа с перечислением enum
        enumWork();


    }
    public static void enumWork(){
        //Работа с перечислением enum
        UserStatus active = UserStatus.ACTIVE; //проинициализировали
        System.out.println(active.name()); //отображать его имя ACTIVE
        UserStatus blocked = UserStatus.valueOf("BLOCKED"); //можно вызывать так
        System.out.println(blocked.name());

        //Массив
        UserStatus[] statuses = UserStatus.values(); //массив со всем значениями
        System.out.println(Arrays.toString(statuses));

        //ordinal - позволяет получить цифровое значение
        System.out.println(active.ordinal());
        System.out.println(UserStatus.ACTIVE.ordinal());

        //Сравнение работает в обоих вариантах
        System.out.println(active.equals(UserStatus.ACTIVE)); //true
        System.out.println(active == UserStatus.ACTIVE); //true

        //Использование в свитч
        switch (active){
            case ACTIVE -> System.out.println("active user");
            case BLOCKED -> System.out.println("blocked user");
            case UNKNOWN -> System.out.println("unknown user");
            default -> System.out.println("no such status");
        }

        //Использование в цикле
        for (UserStatus  status : UserStatus.values()){
            System.out.println(status);
        }
    }
}

