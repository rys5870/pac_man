import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    static final int originalTileSize = 4;
    static final int scale = 4;
    static public final int tileSize = originalTileSize * scale;
    public static final int maxScreenCol = 35;
    public static final int maxScreenRow = 38;

    public static final int ScreenWidth = tileSize * maxScreenCol;
    public static final int ScreenHeight = tileSize * maxScreenRow;
    public TileManager tileM = new TileManager(this);
    public Graphics2D g2;
    KeyHandler keyH = new KeyHandler();
    public Collision collision = new Collision(this);
    public Player player = new Player(this, keyH);
    public Blinky blinky = new Blinky(this, player);
    public Pinky pinky = new Pinky(this, player);
    public Inky inky = new Inky(this, player);
    public Clyde clyde = new Clyde(this, player);
    Thread gameThread;
    public static int life = 2;
    public static int level = 1;
    public static int timer = 0;

    public static boolean enabled = false;
    public static boolean gameOver = false;

    GamePanel() {

        this.setPreferredSize(new Dimension(ScreenWidth , ScreenHeight+100));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;
        tileM.draw(g2);
        player.draw(g2);
        blinky.draw(g2);
        pinky.draw(g2);
        inky.draw(g2);
        clyde.draw(g2);
        g2.dispose();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
                timer += 20;
                if (timer % 1000==0) {
                    enabled = true;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            update();
            repaint();
        }

    }

    private void update() {
        if (enabled&&!gameOver) {
            player.update();
            inky.update();
            clyde.update();
            if (Player.smallPoint > (2400 / 4)) {
                blinky.update();
            }
            if (Player.smallPoint > (2400 / 3)) {
                pinky.update();
            }


            collision.update();


        }

    }


}
