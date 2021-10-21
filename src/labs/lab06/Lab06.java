package labs.lab06;

public class Lab06 {
    public static void main(String[] args) {
        /**Лабораторная 06: Структуры данных*/

        //Задание 01: Доработать Класс Study
        //Создать Конструктор, который принимает и устанавливает поле course.
        //Создать объект класса с параметром course == «Изучение Java - это просто!
        //Вывести значение класса используя метод «printCourse»
        Study study = new Study("Изучение Java - это просто!");
        System.out.println(study.printCourse());

        //Задание02: Создайте класс Дом. Добавьте в него следующие данные:
        //●	поля: количество этажей, год постройки, наименование;
        //●	метод для установки всех значений;
        //●	метод для вывода всех значений;
        //●	метод, возвращающий количество лет с момента постройки.
        //На основе класса создайте два объекта и пропишите для каждого
        // характеристики. Добавление характеристик реализуйте через
        // метод класса.
        //Выведите информацию про каждый объект.
        Home home = new Home(5, 1973, "Хрущевка" );
        System.out.println(home);
        home.print();
        System.out.println("С момента постройки " +
                home.getCountYearAfterBuild() + " лет");

        Home myHome = new Home();
        System.out.println(myHome);
        myHome.createHome(2,2020, "Дачный");
        System.out.println(myHome);
        System.out.println("С момента постройки " +
                myHome.getCountYearAfterBuild() + " год");





    }
}
