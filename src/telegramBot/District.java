package telegramBot;

import java.util.List;

public class District {
    double latitude;
    double longitude;
    List<String> names;

    public District(double latitude, double longitude, List<String> names) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.names = names;
    }


    public static String fullDistrict(){
        StringBuffer text = new StringBuffer();
        int count = 1;
        for(DistrictEnum districtEnum : DistrictEnum.values()) {
            text.append((count++) + ". " + districtEnum.district.names.get(0) + " район\n");
        }
        return text.toString();
    }
}
