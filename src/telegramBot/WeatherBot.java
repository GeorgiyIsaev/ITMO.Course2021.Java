package telegramBot;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

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
        //Обработчик событий
        try {

            if(update.hasMessage() &&  // есть сообщение
                    update.getMessage().hasText() &&  //содержит текст
                    update.getMessage().hasEntities()){ //содержит сущность
                //Обработка команды
                sendTextToTelegram(update.getMessage(), "Запущен блок для команд!");
                handleMessageCommand(update.getMessage());
            }
            else if (update.hasMessage() &&  // есть сообщение
                    update.getMessage().hasText()) {  //содержит текст
                //Обработка входящего текст
                handleMessageText(update.getMessage());
            }

            if (update.hasCallbackQuery()) {
                //Обрабатываем нажатие кнопки
                //пока не работает
                handleCallback(update.getCallbackQuery());
            }

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void handleCallback(CallbackQuery callbackQuery){
        Message message = callbackQuery.getMessage();
        String[] param = callbackQuery.getData().split(":");
        String action = param[0];
        DistrictEnum newDistrictEnum = DistrictEnum.valueOf(param[1]);
        System.out.println("action " + action + " param: " + param.toString()                    );
        try {
            execute(SendMessage.builder()
                    .chatId("902459907") //902459907  message.getChatId().toString()
                    .text("action " + action + " param: " + param.toString())
                    .build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        switch (action){
            case "Original":

            case "Target":
        }



    }

    public void handleMessageText(Message message) throws TelegramApiException {
        //Возвращаем ответ обратно
        // метод, который реагирует на апдейты
        //Будет возвращать отправленный текст
         execute(SendMessage.builder()
            .chatId(message.getChatId().toString())
            .text(ToWeatherAnswer.getWeatherStr(message.getText()))
            .build());
    }
    public void sendTextToTelegram(Message message, String answerStr) throws TelegramApiException {
        //Метод для отправки сообщение при изменении
        execute(SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(answerStr)
                .build());
    }


    public void handleMessageCommand(Message message) throws TelegramApiException {
        //Обработка команды
        Optional<MessageEntity> commandEntity = message.getEntities().stream()
                .filter(e -> "bot_command".equals(e.getType()))
                .findFirst();
        //Проверка, что команда есть в списке доступных команд
        if (commandEntity.isPresent()) {

            String command =
                    message.getText().substring(commandEntity.get().getOffset()
                            , commandEntity.get().getLength());
            sendTextToTelegram(message, command);
            //Обработчик команд
            switch (command) {
                case "/help":
                    sendTextToTelegram(message, "Команда help!");
                    break;
                case "/districts":
                    sendTextToTelegram(message, "Команда districts!");
                    break;
                case "/districts_button":
                    sendTextToTelegram(message, "Команда districts_button!");
                    districtsButton(message); //Создать меню с кнопками
                    break;
                case "/bot_on":
                    sendTextToTelegram(message, "Команда bot_on!");
                    break;
                case "/bot_off":
                    sendTextToTelegram(message, "Команда bot_off!");
                    break;

            }
        }
    }
    public void districtsButton(Message message) throws TelegramApiException {
        //Создадим лист с командами
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        for (DistrictEnum districtEnum : DistrictEnum.values()) {
            buttons.add(
                    Arrays.asList(
                            InlineKeyboardButton.builder()
                                    .text(districtEnum.name())
                                    .callbackData("Original " + districtEnum)
                                    .build(),
                            InlineKeyboardButton.builder()
                                    .text(districtEnum.name())
                                    .callbackData("Target: " + districtEnum)
                                    .build()));
        }
        execute(SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text("Введите город для поиска погоды:")
                .replyMarkup(InlineKeyboardMarkup.builder()
                        .keyboard(buttons).build())
                .build());
    }


    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
