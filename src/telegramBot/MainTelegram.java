package telegramBot;

import org.telegram.telegrambots.bots.DefaultBotOptions;

public class MainTelegram {
    public static void main(String[] args) {
        WeatherBot wb = new WeatherBot(new DefaultBotOptions());


        wb.execute(Exec().chatID.build());

    }
}
