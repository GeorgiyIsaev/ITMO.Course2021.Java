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
    public String  strVector(){
        return "{" + x + ", " + y + ", " + z + "}";
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
    public Vector vectorProduct(Vector vector){
        // Задание 04: Вычислить векторное произведение
        int newX = y * vector.z - z * vector.y;
        int newY = z * vector.x - x * vector.z;
        int newZ = x * vector.y - y * vector.x;
        return new Vector(newX,newY, newZ);
    }
    public double cornerVectors(Vector vector, int countDecimal){
        // Задание 05: Вычислить угол между векторами
        double value = scalarProduct(vector, 3) /
                (this.lengthVector(3)
                        * vector.lengthVector(3));

        double scale = Math.pow(10, countDecimal); //countDecimal - знаков после запятой
        value = Math.ceil(value * scale) / scale;
        return value;
    }

    public Vector vectorSubtract(Vector vector){
        //subtract and addition
        // Задание 05: Вычитание векторов
        return new Vector(
                x - vector.x,
                y - vector.y,
                z - vector.z);
    }
    public Vector vectorAddition(Vector vector){
        // Задание 05: Сложение векторов
        return new Vector(
                x + vector.x,
                y + vector.y,
                z + vector.z);
    }

}
