//import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Entity {
    public int x;
    public int y;
    public int speed;
    public BufferedImage up, down, left, right, step2, blue, pink, red;
    public String direction;
    public String lastDirection;
    // public boolean collision = false;
    public int width = 20;
    public int height = 20;
    public boolean enable = false;
    Player player;
    GamePanel gp;
    Tile startTile = TileManager.mapTileNum[18][16];
    public static boolean run = false;


//    public ArrayList<String> getDirections(Tile currentTile, String lastDirection) {
//        ArrayList<String> directions = new ArrayList<>();
//        if (canMoveToDirection(currentTile, "right")) {
//            directions.add("right");
//        }
//        if (canMoveToDirection(currentTile, "left")) {
//            directions.add("left");
//        }
//        if (canMoveToDirection(currentTile, "up")) {
//            directions.add("up");
//        }
//        if (canMoveToDirection(currentTile, "down")) {
//            directions.add("down");
//        }
//        if (direction.isEmpty()) {
//            directions.add(lastDirection);
//        }
//        return directions;
//    }


    boolean meet(Tile b) {

        if (gp.player.x / GamePanel.tileSize == b.x / GamePanel.tileSize && gp.player.y / GamePanel.tileSize == b.y / GamePanel.tileSize) {
           gp.player.direction ="up";
            gp.player.nextDirection ="up";
            if (run) {

                return true;
            } else {
                startAgain();

            }
        }
        return false;
    }


    public Tile CanMove(int x, int y) {
        if (x / GamePanel.tileSize <= GamePanel.ScreenWidth - 1) {
            return TileManager.mapTileNum[x / GamePanel.tileSize][y / GamePanel.tileSize];

        } else return TileManager.mapTileNum[0][y / GamePanel.tileSize];

    }

    public void startAgain() {
        if (GamePanel.life > 0) {
            gp.player.x = GamePanel.tileSize;
            gp.player.y = GamePanel.tileSize;
            gp.inky.x = 18 * GamePanel.tileSize;
            gp.inky.y = 16 * GamePanel.tileSize;
            gp.pinky.x = 18 * GamePanel.tileSize;
            gp.pinky.y = 16 * GamePanel.tileSize;
            gp.clyde.x = 18 * GamePanel.tileSize;
            gp.clyde.y = 16 * GamePanel.tileSize;
            gp.blinky.x = 18 * GamePanel.tileSize;
            gp.blinky.y = 16 * GamePanel.tileSize;

            GamePanel.enabled = false;
            GamePanel.life--;


        }else{
            GamePanel.gameOver = true;
        }

    }

    public Tile randomTile() {
        Tile randomTile1 = new Tile();

        int x, y;
        do {
            Random random = new Random();
            x = random.nextInt(0, GamePanel.maxScreenCol);
            y = random.nextInt(0, GamePanel.maxScreenRow);
            randomTile1.x = x;
            randomTile1.y = y;

        } while (!TileManager.mapTileNum[x][y].isBlocked);


        return randomTile1;
    }

    public Tile randomTile2(int x, int y) {
        Tile randomTile1 = new Tile();

        int x1, y1;
        Random random = new Random();
        do {

            if (x > GamePanel.ScreenWidth / 2) {
                x1 = random.nextInt(0, GamePanel.ScreenWidth / 2);
            } else {
                x1 = random.nextInt(GamePanel.ScreenWidth / 2, GamePanel.ScreenWidth);
            }
            if (y > GamePanel.ScreenHeight / 2) {
                y1 = random.nextInt(0, GamePanel.ScreenHeight / 2);
            } else {
                y1 = random.nextInt(GamePanel.ScreenHeight / 2, GamePanel.ScreenHeight);
            }
            randomTile1.x = x1;
            randomTile1.y = y1;

        } while (!TileManager.mapTileNum[x1 / GamePanel.tileSize][y1 / GamePanel.tileSize].isBlocked);


        return randomTile1;
    }


    boolean canMoveToDirection(Tile currentTile, String direction) {


        int x = currentTile.x, y = currentTile.y;

        Tile tile1 = CanMove(x, y);// TileManager.mapTileNum[x / GamePanel.tileSize][y / GamePanel.tileSize];
        Tile tile2 = CanMove(x, y);// TileManager.mapTileNum[w / GamePanel.tileSize][y / GamePanel.tileSize];
        switch (direction) {

            case "up" -> {

                tile1 = CanMove(x, y - 1);// TileManager.mapTileNum[x / GamePanel.tileSize][y / GamePanel.tileSize];
                tile2 = CanMove(x + GamePanel.tileSize - 1, y - 1);// TileManager.mapTileNum[w / GamePanel.tileSize][y / GamePanel.tileSize];

            }
            case "down" -> {

                tile1 = CanMove(x, y + GamePanel.tileSize);// TileManager.mapTileNum[x / GamePanel.tileSize][y / GamePanel.tileSize];
                tile2 = CanMove(x + GamePanel.tileSize - 1, y + GamePanel.tileSize);// TileManager.mapTileNum[w / GamePanel.tileSize][y / GamePanel.tileSize];
                // System.out.println(tile1.isBlocked + " " + tile2.isBlocked);

            }
            case "left" -> {


                //  System.out.println(currentTile.x - 1);

                tile1 = CanMove(x - 1, y);// TileManager.mapTileNum[x / GamePanel.tileSize][y / GamePanel.tileSize];
                tile2 = CanMove(x - 1, y + GamePanel.tileSize - 1);// TileManager.mapTileNum[x / GamePanel.tileSize][h / GamePanel.tileSize];
            }
            case "right" -> {

                tile1 = CanMove(x + GamePanel.tileSize, y); //TileManager.mapTileNum[w / GamePanel.tileSize][y / GamePanel.tileSize];
                tile2 = CanMove(x + GamePanel.tileSize, y + GamePanel.tileSize - 1); //TileManager.mapTileNum[w / GamePanel.tileSize][h / GamePanel.tileSize];
            }
        }

        return !tile1.isBlocked && !tile2.isBlocked;

    }

}