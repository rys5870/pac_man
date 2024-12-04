public class Tile {

    public int image = 1;
    public int x;
    public int y;
    public int w;
    public int h;
    public int keyX;
    public int keyY;
    boolean isBlocked;

    public Tile() {

    }

    public Tile(Tile other) {
        this.x = other.x;
        this.y = other.y;
        this.w = other.w;
        this.h = other.h;
        this.keyX = other.keyX;
        this.keyY = other.keyY;
        this.isBlocked = other.isBlocked;
        this.image = other.image;
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
