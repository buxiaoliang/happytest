package test3;

public abstract class Shape implements IShape{
    protected DrawAPI drawAPI;
    protected boolean decorated;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public void setDecorated(boolean decorated) {
        this.decorated = decorated;
    }

    public boolean isDecorated() {
        return decorated;
    }

    public abstract void draw();
}
