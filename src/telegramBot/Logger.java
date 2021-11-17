package telegramBot;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Date;


//Класс предназначен для записи в файл всех действий с ботом
public class Logger {
    public static void writeLog(Update update){

        String log = new Date().toString() + " ";

        log += "[ЧатID: " + update.getMessage().getChatId()
                + " Name: " + update.getMessage().getFrom().getFirstName()
                + " Text: " + update.getMessage().getText() + "]";
        System.out.println(log);


    }
    public static void writeLogKey(Update update){

        String log = new Date().toString() + " ";
        log += "[ЧатID: " + update.getCallbackQuery().getFrom().getId()
                + " Name: " +  update.getCallbackQuery().getFrom().getFirstName()
                + " Key: " + update.getCallbackQuery().getData().toString() + "]";
        System.out.println(log);


    }

}
