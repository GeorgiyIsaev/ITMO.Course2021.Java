package telegramBot;

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


    ADMIRALTEISKII (new District(59.91563620060743,30.297633736839693,
            List.of("Адмиралтейский","в Адмиралтейском"))),
    VASILEOSTROVSKII(new District(59.94389615169415,30.223476021995936,
            List.of("Василеостровский", "в Василеостровском"))),
    VIBORGSKII(new District(60.083461865686715,30.224849313011557,
            List.of("Выборгский", "в Выборгском"))),
    KALININSKII(new District(60.010658936727154,30.389644234886568,
            List.of("Калининский","в Калининском"))),
    KIROVSKII(new District(59.850023026058224,30.274469051709726,
            List.of( "Кировский"," в Кировском",))),
    KOLPINSKII(new District(59.75424119282505,30.609437293908638,
            List.of("Колпинский", "в Колпинском",))),
    KRASNOGVARDEISKII(new District(59.97626199815711,30.4638019497303,
            List.of("Красногвардейский" , "в Красногвардейском"))),
    KRASNOSELSKII(new District(59.85416834082863,30.16185918842848,
            List.of("Красносельский", "в Красносельском"))),
    KRONSHTADTSKII(new District(60.0051391591721,29.742636220388366,
            List.of("Кронштадтский", "в Кронштадтском"))),
    KURORTNII(new District(60.20087387878063,29.699414843237292,
            List.of("Курортный" ,"в курортном"))),
    MOSKOVSKII(new District(59.853132060710436,30.319101009717542,
            List.of("Московский","в Московском"))),
    NEVSKII(new District(59.903709166647715,30.447195619430396,
            List.of("Невский","в Невский"))),
    PETROGRADSKII(new District(59.96783630510365,30.282348823034166,
            List.of("Петроградский","в Петроградском"))),
    PETRODDVOR(new District( 59.873571436827035,29.913245922643245,
            List.of("Петродворцовый","в Петродворцовом"))),
    PRIMORSKII(new District(60.026469483527464,30.178157418480307
            List.of("Приморский","в Приморском"))),
    PUSHKINSKII(new District(59.7285931571603,30.43778937401814,
            List.of("Пушкинский","в Пушкинском"))),
    FRUNZENSKII(new District(59.867485280680434,30.40138099535739,
            List.of("Фрунзенский","во Фрунзенском"))),
    CENTRALNII(new District(59.93746280057958,30.37178337843117,
            List.of("Центральный","в Центральный")));


    public final District district;

    DistrictEnum(District district) {
        this.district = district;
    }


}
