package telegramBot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.Scanner;

public class MainTelegram {

    public static void main(String[] args) {
        try {
            testMyTelegram();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public static void testMyTelegram() throws TelegramApiException {
        try {
            StarterFile starterFile = new StarterFile();
            starterFile.createJsonFile();
            starterFile.readJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        WeatherBot wb = new WeatherBot(new DefaultBotOptions());
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(wb); //создает непрерывный поток с тригером на апдейты


        wb.execute(SendMessage.builder().chatId("902459907").text("Бот запущен").build());
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ответ: ");
                String str = scanner.nextLine();
               // wb.execute(SendMessage.builder().chatId("993363894").text(str).build()); //я
               // wb.execute(SendMessage.builder().chatId("550105390").text(str).build()); //Влад
              //  wb.execute(SendMessage.builder().chatId("902459907").text(str).build()); //Михаил
            }
            catch (Exception e){

            }
        }




    }
}
