package telegramBot;

import java.util.ArrayList;
import java.util.List;

public enum DistrictEnum {
    //1. Адмиралтейский
    // 2. Василеостровский
    // 3. Выборгский
    // 4. Калининский
    // 5. Кировский
    // 6. Колпинский
    // 7. Красногвардейский
    // 8. Красносельский
    // 9. Кронштадтский
    // 10. Курортный
    // 11. Московский
    // 12. Невский
    // 13. Петроградский
    // 14. Петродворцовый
    // 15. Приморский
    // 16. Пушкинский
    // 17. Фрунзенский
    // 18. Центральный.


    ADMIRALTEISKII (new District(0, 0, List.of("Адмиралтейский","Адмиралтейском"))),
    VASILEOSTROVSKII(new District(0,0,  List.of("Василеостровский"))),
    VIBORGSKII(new District(0,0,  List.of("Выборгский"))),
    KALININSKII(new District(0,0,  List.of("Калининский"))),
    KIROVSKII(new District(0,0,  List.of("Кировский"))),
    KOLPINSKII(new District(0,0,  List.of("Колпинский"))),
    KRASNOGVARDEISKII(new District(0,0,  List.of("Красногвардейский"))),
    KRASNOSELSKII(new District(0,0,  List.of("Красногвардейский"))),
    KRONSHTADTSKII(new District(0,0,  List.of("Кронштадтский"))),
    KURORTNII(new District(0,0,  List.of("Курортный"))),
    MOSKOVSKII(new District(0,0,  List.of("Московский"))),
    NEVSKII(new District(0,0,  List.of("Невский"))),
    PETROGRADSKII(new District(0,0,  List.of("Петроградский"))),
    PETRODDVOR(new District(0,0,  List.of("Петродворцовый"))),
    PRIMORSKII(new District(0,0,  List.of("Приморский"))),
    PUSHKINSKII(new District(0,0,  List.of("Пушкинский"))),
    FRUNZENSKII(new District(0,0,  List.of("Фрунзенский"))),
    CENTRALNII(new District(0,0,  List.of("Центральный")));


    private final District district;

    DistrictEnum(District district) {
        this.district = district;
    }

}
