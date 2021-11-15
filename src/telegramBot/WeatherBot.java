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
    private boolean isReadChat = false;

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
        System.out.println("ЧатID: " + update.getMessage().getChatId()
                + " Name: " + update.getMessage().getFrom().getFirstName()
                + "\nText: " + update.getMessage().getText());
        try {
            if (update.hasCallbackQuery()) {
                //Обрабатываем нажатие кнопки
                //пока не работает
                sendTextToTelegram(update.getMessage(), "КНОПКА");
                handleCallback(update.getCallbackQuery());
            }
            else if(update.hasMessage() &&  // есть сообщение
                    update.getMessage().hasText() &&  //содержит текст
                    update.getMessage().hasEntities()){ //содержит сущность
                //Обработка команды
                // sendTextToTelegram(update.getMessage(), "Запущен блок для команд!");
                handleMessageCommand(update.getMessage());
            }
            else if (isReadChat && //разрешено/запрещено читать чат боту
                    update.hasMessage() &&  // есть сообщение
                    update.getMessage().hasText()) {  //содержит текст
                //Обработка входящего текст
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
            //sendTextToTelegram(message, command);
            //Обработчик команд
            switch (command) {
                case "/help":
                case "/help@GIWeatherBot":
                    sendTextToTelegram(message, "Команда:\n" +
                            "/help - описание и подсказки\n" +
                            "/districts - Показать доступные районы\n" +
                            "/districts_button - вызвать кнопки с районам\n" +
                            "/bot_on - включить считывание чат ботом\n" +
                            "/bot_off - выключить считывание чат ботом\n" +
                            "\n" +
                            "Когда бот читает чат, при получении наименования района или его номера, он сообщит " +
                            "погоду в этом районе.\n" +
                            "Считывание чата ботом: " + ((isReadChat)?"включено!":"выключено!"));

                    break;
                case "/districts":
                case "/districts@GIWeatherBot":
                    execute(SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text(ToWeatherAnswer.getWeatherStr("0"))
                            .build());
                    break;
                case "/districts_button":
                case "/districts_button@GIWeatherBot":
                    sendTextToTelegram(message, "Меню с кнопками");
                    districtsButton(message); //Создать меню с кнопками
                    break;
                case "/bot_on":
                case "/bot_on@GIWeatherBot":
                    sendTextToTelegram(message, "Бот читает чат\n" +
                            "Вы можете ввести название района или его номер " +
                            "для получения информации о погоде");
                    isReadChat = true;
                    break;
                case "/bot_off":
                case "/bot_off@GIWeatherBot":
                    sendTextToTelegram(message, "Бот теперь не читает чат\n" +
                            "Для общения с ботом используйте команды!");
                    isReadChat = false;
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
                                    .text(districtEnum.district.names.get(0) + " район")
                                    .callbackData("Target: " + districtEnum.district.names.get(0) + " район")
                                    .build()));
        }
        //Отправляем кнопки в чат
        execute(SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text("Выберете район СПБ погода которого вам интересна:")
                .replyMarkup(InlineKeyboardMarkup.builder()
                        .keyboard(buttons).build())
                .build());
    }
    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
