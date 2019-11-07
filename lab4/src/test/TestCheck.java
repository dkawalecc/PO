import static java.lang.System.*;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Vector;

import static org.junit.Assert.*;

public class TestCheck {
    /*@Test
    public void parserTest() {
        String[] moves = {"f", "right", "x", "forward", "f", "backward", "raz", " ", "l", "y"};
        MoveDirection[] directions = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT};
        assertEquals(directions, OptionsParser.parse(moves));
    }*/

    @Test
    public void rectangularMapTest() {
        String[] set =  {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection directions[] = new OptionsParser().parse(set);
        IWorldMap map = new RectangularMap(10,5);

        //"isOccupied", "place"
        assertFalse(map.isOccupied(new Vector2d(2,2))); //default animal position
        assertTrue(map.place(new Animal(map))); //first constructor
        /*assertFalse(map.isOccupied(new Vector2d(2,8))); //check given position different form default
        assertTrue(map.place(new Animal(map, new Vector2d(2, 8))));*/
        assertTrue(map.isOccupied(new Vector2d(2,2))); //position already occupied
        assertFalse(map.place(new Animal(map)));    //therefore we should not be able to place the animal with these parameter

        //creating new object
        //using "objectAt" we can check if there is animal that was place by map.place
        //returned object can be casted as Animal
        Animal animal1 = (Animal) map.objectAt(new Vector2d(2,2));

        assertTrue(map.place(new Animal(map, new Vector2d(3,4))));
        Animal animal2 = (Animal) map.objectAt(new Vector2d(3,4));
        //checking if all the parameters are correct
        assertEquals(animal2.getPosition(), new Vector2d(3,4));
        assertEquals(animal2.getOrientation(), MapDirection.NORTH);


        //"run"
        /*map.run(Arrays.copyOfRange(directions,0,2));//f b
        assertEquals(MapDirection.NORTH, animal1.getOrientation());
        assertEquals(MapDirection.NORTH, animal2.getOrientation());*/
        map.run(Arrays.copyOfRange(directions,0,4));//f b r l
        assertEquals(MapDirection.EAST, animal1.getOrientation());
        assertEquals(animal1.getPosition(), new Vector2d(2,3));
        assertEquals(MapDirection.WEST, animal2.getOrientation());
        assertEquals(animal2.getPosition(), new Vector2d(3,3));

        map.run(Arrays.copyOfRange(directions,4,8)); // f f r f
        assertEquals(MapDirection.SOUTH, animal1.getOrientation());
        assertEquals(animal1.getPosition(), new Vector2d(2,3));//positions wont change because animals are next ot each other
        assertEquals(MapDirection.NORTH, animal2.getOrientation());
        assertEquals(animal2.getPosition(), new Vector2d(3,3));

        map.run(Arrays.copyOfRange(directions,8,directions.length));  // f f f f f f f f
        assertEquals(MapDirection.SOUTH, animal1.getOrientation());
        assertEquals(animal1.getPosition(), new Vector2d(2,0));
        assertEquals(MapDirection.NORTH, animal2.getOrientation());
        assertEquals(animal2.getPosition(), new Vector2d(3,7));
    }
}
