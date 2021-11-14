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
        try {
            if (update.hasCallbackQuery()) {
                //Обрабатываем нажатие кнопки
                handleCallback(update.getCallbackQuery());
            }
            if (update.hasMessage()) {
                //Обрабатываем получаемый текст
                //handleMessageCommand(update.getMessage());
                handleMessageText(update.getMessage());
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
        if (message.hasText()) {
            try {

                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text(ToWeatherAnswer.getWeatherStr(message.getText()))
                        .build());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
//    public void handleMessageCommand(Message message) throws TelegramApiException {
//        //Обработка команды
//        //Команда есть, когда есть текст и Ентити (сущность)
//        if(message.hasText() && message.hasEntities()){
//
//                Optional<MessageEntity> commandEntity = message.getEntities().stream()
//                        .filter(e -> "bot_command".equals(e.getType()))
//                        .findFirst();
//                if(commandEntity.isPresent()){
//
//                    String command =
//                    message.getText().substring(commandEntity.get().getOffset()
//                            , commandEntity.get().getLength());
//                    switch (command){
//                        case "/set_text":
//                            //Создадим лист с командами
//                            List<List<InlineKeyboardButton>>buttons = new ArrayList<>();
//                            for(DistrictEnum districtEnum : DistrictEnum.values()){
//                                buttons.add(
//                                    Arrays.asList(
//                                        InlineKeyboardButton.builder()
//                                                .text(districtEnum.name())
//                                                .callbackData("Original " + districtEnum)
//                                                .build(),
//                                        InlineKeyboardButton.builder()
//                                                .text(districtEnum.name())
//                                                .callbackData("Target: " + districtEnum)
//                                                .build()));
//                            }
//
//
//
//                            execute(SendMessage.builder()
//                                    .chatId(message.getChatId().toString())
//                                    .text("Введите город для поиска погоды:")
//                                    .replyMarkup(InlineKeyboardMarkup.builder()
//                                            .keyboard(buttons).build())
//                                    .build());
//                    }
//                }
//
//
//        }
//    }
    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
