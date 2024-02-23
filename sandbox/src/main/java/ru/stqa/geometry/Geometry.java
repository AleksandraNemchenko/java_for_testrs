package ru.stqa.geometry;

import ru.stqa.geometry.figures.*;

import java.util.List;
import java.util.function.Consumer;


public class Geometry {
    public static void main(String[] args) {

        var squares = List.of(new Square(7.0),new Square(5.0), new Square(3.0));
//        for (Square square : squares) {
//            Square.printSquareArea(square);
//        }

        squares.forEach(Square::printSquareArea);

//        Rectangle.printRectaglArea (3.0, 2.0);
//        Rectangle.printRectaglArea (7.0, 9.0);
//
//        Triangle t = new Triangle(8.0, 10.0, 6.0);
//        System.out.println(t.perimeter());
//        System.out.println(t.square());
//
//        Triangle t2 = new Triangle (6.0, 6.0, 4.0);
//        System.out.println(t2.perimeter());
//        System.out.println(t2.square());
//
//        Circle c = new Circle(5.0);
//        System.out.println(c.areaCircle());
//
//        RightTriangle d = new RightTriangle (4.0, 3.0);
//        System.out.println(d.AreaRightTriangle());

    }
}
