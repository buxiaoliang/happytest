package test3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrePostShapeDecoratorTest {

    @Test
    void draw() {
        Circle circleImpl = new Circle(100, 100, 10, new DrawShape());
        IShape circle = new PrePostShapeDecorator(circleImpl);
        circle.draw();
        // decorated enabled
        circleImpl.setDecorated(true);
        circle.draw();

        Square squareImpl = new Square(100, new DrawShape());
        IShape square = new PrePostShapeDecorator(squareImpl);
        square.draw();
        // decorated enabled
        squareImpl.setDecorated(true);
        square.draw();
    }
}