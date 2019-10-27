import agh.cs.lab2.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2dTest {

    @Test
    public void equalsTest() {
        //take1 the same reference
        Vector2d vector1 = new Vector2d(7, 4);
        Vector2d vector2 = vector1;
        assertEquals(vector1, vector2);
        //take2 different momeory locations but the same values
        vector2 = new Vector2d(7, 4);
        assertEquals(vector1, vector2);
    }

    @Test
    public void toStringTest() {
        Vector2d vector1 = new Vector2d(1, 2);
        String result = "(1,2)";
        assertEquals(result, vector1.toString());
    }

    @Test
    public void precedesTest() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d sameVec = new Vector2d(1, 2);
        Vector2d bigger = new Vector2d(2, 4);
        Vector2d smaller = new Vector2d(0, 0);

        assertTrue(vector1.precedes(sameVec));
        assertTrue(vector1.precedes(bigger));
        assertFalse(vector1.precedes(smaller));
    }

    @Test
    public void followsTest() {
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d sameVec = new Vector2d(1, 2);
        Vector2d bigger = new Vector2d(2, 4);
        Vector2d smaller = new Vector2d(0, 0);

        assertTrue(vector1.follows(sameVec));
        assertFalse(vector1.follows(bigger));
        assertTrue(vector1.follows(smaller));

    }

    @Test
    public void upperRightTest() {
        Vector2d vector1 = new Vector2d(1, 7);
        Vector2d vector2 = new Vector2d(3, 4);
        Vector2d result = new Vector2d(3, 7);

        assertEquals(vector1.upperRight(vector2), result);
    }

    @Test
    public void lowerLeftTest() {
        Vector2d vector1 = new Vector2d(1, 7);
        Vector2d vector2 = new Vector2d(3, 4);
        Vector2d result = new Vector2d(1, 4);

        assertEquals(vector1.lowerLeft(vector2), result);

    }

    @Test
    public void addTest() {
        Vector2d vector1 = new Vector2d(1, 4);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d result = new Vector2d(3, 6);

        assertEquals(vector1.add(vector2), result);
    }

    @Test
    public void subtractTest() {
        Vector2d vector1 = new Vector2d(1, 4);
        Vector2d vector2 = new Vector2d(2, 2);
        Vector2d result = new Vector2d(-1, 2);

        assertEquals(vector1.subtract(vector2), result);
    }

    @Test
    public void oppositeTest() {
        Vector2d vector1 = new Vector2d(1, 4);
        Vector2d result = new Vector2d(-1, -4);

        assertEquals(vector1.opposite(), result);
    }
}
