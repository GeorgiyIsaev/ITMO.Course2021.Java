package labs.lab05;

public class Lab05 {
    public static void main(String[] args) {
        // Лабораторная номер 5

        // Задание 01: Конструктор принимает координаты в качестве параметров
        Vector vector = new Vector(6,3,5);
        System.out.println("Вектор " + vector);
        // Задание 02: Метод для расчета длины вектора
        System.out.println("Длина вектора " +vector +" = "
                + vector.lengthVector(3));
        // Задание 03: Метода для расчета скалярного произведения
        Vector vector2 = new Vector(4,9,1 );
        System.out.println("Скалярное произведение векторов "+ vector
                +" и "+ vector2+" = "
                + vector.scalarProduct(vector2,3));
        // Задание 04: Вычислить векторное произведение
        System.out.println("Векторное произведение векторов "+ vector
                +" и "+ vector2+" = "
                + vector.vectorProduct(vector2));

        // Задание 05: Угол между векторами
        System.out.println("Угол между векторами "+ vector
                +" и "+ vector2+": "
                + vector.cornerVectors(vector2, 3));
        // Задание 06: Сложение и вычитание векторов
        System.out.println("Сложение векторов "+ vector
                +" и "+ vector2+" = "
                + vector.vectorAddition(vector2));
        System.out.println("Вычитание векторов "+ vector
                +" и "+ vector2+" = "
                + vector.vectorSubtract(vector2));

        //Задание 07: Генерация массива векторов из статического метода
        Vector[] vectors = generateArrayVectors(6,0,10);
        System.out.println("\nМассив векторов: ");
        for (Vector value : vectors) {
            System.out.println("Вектор: " + value);
        }

    }

    public static Vector[] generateArrayVectors(int valueSize, int Begin, int End){
        // Статический метод для генерации массива векторов
        // со случайным значениями
        Vector[] vectors = new Vector[valueSize];
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(
                    ((int) (Math.random() * End) + Begin),
                    ((int) (Math.random() * End) + Begin),
                    ((int) (Math.random() * End) + Begin)
            );
        }
        return vectors;
    }
}
