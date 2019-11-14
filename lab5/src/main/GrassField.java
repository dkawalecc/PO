import java.util.ArrayList;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    //private int grassCount;
    //ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Grass> grassMap = new ArrayList<>();

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
        return ( !isOccupied(position)|| that instanceof Grass);
        //we already check if the move is inside the border of our map (ReactangularMap)
    }

    public Object objectAt(Vector2d position) {
        //it is necessary
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

    protected Vector2d[] calculateBorder() {
        //imperative encounter for this problem ;(
        int xMin = Integer.MAX_VALUE;
        int xMax = 0;
        int yMin = Integer.MAX_VALUE;
        int yMax = 0;
        int x, y;

        //check the animals list
        for (Animal animal : animals) {
            x = animal.getPosition().x;
            y = animal.getPosition().y;
            if (x > xMax)
                xMax = x;
            else if (x < xMin)
                xMin = x;
            if (y > yMax)
                yMax = y;
            else if (y < yMin)
                yMin = y;
        }
        //check the grassMap list
        for (Grass grassField : grassMap) {
            x = grassField.getPosition().x;
            y = grassField.getPosition().y;
            if (x > xMax)
                xMax = x;
            else if (x < xMin)
                xMin = x;
            if (y > yMax)
                yMax = y;
            else if (y < yMin)
                yMin = y;
        }

        return new Vector2d[]{new Vector2d(xMin, yMin), new Vector2d(xMax, yMax)};
    }
}
