import java.util.ArrayList;
import java.util.List;

public class Animal implements IMapElement {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();


    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this(map);
        this.position = initialPosition;
    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }


    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                Vector2d v1 = this.position.add(this.orientation.toUnitVector());
                if (map.canMoveTo(v1))
                    this.position = v1;
                break;
            case BACKWARD:
                Vector2d v2 = this.position.subtract(this.orientation.toUnitVector());
                if (map.canMoveTo(v2))
                    this.position = v2;
                break;
        }

    }

    public String toString() {
        return this.orientation.toString();
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public Vector2d getPosition() {
        return this.position;
    }


}