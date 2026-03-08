package shape;

public class MovableCircle implements Movable, Shape {
    private MovablePoint center;
    private int radius;

    // TASK: Add the constructor here
    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    // TASK: Implement all abstract methods declared in the interface
    @Override
    public void moveUp() {
        center.moveUp();// move the center up
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    public String toString() {
        return String.format("MovableCircle[center=%s,radius=%d]", center.toString(), radius);
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return Math.PI * 2 * radius;
    }
}
