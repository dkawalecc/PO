import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RectangularMap implements IWorldMap {
    private int height;
    private int width;
    List<Animal> animals = new ArrayList<>();

    //values have to be correct
    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(this.width, this.height)))   {
            for (Animal animal : animals) {
                if (animal.getPosition().equals(position))
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition()))   {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length; i++) {
            animals.get(i % animals.size()).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal1: animals) {
            if(animal1.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: animals) {
            if(animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }

    public String toString() {
        MapVisualizer map =  new MapVisualizer(this);
        return map.draw(new Vector2d(0,0), new Vector2d(this.width, this.height));
    }

}
