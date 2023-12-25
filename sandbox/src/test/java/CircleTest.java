import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.geometry.figures.Circle;

public class CircleTest {

    @Test
    void areaCircleTest (){
        Assertions.assertEquals(78.53981633974483, new Circle(5.0).areaCircle());
    }
}
