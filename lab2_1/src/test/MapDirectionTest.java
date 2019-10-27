import org.junit.Test;
import agh.cs.lab2.MapDirection;

import static org.junit.Assert.assertEquals;

public class MapDirectionTest {
    private MapDirection[] mapDirections = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST};

    @Test
    public void nextTest() {
        for (int i = 0; i < mapDirections.length; i++) {
            assertEquals(mapDirections[(i + 1) % mapDirections.length], mapDirections[i].next());
        }
    }

    @Test
    public void previousTest() {
        for (int i = 0; i < mapDirections.length; i++) {
            assertEquals(mapDirections[i], mapDirections[(i + 1) % mapDirections.length].previous());
        }
    }
}
