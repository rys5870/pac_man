import javax.swing.*;
import java.awt.*;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        SetImages images = new SetImages();
        images.lowdImages();
        JFrame window = new JFrame("pac-man");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

       // window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);
        gamePanel.startGameThread();

    }
}