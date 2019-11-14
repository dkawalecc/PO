import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class GrassFieldTest {
    @Test
    public void grassFieldSuperTest() {
        GrassField map = new GrassField(13);
        assertEquals(13, map.grassMap.size());
        for (int i = 0; i < map.grassMap.size() - 1; i++) {
            for (int j = i + 1; j < map.grassMap.size(); j++)
                assertNotEquals(map.grassMap.get(i).getPosition(), map.grassMap.get(j).getPosition());
        }
    }

    @Test
    public void canMoveToTest() {
        //initiate the grassField
        GrassField map = new GrassField(10);
        //make one position a blank
        //for each showed a problem
        for (int i = 0; i < map.grassMap.size(); i++) {
            if (map.grassMap.get(i).getPosition().equals(new Vector2d(2,2))) {
                map.grassMap.remove(i);
                break;
            }
        //map.grassMap.remove(Grass..

        //possible since it is blank space
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        map.grassMap.add(new Grass(new Vector2d(2,2)));

        assertTrue(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.place(new Animal(map, new Vector2d(2,2))));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        }
    }

    @Test
    public void objectAtTest() {
        GrassField map = new GrassField(13);
        //place animal and check if the object exists
        map.place(new Animal(map, new Vector2d(2,2)));
        assertTrue(map.objectAt(new Vector2d(2,2)) instanceof Animal);

        map.grassMap.add(new Grass(new Vector2d(3,3)));
        assertTrue(map.objectAt(new Vector2d(3,3)) instanceof Grass);
        map.grassMap.add(new Grass(new Vector2d(2,2)));
        //prio for animal
        assertFalse(map.objectAt(new Vector2d(2,2)) instanceof Grass);

        for (int i = 0; i < map.grassMap.size(); i++) {
            if (map.grassMap.get(i).getPosition().equals(new Vector2d(3, 3))) {
                map.grassMap.remove(i);
                break;
            }
        }
        assertNull(map.objectAt(new Vector2d(3, 3)));

    }

    //calculateBorder
}
