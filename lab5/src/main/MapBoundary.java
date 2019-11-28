import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private SortedSet<Vector2d> xAxis = new TreeSet<Vector2d>(new CompareX());
    private SortedSet<Vector2d> yAxis = new TreeSet<Vector2d>(new CompareY());


    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        xAxis.remove(oldPosition);
        yAxis.remove(oldPosition);

        xAxis.add(newPosition);
        yAxis.add(newPosition);

    }

    public void place(IMapElement element) {
        if (element instanceof Animal) {
            ((Animal) element).addObserver(this);
        }
        Vector2d position = element.getPosition();
        xAxis.add(position);
        yAxis.add(position);
    }

    protected Vector2d[] calculateBorder() {
        Vector2d mapLowerLeft;
        Vector2d mapUpperRight;

        //mapBorder is declared only once
        //if xAxis is empty then there are none objects on the map
        if(xAxis.isEmpty()) {
            mapLowerLeft = new Vector2d(0,0);
            mapUpperRight = new Vector2d(0,0);
        } else
        {
            mapLowerLeft = new Vector2d(xAxis.first().x, yAxis.first().y);
            mapUpperRight = new Vector2d(xAxis.last().x, yAxis.last().y);
        }

        return new Vector2d[]{mapLowerLeft, mapUpperRight};
    }
}
