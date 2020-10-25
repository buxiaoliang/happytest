package test3;

/**
 * - OO Design:
 * Consider the following design problem and come up with a class hierarchy:
 * Given a drawing mechanism, we always need to invoke some preprocessing before drawing,
 * and postprocessing after drawing, and also each user will draw different shapes like circle, square,
 * whatever he/she likes. Now, make an OO design of classes so that the routine preprocessing/postprocessing can be hidden,
 * and the user can supply whatever the shape he/she wants to draw.
 * Design:
 * 1) Design Bridge pattern for DrawAPI for different drawer
 * 2) Use Decorator pattern for decorating Circle, Square etc.
 */
public class PrePostShapeDecorator extends ShapeDecorator {
    public PrePostShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        if (decoratedShape.isDecorated()) {
            preProcess(decoratedShape);
        }
        decoratedShape.draw();
        if (decoratedShape.isDecorated()) {
            postProcess(decoratedShape);
        }
    }

    private void preProcess(Shape decoratedShape) {
        System.out.println("PreProcess Start.");
    }

    private void postProcess(Shape decoratedShape) {
        System.out.println("PostProcess Start.");
    }
}
