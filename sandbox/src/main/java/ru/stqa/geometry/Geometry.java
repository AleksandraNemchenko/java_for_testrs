package ru.stqa.geometry;

import ru.stqa.geometry.figures.*;

public class Geometry {
    public static void main(String[] args) {

        Square.printSquareArea (new Square(7.0));
        Square.printSquareArea (new Square(5.0));
        Square.printSquareArea (new Square(3.0));

        Rectangle.printRectaglArea (3.0, 2.0);
        Rectangle.printRectaglArea (7.0, 9.0);

        Triangle t = new Triangle(8.0, 10.0, 6.0);
        System.out.println(t.perimeter());
        System.out.println(t.square());

        Triangle t2 = new Triangle (6.0, 6.0, 4.0);
        System.out.println(t2.perimeter());
        System.out.println(t2.square());

        Circle c = new Circle(5.0);
        System.out.println(c.areaCircle());

        RightTriangle d = new RightTriangle (4.0, 3.0);
        System.out.println(d.AreaRightTriangle());

    }
}
