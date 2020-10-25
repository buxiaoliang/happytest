package test3;

public class Square extends Shape {

    private int x;

    public Square(int x, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
    }

    public void draw() {
        drawAPI.drawShape(0, x, x);
    }
}
