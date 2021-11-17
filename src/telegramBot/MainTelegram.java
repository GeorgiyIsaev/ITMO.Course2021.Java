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

        StarterFile starterFile = new StarterFile();
        starterFile.startReadFile();

        try {
            WeatherBot wb = new WeatherBot(new DefaultBotOptions(), starterFile);
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(wb); //создает непрерывный поток с тригером на апдейты
            wb.execute(SendMessage.builder().chatId("902459907").text("Бот запущен").build());
            // мой чат "902459907"
        }
        catch (Exception exception){
            System.out.println("Неверно укзаны");
        }
    }
}
