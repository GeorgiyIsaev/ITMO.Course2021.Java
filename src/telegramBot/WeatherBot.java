package telegramBot;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

public class WeatherBot extends DefaultAbsSender {
    protected WeatherBot(DefaultBotOptions options) {
        super(options);
    }

    public String getBotToken(){
        //Токен моего бота
        return "2123760952:AAG0NPXALnTqluyNuicNK_B3x1bKPMa6fN4";
    }
}
