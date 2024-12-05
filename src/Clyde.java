import java.awt.*;
import java.awt.image.BufferedImage;

import java.util.Queue;



public class Clyde extends Entity {
    Player player;

    BufferedImage image = null;
    Tile startTile = TileManager.mapTileNum[18][16];
    Tile currentTile = startTile;
    Queue<Tile> bfs;
    Tile currentTile1;
    Tile currentTile2;
    String nextDirection = "";
    Tile tile = randomTile();

    public Clyde(GamePanel gp, Player player) {
        this.gp = gp;
        this.player = player;
        x = currentTile.x;
        y = currentTile.y;
        width = GamePanel.tileSize;
        height = GamePanel.tileSize;
        speed = 2;
        direction = "up";
        image = SetImages.getImage(10).image;
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
                if (x <= 0) {
                    x = GamePanel.ScreenWidth - GamePanel.tileSize;
                }


                break;
            case "right":

                x += speed;
                if (x >= GamePanel.ScreenWidth - GamePanel.tileSize) {
                    x = 0;
                }

                break;
        }

    }

    public void update() {
        if(meet(currentTile)){
            x = startTile.x;
            y = startTile.y;
        }


//        if (meet(currentTile, player.currentTile)) {
//
//
//            if (!player.run) {
//                x = 15 * GamePanel.tileSize;
//                y = 17 * GamePanel.tileSize;
//                startAgain();
//            } else player.point += 200;
//
//
//        }

        //new Tile(gp.player.x / GamePanel.tileSize, gp.player.currentTile.y / GamePanel.tileSize);

        Tile tile1 = new Tile(currentTile.x / GamePanel.tileSize, currentTile.y / GamePanel.tileSize);


        bfs = Way.bfs2(tile, tile1);

        if (!bfs.isEmpty()) {
            if (bfs.size()<3) {
                tile = randomTile();
            }
            currentTile1 = bfs.poll();

        } else {

            currentTile1 = gp.player.currentTile;
            tile = randomTile();
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
        Tile orginalTile = new Tile(TileManager.mapTileNum[x / GamePanel.tileSize][y / GamePanel.tileSize]);
        currentTile = orginalTile;
    }




}

