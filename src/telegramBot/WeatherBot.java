package telegramBot;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class WeatherBot extends TelegramLongPollingBot {
    protected WeatherBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotUsername() {
        return "Погодный бот";
    }

    public String getBotToken(){
        //Токен моего бота
        return "2123760952:AAG0NPXALnTqluyNuicNK_B3x1bKPMa6fN4";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        //метод, который реагирует на апдейты
        if (update.hasMessage()){
            Message message = update.getMessage();
            if(message.hasText()){
                try {
                    execute(SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text("Ты сказал " + message.getText())
                            .build());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
