public class RectangularMap extends AbstractWorldMap implements IWorldMap {
    private final Vector2d mapLowerLeft = new Vector2d(0,0);
    private final Vector2d mapUpperRight;
    //List<Animal> animals = new ArrayList<>();

    //values have to be correct
    public RectangularMap(int height, int width) {
        this.mapUpperRight = new Vector2d(width, height);
    }

    /*public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }*/

    public boolean canMoveTo(Vector2d position) {
        return (position.follows(mapLowerLeft) && position.precedes(mapUpperRight) && !isOccupied(position));
    }


    protected Vector2d[] calculateBorder() {
        return new Vector2d[] {mapLowerLeft, mapUpperRight};

    }

}


