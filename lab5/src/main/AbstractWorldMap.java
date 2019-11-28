import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animalsMap = new HashMap<>();
    protected Map<Vector2d, Grass> grassMap = new HashMap<>();

    protected abstract Vector2d[] calculateBorder();

    public abstract boolean canMoveTo(Vector2d position);

    public Object objectAt(Vector2d position) {
        return this.animalsMap.get(position);
    }

    public boolean isOccupied(Vector2d position) {
        return this.objectAt(position) != null;
    }

    public boolean place(Animal animal) {
        if (!this.canMoveTo(animal.getPosition())) {
            throw new IllegalArgumentException("Nie udało się dodać na pozycji: " + animal.getPosition().toString());
        }

        animal.addObserver(this);
        this.animals.add(animal);
        this.animalsMap.put(animal.getPosition(), animal);
        return true;
    }

    //zmienic
    public void run(MoveDirection[] directions) {
        if (animals.isEmpty())
            return;
        Animal animal;
        Vector2d prev;
        for (int i = 0; i < directions.length; i++) {
            animal = this.animals.get(i % this.animals.size());
            prev = animal.getPosition();
            animal.move(directions[i]);
            if (!animal.getPosition().equals(prev)) {
                animal.positionChanged(prev, animal.getPosition());
            }
        }
    }

    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        //receive narrow border elements | put them in the table | create 2 elem struct |
        //create separate methods for each elem - probably more complicated
        Vector2d[] border = calculateBorder();
        return map.draw(border[0], border[1]);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = this.animalsMap.get(oldPosition);
        animalsMap.remove(oldPosition);
        animalsMap.put(newPosition, animal);
    }

}
