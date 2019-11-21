import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    protected List<Grass> grassMap = new ArrayList<>();

    public GrassField(int grassCount) {
        Vector2d lower = new Vector2d(0, 0);
        Vector2d upper = new Vector2d((int) Math.sqrt(grassCount * 10), (int) Math.sqrt(grassCount * 10));

        Vector2d position;
        while (grassCount-- > 0) {
            position = placeRandom(lower, upper);
            while (isOccupied(position)) {
                position = placeRandom(lower, upper);
            }
            grassMap.add(new Grass(position));
            //objects.put(position, new Grass(position));
        }
    }

    private Vector2d placeRandom(Vector2d lower, Vector2d upper) {
        //lower into int is equal 0 in our case
        int x = (int) (Math.random() * (upper.x - lower.x + 1)) + lower.x;
        int y = (int) (Math.random() * (upper.y - lower.y + 1)) + lower.y;

        return new Vector2d(x, y);
    }

    public boolean canMoveTo(Vector2d position) {
        Object that = objectAt(position);
        //prio for animal so we can place it on the grass field
        return (!isOccupied(position) || that instanceof Grass);
        //we already check if the move is inside the border of our map (ReactangularMap)
    }

    protected Vector2d[] calculateBorder() {
        Vector2d mapLowerLeft = new Vector2d(0, 0);
        Vector2d mapUpperRight = new Vector2d(0, 0);
        //check the object HashMap
        for (Vector2d position : super.objects.keySet()) {
            mapLowerLeft = mapLowerLeft.lowerLeft(position);
            mapUpperRight = mapUpperRight.upperRight(position);
        }
        for (Grass grassField : grassMap) {
            mapLowerLeft = mapLowerLeft.lowerLeft(grassField.getPosition());
            mapUpperRight = mapUpperRight.upperRight(grassField.getPosition());
        }
        return new Vector2d[]{mapLowerLeft, mapUpperRight};
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object obj = super.objectAt(position);
        if (obj != null)
            return obj;
        for (Grass grass : grassMap) {
            if (grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }

}

    /*
    public Object objectAt(Vector2d position) {

        for (Animal animal : animals) {
            if (animal.getPosition().equals(position))
                return animal;
        }
        for (Grass grassField : grassMap) {
            if (grassField.getPosition().equals(position))
                return grassField;
        }


        return null;
    }
    */