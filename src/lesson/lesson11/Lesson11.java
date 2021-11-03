package lesson.lesson11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lesson11 {
    public static void main(String[] args) {
        /**ЛЕКЦИЯ 11: Files. Потоки*/
        //Потоки бывают: байтовые и символьные

        //Объект класса File имеет методы для отображения информации:
        testFileMethod();


        //Создание, удаление и переименование файла:
        testFileCreateRenameDelete();

        //Чтение и запись в файл
        testFileWriter();
        testFileReader();

        //Класс BufferedReader для считывания в буфер
        testBufferReader();
    }

    public static void testFileMethod() {
        // Объект класса File имеет методы для отображения информации:
        File file = new File("files/test.txt");
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Exists: " + file.exists());
        System.out.println("Parent path:" + file.getParent());
    }

    public static void testFileCreateRenameDelete() {
        // Создание, удаление и переименование файла:
        File file = new File("files/test9.txt");
        //Создадим файл
        try {
            boolean create = file.createNewFile();
            if (create) {
                System.out.println("Создан " + file.getPath());
            } else {
                System.out.println("Не создан " + file.getPath());
            }
        } catch (IOException e) {
            System.out.println("Не возможно создать файл " + file.getPath());
        }

        //Переименуем файл
        File file1 = new File("files/test009.txt");
        boolean renamed = file.renameTo(file1); // переименовываем файл
        if (renamed) {
            System.out.println("Переименован " + file.getPath());
            System.out.println("Переименован в " + file.getName());
        } else {
            System.out.println("Уже есть " + file.getPath());
        }

        //Удалим файл - не выбрасывает исключений
        if (file1.delete()) {
            System.out.println("Файл удален ");
        } else {
            //Если файла нет или отсутствуют права на удаление
            System.out.println("Файл НЕ удален ");
        }
    }

    public static void testFileWriter() {
        //Запись в файл
        File file = new File("files/test9.txt");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Anna ");
            writer.write("Ivan ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Запись в файл
        File filePrint = new File("files/test99.txt");
        try (PrintWriter writer = new PrintWriter(filePrint)) {
            writer.print("hello ");
            writer.print("java ");
            writer.write("java ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testFileReader() {
        //Чтение из файла
        File file = new File("files/test9.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine() + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Прочесть весь файл целимом
        try {
            String text = readMe("files/test9.txt");
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readMe(String fileName) throws IOException {
        //Метод для считывания текста целиком
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }


    public static void testBufferReader() {
        //Позволяет считывать и хранить данные в буфере
        BufferedReader bufferedReader = null;
        try {
            File file = new File("files/testBuff.txt");
            //Если файла нет создать его
            if (!file.exists())
                file.createNewFile();
            try (PrintWriter printWriter = new PrintWriter(file)) {
                //Записать в файл строку
                printWriter.println("str");
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Чтение в буфер
            bufferedReader = new BufferedReader(new FileReader("files/testBuff.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
