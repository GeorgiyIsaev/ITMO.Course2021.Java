package lesson.lesson06;

public class Paint {
    private static int light;
    private static int width;

    public static void setLight(int light) {
        Paint.light = light;
    }

    public static void setWidth(int width) {
        Paint.width = width;
    }

    private String name;
    private static void drawBear() {
        System.out.println("Bear was drawn in a sketch!");
    }
    public static class Sketch {
        private int id;
        public Sketch(int id) {
            this.id = id;
        }
        public void drawSketch() {
            drawForest();
            drawBear();
        }
        private void drawForest() {
            if(Paint.light > 5 && Paint.width > 3){
                System.out.println("Big Forest");
            }
            else
            System.out.println("Forest was drawn in sketch!");
        }
    }
}