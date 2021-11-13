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

        //Добавление сторонних библиотек например Gson
        //File -> Project Structure -> Libraries
        //Добавляем через плюс
        //Выберем добавление Java если есть скаченный файл .jar ищем его в директории и добавляем.
        //Или добавляем его через Мавен
        String text = "nominatim.openstreetmap.org/search?street=Невский+проспект%2C+100&format=json&city=СПб";
        Utility.main(new String[]{"Невский"});
        //Utility.main(new String[]{" -q Невский 12"});
    }
}
