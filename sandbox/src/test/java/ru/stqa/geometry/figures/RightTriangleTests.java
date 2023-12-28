package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RightTriangleTests {

    @Test
    void areaRightTriangleTests (){
        Assertions.assertEquals(6.0, new  RightTriangle (4.0, 3.0).AreaRightTriangle());
    }

    @Test
    void cannotCreateRightTriangleWithNegativeSideTest (){

          try {
              new RightTriangle(-3, 2);
              Assertions.fail();
          } catch (IllegalArgumentException exception){

          };



    }
}
