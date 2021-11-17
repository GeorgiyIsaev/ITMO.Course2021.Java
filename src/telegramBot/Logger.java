package telegramBot;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


//Класс предназначен для записи в файл действий c ботом
public class Logger {
    private static final String nameFile = "logger.txt";

    public static void writeLog(Update update){

        String log = new Date().toString() + " ";

        log += "[ЧатID: " + update.getMessage().getChatId()
                + " Name: " + update.getMessage().getFrom().getFirstName()
                + " Text: " + update.getMessage().getText() + "]";
        System.out.println(log);
        write(log);
    }
    public static void writeLogKey(Update update){

        String log = new Date().toString() + " ";
        log += "[ЧатID: " + update.getCallbackQuery().getFrom().getId()
                + " Name: " +  update.getCallbackQuery().getFrom().getFirstName()
                + " Key: " + update.getCallbackQuery().getData().toString() + "]";
        System.out.println(log);
        write(log);
    }
    private static void write(String textLog){
        //Запись текста в файл
        try(FileWriter writer = new FileWriter(nameFile, true))
        {
            writer.write(textLog);
            writer.write("\n");
            writer.flush(); //запись из буфера в файл
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
