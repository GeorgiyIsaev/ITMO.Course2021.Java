package Labs.Lab05;

public class Vector {
    public int x;
    public int y;
    public int z;
    public Vector(int x, int y, int z){
        //Конструктор, который принимает 3 параметра
        this.x = x;
        this.y = y;
        this.z = z;

    }
    public double lengthVector(int countDecimal) {
        // Задание 02: Метод для подсчета длины вектора
        double value = Math.sqrt(x * x + y * y + z * z);
        double scale = Math.pow(10, countDecimal); //countDecimal - знаков после запятой
        value = Math.ceil(value * scale) / scale;
        return value;
    }

    public double scalarProduct(Vector vector, int countDecimal){
        // Задание 03: Метода для расчета скалярного произведения

        double value = Math.sqrt(x * vector.x + y * vector.y + z * vector.z);
        double scale = Math.pow(10, countDecimal); //countDecimal - знаков после запятой
        value = Math.ceil(value * scale) / scale;
        return value;
    }


}
