import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Queue;

public class Inky extends Entity {
    Player player;

    BufferedImage image;
    Tile startTile = TileManager.mapTileNum[18][16];
    Tile currentTile = startTile;
    Queue<Tile> bfs;
    Tile currentTile1;
    String nextDirection = "";

    public Inky(GamePanel gp, Player player) {

        this.gp = gp;
        this.player = player;
        x = currentTile.x;
        y = currentTile.y;
        width = GamePanel.tileSize;
        height = GamePanel.tileSize;
        speed = 2;
        direction = "up";
        image = SetImages.getImage(11).image;
    }


    public void draw(Graphics2D g2) {
        g2.drawImage(image, x, y, width, height, null);
    }

    private void chasePlayer() {
        if (currentTile1.x < currentTile.x) {
            nextDirection = "left";
        } else if (currentTile1.x > currentTile.x) {
            nextDirection = "right";
        } else if (currentTile1.y < currentTile.y) {
            nextDirection = "up";
        } else if (currentTile1.y > currentTile.y) {
            nextDirection = "down";
        }
        if (canMoveToDirection(currentTile, nextDirection) && !nextDirection.isEmpty()) {

            direction = nextDirection;
        }
        if (!canMoveToDirection(currentTile, direction)) {
            direction = "step2";
        }


    }

    private void move() {

        switch (direction) {
            case "up":
                y -= speed;
                break;
            case "down":
                y += speed;
                break;
            case "left":
                x -= speed;


                break;
            case "right":

                x += speed;
                break;
        }

    }

    public void update() {

        //   if (Collision.meet(currentTile, player.currentTile,player.run)) {
        if(meet(currentTile)){

            x = startTile.x;
            y = startTile.y;
        }

        Tile tile;
        if (run) {
            tile = randomTile2(gp.player.x, gp.player.y);
        } else {
            tile = new Tile(gp.player.x / GamePanel.tileSize, gp.player.currentTile.keyY);
        }


        Tile tile1 = new Tile(currentTile.x / GamePanel.tileSize, currentTile.y / GamePanel.tileSize);


        bfs = Way.bfs(tile, tile1);

        if (!bfs.isEmpty()) {

            currentTile1 = bfs.poll();


        } else {
            currentTile1 = gp.player.currentTile;
        }


        currentTile1.x *= GamePanel.tileSize;
        currentTile1.y *= GamePanel.tileSize;
        currentTile.x = x;
        currentTile.y = y;
        chasePlayer();
        move();
        updateCurrentTile();

    }

    private void updateCurrentTile() {
        currentTile = new Tile(TileManager.mapTileNum[x / GamePanel.tileSize][y / GamePanel.tileSize]);
    }


}

