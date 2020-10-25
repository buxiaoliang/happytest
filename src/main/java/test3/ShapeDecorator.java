package test3;

/**
 * Created by bu on 11/15/2016.
 */
public abstract class ShapeDecorator implements IShape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}
