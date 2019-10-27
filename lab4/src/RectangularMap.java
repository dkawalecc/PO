public class RectangularMap implements IWorldMap {
    private int height;
    private int width;

    //values have to be correct
    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.precedes(new Vector2d(this.width, this.height)) && position.follows(new Vector2d(0, 0)));
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.getPosition()))
            return false;

        animal = new Animal(new RectanguralMap )
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {

    }

    @Override
    public boolean isOccupied(Vector2d position) {

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {

    }


}
