import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class TileManager {
    GamePanel gp;
    public static Tile[][] mapTileNum;


    public TileManager(GamePanel gp) {
        this.gp = gp;
        mapTileNum = new Tile[GamePanel.maxScreenCol][GamePanel.maxScreenRow];

        loadMap();

    }



    public static void loadMap() {
        try {

            InputStream is = TileManager.class.getResourceAsStream("/maps/map02.txt");
            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            for (int i = 0; i < GamePanel.maxScreenRow; i++) {
                String line = br.readLine();
                String[] numbers = line.split(" ");
                for (int j = 0; j < GamePanel.maxScreenCol; j++) {

                    int num = Integer.parseInt(numbers[j]);
                    if (num==8){
                        num=1;
                    }
                    Tile t = new Tile();
                    t.image = num;
                    t.x = j * GamePanel.tileSize;
                    t.y = i * GamePanel.tileSize;
                    t.w = GamePanel.tileSize * (j + 1) - 1;
                    t.h = GamePanel.tileSize * (i + 1) - 1;
                    t.keyX = j;
                    t.keyY = i;
                    t.isBlocked = SetImages.getImage(num).collision;
                    mapTileNum[j][i] = t;


                }
            }


            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void draw(Graphics2D g2) {

        for (Tile[] tiles : mapTileNum) {
            for (int j = 0; j < mapTileNum[0].length; j++) {
                Tile tile = tiles[j];

                g2.drawImage(SetImages.getImage(tile.image).image, tile.x, tile.y, GamePanel.tileSize, GamePanel.tileSize, null);
            }
        }

    }
}
