package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void countPerimeterTest (){

        Assertions.assertEquals(24, new Triangle (8.0, 10.0, 6.0).perimeter());
        Assertions.assertEquals(16, new Triangle (6.0, 6.0, 4.0).perimeter());
    }

    @Test
    void  countSquareTest (){

        Assertions.assertEquals(24, new Triangle (8.0, 10.0, 6.0).square());
        Assertions.assertEquals(11.313708498984761, new Triangle (6.0, 6.0, 4.0).square());

    }
}
