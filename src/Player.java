import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Entity {


    KeyHandler keyH;
    BufferedImage image = null;

    int timer2 = 0;
    String nextDirection = "";
    Tile currentTile = TileManager.mapTileNum[1][1];
    int point2 = 240;
    int i = 0;
    public static int smallPoint = 0;
    public static int point = 0;


    public Player(GamePanel gp, KeyHandler keyH) {
        x = GamePanel.tileSize;
        y = GamePanel.tileSize;
        width = GamePanel.tileSize;
        height = GamePanel.tileSize;
        speed = 4;//GamePanel.tileSize;
        direction = "up";
        this.gp = gp;
        this.keyH = keyH;

    }





    public void draw(Graphics2D g2) {

            if (i == 10) {
                i = 0;
            }
            if (i > 5) {
                image = SetImages.getImage(3).image;;
                i++;
            } else if(direction.equals("up")){
                image = SetImages.getImage(5).image;;
                i++;
            }else if(direction.equals("down")){
                image = SetImages.getImage(6).image;;
                i++;
            }else if(direction.equals("left")){
                image = SetImages.getImage(7).image;;
                i++;
            }else if(direction.equals("right")){
                image = SetImages.getImage(8).image;;
                i++;
            }




        gp.g2.setColor(Color.white);
        gp.g2.drawString("points:" + String.valueOf(smallPoint + point), GamePanel.ScreenWidth, 40);
        gp.g2.drawString("life:" + String.valueOf(GamePanel.life+1), GamePanel.ScreenWidth, 60);
        gp.g2.setColor(Color.RED);
        Font font = new Font("Impact", Font.BOLD, 50);
        gp.g2.setFont(font);

        g2.drawImage(image, x, y, width, height, null);
        if(GamePanel.gameOver){


            gp.g2.drawString("Game Over!!!", GamePanel.ScreenWidth / 3, GamePanel.ScreenHeight / 2);

        }
    }

    public void update() {

        //   System.out.println(direction + " : " + nextDirection);
        currentTile.x = x;
        currentTile.y = y;

        if (canMoveToDirection(currentTile, nextDirection) && !nextDirection.isEmpty() || nextDirection.equals(direction)) {
            direction = nextDirection;
            nextDirection = "";
        }
        if (smallPoint % 2400 == 0) {
            TileManager.loadMap();
            point2 = 240;
        }
        if (GamePanel.timer == timer2) {
            run = false;
            TileManager.mapTileNum[currentTile.keyX][currentTile.keyY].image = 0;
            gp.pinky.image =SetImages.getImage(9).image;
            gp.inky.image =SetImages.getImage(11).image;
            gp.blinky.image =SetImages.getImage(12).image;
            gp.clyde.image =SetImages.getImage(10).image;
        }
       /* if (meet(currentTile, gp.blinky.currentTile)) {
            gp.blinky.x = 15 * GamePanel.tileSize;
            gp.blinky.y = 17 * GamePanel.tileSize;

            if (!run) {
                gp.pinky.x = 15 * GamePanel.tileSize;
                gp.pinky.y = 17 * GamePanel.tileSize;
                startAgain();
            } else {
                point += 200;
            }

         } else if (meet(currentTile, gp.pinky.currentTile)) {
            gp.pinky.x = 15 * GamePanel.tileSize;
            gp.pinky.y = 17 * GamePanel.tileSize;
            if (!run) {
                gp.blinky.x = 15 * GamePanel.tileSize;
                gp.blinky.y = 17 * GamePanel.tileSize;
                startAgain();
            } else {
                point += 200;
            }
        }
        if (meet(currentTile, gp.try1.currentTile)){
            gp.try1.x = (19 * GamePanel.tileSize);
            gp.try1.y = (15 * GamePanel.tileSize);
            if (!run) {
                // gp.try1.x = 15 * GamePanel.tileSize;
                // gp.try1.y = 17 * GamePanel.tileSize;
                startAgain();
            } else {

                point += 200;
            }
        }*/
        if (currentTile.image == 2) {
            TileManager.mapTileNum[currentTile.x/GamePanel.tileSize][currentTile.y/GamePanel.tileSize].image = 0;
            //gp.g2.drawImage(TileManager.tileImages[0].image, currentTile.x, currentTile.y, GamePanel.tileSize, GamePanel.tileSize, null);
            smallPoint += 10;
            point2--;

        }
        if (currentTile.image == 4) {
            timer2 = GamePanel.timer + 5000;
            run = true;

            TileManager.mapTileNum[currentTile.keyX][currentTile.keyY].image = 0;
            gp.pinky.image =SetImages.getImage(13).image;
            gp.inky.image =SetImages.getImage(13).image;
            gp.blinky.image =SetImages.getImage(13).image;
            gp.clyde.image =SetImages.getImage(13).image;
           // gp.g2.drawImage(TileManager.tileImages[0].image, currentTile.x, currentTile.y, GamePanel.tileSize, GamePanel.tileSize, null);

        }


        if (keyH.upPressed && canMoveToDirection(currentTile, "up")) {
            direction = "up";
        } else if (keyH.upPressed) {
            nextDirection = "up";
        }
        if (keyH.downPressed && canMoveToDirection(currentTile, "down")) {
            direction = "down";
        } else if (keyH.downPressed) {
            nextDirection = "down";
        }
        if (keyH.leftPressed && canMoveToDirection(currentTile, "left")) {
            direction = "left";
        } else if (keyH.leftPressed) {
            nextDirection = "left";
        }
        if (keyH.rightPressed && canMoveToDirection(currentTile, "right")) {
            direction = "right";
        } else if (keyH.rightPressed) {
            nextDirection = "right";
        }

        switch (direction) {
            case "up":
                if (canMoveToDirection(currentTile, direction)) {

                    y -= speed;

                } else {
                    keyH.upPressed = false;
                }

                break;
            case "down":
                if (canMoveToDirection(currentTile, direction)) {
                    y += speed;

                } else {
                    keyH.downPressed = false;
                }
                break;
            case "left":
                if (canMoveToDirection(currentTile, direction)) {
                    x -= speed;
                    if (x <= 0) {
                        x = GamePanel.ScreenWidth - GamePanel.tileSize;
                    }


                } else {
                    keyH.downPressed = false;
                }
                break;
            case "right":
                if (canMoveToDirection(currentTile, direction)) {
                    x += speed;
                    if (x >= GamePanel.ScreenWidth - GamePanel.tileSize) {
                        x = 0;
                    }


                } else {
                    keyH.rightPressed = false;
                }
                break;
        }


        currentTile = TileManager.mapTileNum[x / GamePanel.tileSize][y / GamePanel.tileSize];



    }
}
