public class TestApp {
    public static void main(String[] args) {
        Movable m1 = new MovablePoint(50, 60, 10, 15); // upcast
        System.out.println(m1);// equivilant to println(m1.toString())
        m1.moveLeft();
        m1.moveDown();
        System.out.println(m1);

        MovableCircle m2 = new MovableCircle(1, 2, 3, 4, 20);
        System.out.println(m2);
        m2.moveRight();
        m2.moveUp();
        System.out.println(m2);
    }
}
