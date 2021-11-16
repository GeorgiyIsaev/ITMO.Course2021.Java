package telegramBot;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Класс для получения данных о боте из файла
//Читатат
public class StarterFile {

    private String botName = "<botName>";
    private String botToken= "<botToken>";
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

    @Override
    public String toString() {
        return "StarterFile{" +
                "botName='" + botName + '\'' +
                ", botToken='" + botToken + '\'' +
                ", keyOpenWeatherMapOrg='" + keyOpenWeatherMapOrg + '\'' +
                '}';
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
        System.out.println(this);

    }

}