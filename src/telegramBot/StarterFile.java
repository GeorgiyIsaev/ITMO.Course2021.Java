package telegramBot;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.awt.*;
import java.io.File;

import java.io.IOException;
import java.util.Scanner;

//Класс для получения данных о боте из файла
//Читает токен бота и ключ с погодного сайта

public class StarterFile {
    private String fileName = "starterFileForTelegramBot.json";

    private String botName = "<botName>";
    private String botToken = "<botToken>";
    private String keyOpenWeatherMapOrg = "<keyOpenWeather>";

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    public void setKeyOpenWeatherMapOrg(String keyOpenWeatherMapOrg) {
        this.keyOpenWeatherMapOrg = keyOpenWeatherMapOrg;
    }

    public String getBotName() {
        return botName;
    }

    public String getBotToken() {
        return botToken;
    }

    public String getKeyOpenWeatherMapOrg() {
        return keyOpenWeatherMapOrg;
    }


    public void createJsonFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); //разрешить перенос по строкам
        mapper.writeValue(new File("starterFileForTelegramBot.json"), this);
        System.out.println("json created!");
    }

    public void readJsonFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        StarterFile starterFile = mapper.readValue(new File("starterFileForTelegramBot.json"), StarterFile.class);
        this.botName = starterFile.botName;
        this.botToken = starterFile.botToken;
        this.keyOpenWeatherMapOrg = starterFile.keyOpenWeatherMapOrg;
    }

    public boolean fileChecker() {
        String filename = "starterFileForTelegramBot.json";
        final File file2 = new File(filename);
        return file2.exists();
    }

    public void openFile() throws IOException {
        Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }desktop.open(new File(fileName));
    }

    public void startReadFile() {
        try {
            //Если файла нет, то пересоздать и открыть для заполнения
            if(!fileChecker()){
                createJsonFile();
                if(!fileChecker()){
                    openFile();
                }
                System.out.println("Не обнаружен стартовый файл:\n" +
                        "Введите токен бота и ключ с сайта OpenWeather.org!");
                System.out.print("Нажмите Enter для продолжения: ");
                Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
            }
            //Прочитать настройки если файл есть
            if(fileChecker()) {
                readJsonFile();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}


