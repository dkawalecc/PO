import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new ArrayList<>();

    protected abstract Vector2d[] calculateBorder();
    public abstract Object objectAt(Vector2d position);
    public abstract boolean canMoveTo(Vector2d position);

    public boolean isOccupied(Vector2d position) {
        return (objectAt(position) != null);
    }

    public boolean place(Animal animal) {
        //this?
        if (this.canMoveTo(animal.getPosition())) {
            animals.add(animal);
            return true;
        }
        return false;
    }

    public void run(MoveDirection[] directions) {
        for (int i = 0; i < directions.length; i++) {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }

    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        //receive narrow border elements | put them in the table | create 2 elem struct |
        //create separate methods for each elem - probably more complicated
        Vector2d[] border = calculateBorder();
        return map.draw(border[0], border[1]);
    }


}
