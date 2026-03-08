import shape.*;

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
        System.out.printf("Area:%.3f, Perimeter:%.3f%n", m2.area(), m2.perimeter());

        Shape m3 = new MovableCircle(0, 0, 5, 5, 20); // upcast
        System.out.println(m3);
        m3.moveRight();
        m3.moveUp();
        System.out.println(m3);
        System.out.printf("Area:%.3f, Perimeter:%.3f%n", m3.area(), m3.perimeter());

    }
}
