package test3;

public class DrawShape implements DrawAPI {
    @Override
    public void drawShape(int radius, int x, int y) {
        System.out.println("Drawing Shape: " + radius + ", x: " + x + ", " + y + "]");
    }
}
