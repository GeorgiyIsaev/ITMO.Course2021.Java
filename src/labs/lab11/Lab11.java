package labs.lab11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab11 {
    public static void main(String[] args) {
        //ЗАДАНИЕ 01. Написать метод, который читает текстовый файл и возвращает
        // его в виде списка строк.
        readFileTest();
        //ЗАДАНИЕ 02. Написать метод, который записывает в файл строку,
        // переданную параметром.
        writeFileTest();

        //ЗАДАНИЕ 03. Используя решение 1 и 2, напишите метод, который склеивает
        // два текстовых файла один.

        //ЗАДАНИЕ 04. Написать метод для копирования файла (побайтно, или массивами байт).

        //ЗАДАНИЕ 05. Написать метод, который в каталоге ищет файлы, в имени
        // которых содержится определенная строка, и который возвращает список
        // имен таких файлов.

        //ЗАДАНИЕ 06. Написать метод, который в каталоге ищет текстовые файлы,
        //содержавшие определенную строку. Возвращает список имен таких файлов.
        // (FilenameFilter)
    }
    public static void readFileTest(){
        //ЗАДАНИЕ 01. Написать метод, который читает текстовый файл и возвращает
        // его в виде списка строк.
        String readText = readFileStr("test.txt");


    }

    public static void writeFileTest(){
        //ЗАДАНИЕ 02. Написать метод, который записывает в файл строку,
        // переданную параметром.
        writeFileStr("test.txt","Какой-то не понятный текст");

    }
    public static void writeFileStr(String nameFile,String text){
        try(FileOutputStream fos=new FileOutputStream(nameFile))
        {
            byte[] buffer = text.getBytes(); //перевести в байты
            fos.write(buffer, 0, buffer.length); //записать текст
            System.out.println("Файл успешно записан!");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static String readFileStr(String nameFile){
        String textRead = "";
        try(FileInputStream fin=new FileInputStream(nameFile))
        {
            System.out.printf("File size: %d bytes \n", fin.available());
            int i=-1;
            while((i=fin.read())!=-1){
                textRead +=(char)i;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return textRead;

    }

}
