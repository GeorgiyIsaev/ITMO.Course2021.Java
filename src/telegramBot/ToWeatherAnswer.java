package telegramBot;

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


        String text = "Погода в " + district.names.get(1) + " районе:";
        String weather = WeatherGetJson.currentWeather(district.latitude,district.longitude);
        text= text + "\n" + weather;
        return text;
    }
}
