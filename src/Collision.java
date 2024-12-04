public class Collision {
    GamePanel gp;

    Collision(GamePanel gp) {
        this.gp = gp;
    }

    public static void meet(Tile tile1, Tile tile2, boolean run) {
        Tile home = new Tile(15,17);
        if (tile1.keyX == tile2.keyX && tile1.keyY == tile2.keyY) {
            if (run) {
//Way.bfs(tile2,home);
            } else {

            }
        }

    }

    public void update() {

    }
}
