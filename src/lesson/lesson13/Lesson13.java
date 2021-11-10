package lesson.lesson13;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Lesson13 {
    public static void main(String[] args) {
        /**Лекция 13: СЕТЬ*/

        //Для соединения с сервером используют класс HttpURLConnection,
        //он позволяет отправить запрос, и получить ответ

        //Пример выполнения запроса и получения ответа.
        //Программа, которая с консоли считывает адрес (в пределах Петербурга),
        //и выводит список всех мест, которые находятся по этому адресу
        //(кафе, магазины и так далее).
        Utility.main(new String[]{"http://nominatim.openstreetmap.org/search?street=%s&format=json&city=СПб","1"});
    }
}
