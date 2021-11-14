package telegramBot;

import com.google.gson.Gson;


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
        System.out.println("Gson");
        ClassJsonWeather classJsonWeather = gsonHttp.fromJson(weatherJson,ClassJsonWeather.class);

        System.out.println("classJsonWeather" + classJsonWeather);

        String info = "";
        info += "Температура: " + classJsonWeather.getCurrent().getTemp() + " С\n";
        info += "Ощущается как: " + classJsonWeather.getCurrent().getFeels_like() + " С\n"; //°
        info += "Влажность: " + classJsonWeather.getCurrent().getHumidity() + "%\n";
        info += "Облачность: " + classJsonWeather.getCurrent().getClouds() + "%\n";
        info += "Скорость ветра: " + classJsonWeather.getCurrent().getWind_speed() + " метр/сек\n";

        System.out.println("info");
        String text = "Погода " + district.names.get(1) + " районе:\n";
        text = text + "\n" + info;
        return text;
    }
}
