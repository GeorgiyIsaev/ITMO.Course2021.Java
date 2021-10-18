package lesson.lesson05;

import java.util.Date;

//Статический блок - использует
// для инициализации статических полей и констант
public class StaticInit {
    public static String str;
    public static Date dateField;
    public static final String STRING_CONSTANT; //Константа
    static {
        str = getEmptyString();
        dateField = new Date();
        STRING_CONSTANT = "unknown";
    }


    private static String getEmptyString() {
        return  "empty";
    }
}
