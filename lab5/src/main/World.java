//import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        try {
            String[] arguments = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};//change
            MoveDirection[] directions = new OptionsParser().parse(arguments);
            IWorldMap map = new GrassField(10);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(3, 4)));
            //map.place(new Animal(map, new Vector2d(3, 4)));
            map.run(directions);
            System.out.println(map.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }
    }
}