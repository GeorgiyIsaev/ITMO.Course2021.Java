package telegramBot;

import java.util.ArrayList;

class ClassJsonWeather {
    public float lat;
    public float lon;
    public String timezone;
    public float timezone_offset;
    public Current current;


    // Getter Methods

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public float getTimezone_offset() {
        return timezone_offset;
    }

    public Current getCurrent() {
        return current;
    }

    // Setter Methods

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setTimezone_offset(float timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    @Override
    public String toString() {
        StringBuffer info = new StringBuffer();
        info.append("Температура: " + getCurrent().getTemp() + " °С\n");
        info.append("Ощущается как: " + getCurrent().getFeels_like() + " °С\n"); //°
        info.append("Влажность: " + getCurrent().getHumidity() + "%\n");
        info.append("Облачность: " + getCurrent().getClouds() + "%\n");
        info.append("Скорость ветра: " + getCurrent().getWind_speed() + " метр/сек");
        return info.toString();
    }


    class Current {
        public float dt;
        public float sunrise;
        public float sunset;
        public float temp;
        public float feels_like;
        public float pressure;
        public float humidity;
        public float dew_point;
        public float uvi;
        public float clouds;
        public float visibility;
        public float wind_speed;
        public float wind_deg;
        public ArrayList<Object> weather = new ArrayList<Object>();


        // Getter Methods

        public float getDt() {
            return dt;
        }

        public float getSunrise() {
            return sunrise;
        }

        public float getSunset() {
            return sunset;
        }

        public float getTemp() {
            return temp;
        }

        public float getFeels_like() {
            return feels_like;
        }

        public float getPressure() {
            return pressure;
        }

        public float getHumidity() {
            return humidity;
        }

        public float getDew_point() {
            return dew_point;
        }

        public float getUvi() {
            return uvi;
        }

        public float getClouds() {
            return clouds;
        }

        public float getVisibility() {
            return visibility;
        }

        public float getWind_speed() {
            return wind_speed;
        }

        public float getWind_deg() {
            return wind_deg;
        }

        // Setter Methods

        public void setDt(float dt) {
            this.dt = dt;
        }

        public void setSunrise(float sunrise) {
            this.sunrise = sunrise;
        }

        public void setSunset(float sunset) {
            this.sunset = sunset;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public void setFeels_like(float feels_like) {
            this.feels_like = feels_like;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }

        public void setDew_point(float dew_point) {
            this.dew_point = dew_point;
        }

        public void setUvi(float uvi) {
            this.uvi = uvi;
        }

        public void setClouds(float clouds) {
            this.clouds = clouds;
        }

        public void setVisibility(float visibility) {
            this.visibility = visibility;
        }

        public void setWind_speed(float wind_speed) {
            this.wind_speed = wind_speed;
        }

        public void setWind_deg(float wind_deg) {
            this.wind_deg = wind_deg;
        }
    }
}