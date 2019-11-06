public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);
    private IWorldMap map;


    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this. position = initialPosition;
    }


    public String toString(){
        return this.orientation.toString();
    }

    public void move(MoveDirection direction) {
        Vector2d x1 = this.position;
        Vector2d x2 = this.orientation.toUnitVector();

        switch (direction) {
            case RIGHT:
                this.orientation = this.orientation.next();
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            case FORWARD:
                if ((x1.add(x2)).precedes(new Vector2d(4,4)) && (x1.add(x2)).follows(new Vector2d(0,0)) && map.canMoveTo(this.getPosition()))
                    this.position = this.position.add(this.orientation.toUnitVector());
                break;
            case BACKWARD:
                if ((x1.subtract(x2)).precedes(new Vector2d(4,4)) && (x1.subtract(x2)).follows(new Vector2d(0,0)) && map.canMoveTo(this.getPosition()))
                    this.position = this.position.subtract(this.orientation.toUnitVector());
                break;

        }

    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public Vector2d getPosition() {
        return this.position;
    }


}