//import java.util.Scanner;

public class World {
    public static void main(String[] args) {
        String[] arguments = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(arguments);
        IWorldMap map = new GrassField(10);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map.toString());
    }
}