package labs.lab11;

import java.io.*;

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
        mergeTwoFilesTest();
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
        String readText = readFileStr("files//test.txt");
        System.out.println("Прочитан текст\n"+ readText);
    }

    public static void writeFileTest(){
        //ЗАДАНИЕ 02. Написать метод, который записывает в файл строку,
        // переданную параметром.
        if(writeFileStr("files//test.txt","Какой-то не понятный текст")){
            System.out.println("Файл успешно записан!");
        }
    }
    public static boolean writeFileStr(String nameFile,String text){
        //Запись текста в файл
        try(FileWriter writer = new FileWriter(nameFile, false))
        {
            writer.write(text);   //записать строку в буфер
            writer.flush(); //запись из буфера в файл
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    public static String readFileStr(String nameFile){
        //Чтение текста из файла
        String textRead = "";
        try(FileReader reader = new FileReader(nameFile))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){ // посимвольное чтение
                textRead += (char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return textRead;
    }

    public static void mergeTwoFilesTest(){
        //ЗАДАНИЕ 03. Используя решение 1 и 2, напишите метод, который склеивает
        // два текстовых файла один.
        mergeTwoFiles("files//mergeFile.txt",
                "files//test.txt", "files//test2.txt");
        String readText = readFileStr("files//mergeFile.txt");
        System.out.println("Прочитан текст\n"+ readText);

    }
    public static boolean mergeTwoFiles(String nameNewFile,
                                        String nameFile1,
                                        String nameFile2){
        String newText = readFileStr(nameFile1) + "\n"  + readFileStr(nameFile2);
        if(writeFileStr(nameNewFile,
                newText)){
            System.out.println("Файл успешно записан!");
            return true;
        }
        else {
            return false;
        }
    }

}
