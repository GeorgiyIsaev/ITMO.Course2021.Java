package labs.lab11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        copyFileByteTest();

        //ЗАДАНИЕ 05. Написать метод, который в каталоге ищет файлы, в имени
        // которых содержится определенная строка, и который возвращает список
        // имен таких файлов.
        findFileTemplateNameTest();

        //ЗАДАНИЕ 06. Написать метод, который в каталоге ищет текстовые файлы,
        //содержавшие определенную строку. Возвращает список имен таких файлов.
        // (FilenameFilter)
        findFileContainsText();
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

    //ЗАДАНИЕ 04. Написать метод для копирования файла (побайтно, или массивами байт).
    public static void copyFileByteTest(){
        String nameOldFile = "files//test.txt";
        String nameNewFile = "files//newTest.txt";
        copyFileByte(nameOldFile,nameNewFile);
    }

    public static void copyFileByte(String nameOldFile, String nameNewFile){
        //ЗАДАНИЕ 04. Написать метод для копирования файла (побайтно, или массивами байт).
        try(FileInputStream fin=new FileInputStream(nameOldFile); // чтение из файла
            FileOutputStream fos=new FileOutputStream(nameNewFile)) // запись в файл
        {
            byte[] buffer = new byte[fin.available()];
            // считываем буфер
            fin.read(buffer, 0, buffer.length);
            // записываем из буфера в файл
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void findFileTemplateNameTest(){
        //ЗАДАНИЕ 05. Написать метод, который в каталоге ищет файлы, в имени
        // которых содержится определенная строка, и который возвращает список
        // имен таких файлов.
        String nameFind = "test";
        String nameCatalog = "files";
        List<String> findFiles= findFileTemplateName(nameCatalog, nameFind);

        System.out.println("Файлы в папке " + nameCatalog + " содержащие " + "\""+nameFind+"\"");
        for (String file : findFiles) {
            System.out.println("\t> "+ file + ";");
        }


    }
    public static List<String> findFileTemplateName(String nameCatalog,String nameFindFile){
        File dir = new File(nameCatalog); //заходим в каталог
        List<String> files = new ArrayList<>();
        if(dir.isDirectory())
        {
            for(File item : dir.listFiles()){ // проход по файлам
                if(!item.isDirectory()){
                    if(item.getName().toLowerCase().contains(nameFindFile.toLowerCase())) {
                        files.add(item.getName());
                    }
                }
            }
        }
        return files;
    }

    public static void findFileContainsText(){
        //ЗАДАНИЕ 06. Написать метод, который в каталоге ищет текстовые файлы,
        //содержавшие определенную строку. Возвращает список имен таких файлов.
        // (FilenameFilter)
        String nameCatalog = "files";
        String findText = "Какой-то не понятный текст";
        List<String> findFiles = findFileContainsText(nameCatalog,findText);

        System.out.println("Эти файлы сдержат текст: \"" + findText+"\"");
        for (String file : findFiles) {
            System.out.println("\t> "+ file + ";");
        }

    }

    public static List<String>  findFileContainsText(String nameCatalog, String findText){
        //ЗАДАНИЕ 06. Написать метод, который в каталоге ищет текстовые файлы,
        //содержавшие определенную строку. Возвращает список имен таких файлов.
        // (FilenameFilter)

        List<String> files = findFileTemplateName(nameCatalog,""); //все файлы в каталоге
        List<String> filesOnlyFind = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {
            String readText = readFileStr(nameCatalog + "//" + files.get(i));
            if(readText.toLowerCase().contains(findText.toLowerCase())) {
                filesOnlyFind.add(files.get(i));
            }
        }
        return filesOnlyFind;
    }
}
