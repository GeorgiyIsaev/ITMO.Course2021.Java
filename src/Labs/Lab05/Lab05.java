package Labs.Lab05;

public class Lab05 {
    public static void main(String[] args) {
        // Лабораторная номер 5

        // Задание 01: Конструктор принимает координаты в качестве параметров
        Vector vector = new Vector(6,3,5);
        System.out.println("Вектор1: " + vector.strVector());
        // Задание 02: Метод для расчета длины вектора
        System.out.println("Длина вектора " +vector.strVector() +": " + vector.lengthVector(3));
        // Задание 03: Метода для расчета скалярного произведения
        Vector vector2 = new Vector(4,9,1 );
        System.out.println("Скалярное произведение векторов "+ vector.strVector()
                +" и "+ vector2.strVector()+": "
                + vector.scalarProduct(vector2,3));
        // Задание 04: Вычислить векторное произведение
        System.out.println("Векторное произведение векторов "+ vector.strVector()
                +" и "+ vector2.strVector()+": "
                + vector.vectorProduct(vector2).strVector());

        // Задание 05: Угол между векторами
        System.out.println("Угол между векторами "+ vector.strVector()
                +" и "+ vector2.strVector()+": "
                + vector.cornerVectors(vector2, 3));
    }



}
