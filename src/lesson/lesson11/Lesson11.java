package lesson.lesson11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lesson11 {
    public static void main(String[] args) {
        /**ЛЕКЦИЯ 11: Files. Потоки*/
        //Потоки - байтовые и символьные        testFile();
        // testFile();
        // testFileCreateRenameDelete();

        testFileWriter();
        testFileReader();
    }

    public static void testFile(){
        //'\' - слеш дял Win; '/' - слеш дял Unix?
        File fileTest = new File("home/user/image.png");

        File file = new File("files/test.txt");


        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Exists: " + file.exists());
        System.out.println("Parent path:" + file.getParent());
    }
    public static void testFileCreateRenameDelete(){
        File file = new File("files/test9.txt");
        //Создадим файл
        try {
            boolean create = file.createNewFile();
            if (create){
                System.out.println("Создан " + file.getPath());
            }
            else{
                System.out.println("Не создан "+ file.getPath());
            }
        }
        catch (IOException e){
            System.out.println("Не возможно создать файл " + file.getPath());
        }

        //Переименуем файл
        File file1 = new File("files/test009.txt");
        boolean renamed = file.renameTo(file1); // переименовываем файл
        if (renamed){
            System.out.println("Переименован " + file.getPath());
            System.out.println("Переименован в " + file.getName());
        }
        else{
            System.out.println("Уже есть "+ file.getPath());
        }

        //Удалим файл - не выбрасывает исключений
        if(file1.delete()){
            System.out.println("Файл удален ");
        }
        else {
            System.out.println("Файл НЕ удален ");
        }
    }

    public static void testFileWriter(){
        //Запись в файл
        File file = new File("files/test9.txt");

        try (FileWriter  writer = new FileWriter(file)){
            writer.write("Anna ");
            writer.write("Ivan ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Запись в файл
        File filePrint = new File("files/test99.txt");
        try (PrintWriter  writer = new PrintWriter(filePrint)){
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
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine()+ " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Прочесть весь файл целимом
        try {
            String text = readMe("files/test9.txt");
            System.out.println(text);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String readMe(String fileName) throws IOException{
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
