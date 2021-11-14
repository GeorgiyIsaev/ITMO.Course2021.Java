package telegramBot;

import com.google.gson.Gson;
import labs.lab13.Root;

public class ToWeatherAnswer {

    private static District jsonDistrict(String nameReg){
        for(DistrictEnum districtEnum : DistrictEnum.values()) {
            for(String districtName :  districtEnum.district.names){
                if (districtName.equals(nameReg)){
                    return districtEnum.district;
                }
            }
        }
        return null;
    }


    public static String getWeatherStr(String nameReg){
        if (nameReg.equals("0")){
            return District.fullDistrict();
        }
        District district = jsonDistrict(nameReg);
        if (district == null){
            return "Наименование района не найдено!";
        }
        String weatherJson = WeatherGetJson.currentWeather(district.latitude,district.longitude);
        Gson gsonHttp = new Gson();
        ClassJsonWeather classJsonWeather = gsonHttp.fromJson(weatherJson,ClassJsonWeather.class);

        String text = "Погода в " + district.names.get(1) + " районе:";
        text= text + "\n" + weatherJson;
        return text;
    }
}
