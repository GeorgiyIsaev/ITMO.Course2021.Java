package telegramBot;

import com.google.gson.Gson;

import java.util.Locale;


public class ToWeatherAnswer {
    public static boolean isFonWrite = false;

    private static District jsonDistrict(String nameReg){
        String[] splitAnswer = nameReg.split(" ");

        for(DistrictEnum districtEnum : DistrictEnum.values()) {
            for(String districtName :  districtEnum.district.names){
                if (districtName.toLowerCase(Locale.ROOT).equals(nameReg.toLowerCase(Locale.ROOT))){
                    return districtEnum.district;
                }
                for (String str : splitAnswer ) {
                    if(str.length() < 5) continue;
                    if (districtName.toLowerCase(Locale.ROOT).contains(str.toLowerCase(Locale.ROOT))){
                        return districtEnum.district;

                    }
                }

            }
        }
        return null;
    }


    public static String getWeatherStr(String nameReg){

        if (nameReg.equals("0") || nameReg.equals("districts")){
            return District.fullDistrict();
        }

        District district = jsonDistrict(nameReg);
        if (district == null && !isFonWrite){
            return  "Наименование района \""+ nameReg +"\" не найдено!\n" +
                    "Используйте /help - для получения информации\n" +
                    "Отключите уведомления от анализатора бота: /bot_on_fon\n" +
                    "Или выключите анализатор чата: /bot_off ";
        }

        String weatherJson = WeatherGetJson.currentWeather(district.latitude,district.longitude);
        Gson gsonHttp = new Gson();
        ClassJsonWeather classJsonWeather = gsonHttp.fromJson(weatherJson,ClassJsonWeather.class);

        String intro = "Погода " + district.names.get(1) + " районе:\n";
        return intro + classJsonWeather;
    }
}
