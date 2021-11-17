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

    private static StarterFile starterFile;
    public static StarterFile getStarterFile() {
        return starterFile;
    }

    public static void setStarterFile(StarterFile starterFile) {
        WeatherBot.starterFile = starterFile;
    }

    private boolean isReadChat = false;

    protected WeatherBot(DefaultBotOptions options,StarterFile starterFile) {
        super(options);
        this.starterFile = starterFile;
    }

    @Override
    public String getBotUsername() {
        return starterFile.getBotName();
    }

    public String getBotToken(){
        //Токен моего бота
        return starterFile.getBotToken();
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        //Обработчик событий
        Logger.writeLog(update);
        try {

            if(update.hasMessage() &&  // есть сообщение
                    update.getMessage().hasText() &&  //содержит текст
                    update.getMessage().hasEntities()){ //содержит сущность
                //Обработка команды
                // sendTextToTelegram(update.getMessage(), "Запущен блок для команд!");
                handleMessageCommand(update.getMessage());
            }
            else if (isReadChat && //разрешено/запрещено читать чат боту
                    update.hasMessage() &&  // есть сообщение
                    update.getMessage().hasText()) {  //содержит текст
                ///Обработка входящего текст
                handleMessageText(update.getMessage());
            }

        } catch (TelegramApiException e) {
            System.out.println("Ошибка при чтении чата");
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
            System.out.println("Ошибка при тесте");
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
                            "/bot_on_fon - бот считывание чат в фоновом режиме, и реагирует только на ключевые " +
                            "слова\n" +
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
                    ToWeatherAnswer.isFonWrite = false;
                    break;
                case "/bot_on_fon":
                case "/bot_on_fon@GIWeatherBot":
                    sendTextToTelegram(message, "Бот читает чат\n" +
                            "Вы можете ввести название района или его номер " +
                            "для получения информации о погоде" +
                            "(бот не уведомляет если сообщение не корректное)");
                    ToWeatherAnswer.isFonWrite = true;
                    isReadChat = true;
                    break;
                case "/bot_off":
                case "/bot_off@GIWeatherBot":
                    sendTextToTelegram(message, "Бот теперь не читает чат\n" +
                            "Для общения с ботом используйте команды!");
                    isReadChat = false;
                    ToWeatherAnswer.isFonWrite = false;
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
                                    .callbackData(districtEnum.district.names.get(0))
                                    .build(),
                            InlineKeyboardButton.builder()
                                    .text(districtEnum.district.names.get(0) + " район")
                                    .callbackData(districtEnum.district.names.get(0))
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

        if(updates.get(0).getCallbackQuery() != null) {
            Logger.writeLogKey(updates.get(0));
            try {
                execute(SendMessage.builder()
                        .chatId(updates.get(0).getCallbackQuery().getMessage().getChatId().toString())
                        .text(ToWeatherAnswer.getWeatherStr(updates.get(0).getCallbackQuery().getData()))
                        .build());
            } catch (TelegramApiException e) {
                System.out.println("Ошибка при чтении команды");
                System.out.println(e.getMessage());
            }
        }
        super.onUpdatesReceived(updates);
    }
}
