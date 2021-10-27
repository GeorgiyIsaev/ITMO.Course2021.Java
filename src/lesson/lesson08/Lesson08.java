package lesson.lesson08;


import lesson.lesson08.factory.Table;
import lesson.lesson08.factory.TableStore;
import lesson.lesson08.observer.YoutubeChannel;
import lesson.lesson08.observer.YoutubeSubscriber;
import lesson.lesson08.singelton.Singleton;
import lesson.lesson08.singelton.SingletonTwo;

public class Lesson08 {
    public static void main(String[] args) {
        //Лекция 08: Абстрактный класс, Интерфейс, Паттерны
        //Тест паттерна Singleton
        singletonTest();

        // observer - Паттерн наблюдатель
        observerTest();

        //Паттерн Фабрика
        factoryTest();

        //ДЗ: Прочитать (Карьера программиста) Гл.10 - ООП
    }

    public static void singletonTest(){
        //Тест паттерна Singleton
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);

        SingletonTwo s4 = SingletonTwo.getInstance();
        SingletonTwo s5 = SingletonTwo.getInstance();
        System.out.println(s4 == s5);
    }
    public static void observerTest(){
        //Тест паттерна observer
        YoutubeChannel youtubeChannel = new YoutubeChannel();
        YoutubeSubscriber subscriberA = new YoutubeSubscriber(youtubeChannel);
        YoutubeSubscriber subscriberB = new YoutubeSubscriber(youtubeChannel);
        YoutubeSubscriber subscriberC = new YoutubeSubscriber(youtubeChannel);
        youtubeChannel.addObserver(subscriberA);
        youtubeChannel.addObserver(subscriberB);
        youtubeChannel.addObserver(subscriberC);
        youtubeChannel.releaseNewVideo("Design Patterns : Factory Method");
        youtubeChannel.releaseNewVideo("Design Patterns : Proxy");
        youtubeChannel.releaseNewVideo("Design Patterns : Visitor");
    }
    public static void factoryTest() {
        //Тест паттерна фабрика
        TableStore tableStore = new TableStore();
        Table strangeTable = tableStore.orderTable("Mysterious table");
        Table officeTable = tableStore.orderTable("office");
        Table kitchenTable = tableStore.orderTable("kitchen");

        System.out.println(strangeTable);
        System.out.println(officeTable);
        System.out.println(kitchenTable);
    }

}
