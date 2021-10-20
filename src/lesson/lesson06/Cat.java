package lesson.lesson06;

import java.util.function.BooleanSupplier;

public class Cat {
    public  String  name;
    public  Cat (String name){
        this.name = name;
    }
    private void sayMeow(){
        System.out.println(this.name + "says: \"Meow\"");
    }
    public class Bow{
        //вложенный класс
        private String colour;
        public Bow(String colour){
            this.colour = colour;
        }
        public void printColour(){
            System.out.println("Цвета банта "+  name + " - " + colour);
        }
        public void putBow(){
            sayMeow();
            System.out.println("Бант надет");
       }
    }
}
