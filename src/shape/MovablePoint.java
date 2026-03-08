package shape;

public class MovablePoint implements Movable {
    int x, y, xSpeed, ySpeed; // package access

    // TASK: Add the constructor below
    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Implement abstract methods declared in the interface
    @Override
    public void moveUp() {
        y += ySpeed; // moves y point up by increment ySpeed
    }

    // TASK: Code the other interface methods below
    @Override
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    public String toString() {
        return String.format("MovablePoint[x=%d,y=%d,xSpeed=%d,ySpeed=%d]", x, y, xSpeed, ySpeed);
    }

}
