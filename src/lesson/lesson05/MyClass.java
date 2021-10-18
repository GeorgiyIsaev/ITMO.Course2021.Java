package lesson.lesson05;

public class MyClass {
    int field;
    public void print(){
        System.out.print(this.field);
    }
    public static void printStatic(){
        System.out.print("static member");
    }
}

class  MyClassStatic{
    public static void main(String[] args){
        MyClass object = new MyClass();
        object.field = 10;
        object.print();

        MyClass.printStatic();
    }
}