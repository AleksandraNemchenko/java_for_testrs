package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;

public class Geometry {
    public static void main(String[] args) {

        Square.printSquareArea (7.0);
        Square.printSquareArea (5.0);
        Square.printSquareArea (3.0);

        Rectangle.printRectaglArea (3.0, 2.0);
        Rectangle.printRectaglArea (7.0, 9.0);

    }

}
