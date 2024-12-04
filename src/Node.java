import java.util.ArrayList;
import java.util.List;

class Node {
    Tile tile;
    int distance;
    List<Tile> path;

    public Node(Tile tile, int distance, List<Tile> path) {
        this.tile = tile;
        this.distance = distance;
        this.path = new ArrayList<>(path);
        this.path.add(tile);
    }
}