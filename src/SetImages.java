import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SetImages {
   static public List<TileImage> imagelist = new ArrayList<>();

   public  SetImages(){
        lowdImages();
    }
     void addImage(BufferedImage image ,boolean collision){
       TileImage tileImage = new TileImage();
       tileImage.image = image;
       tileImage.collision = collision;
        imagelist.add(tileImage);
    }
    public static TileImage getImage(int num){
       return imagelist.get(num);
    }
    void lowdImages(){
        try {
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/black.png")))),false);//0
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/wall.png")))),true);//1
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/smallPoint.png")))),false);//2
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/step2.png")))),true);//3
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/bigPoint.png")))),false);//4
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/up.png")))),true);//5
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/down.png")))),true);//6
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/left.png")))),true);//7
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/right.png")))),true);//8
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/pinkGhost.png")))),true);//9
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/orangeGhost.png")))),true);//10
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/redGhost.png")))),true);//11
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/blueGhost.png")))),true);//12
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/scaredGhost.png")))),true);//13
            addImage( ImageIO.read((Objects.requireNonNull(getClass().getResourceAsStream("/images/cherry2.png")))),true);//14

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
