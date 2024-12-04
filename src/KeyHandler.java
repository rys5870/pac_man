import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            upPressed = true;
            downPressed = false;
            leftPressed = false;
            rightPressed = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
            upPressed = false;
            leftPressed = false;
            rightPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
            downPressed = false;
            upPressed = false;
            rightPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
            leftPressed = false;
            downPressed = false;
            upPressed = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       /* int code = e.getKeyCode();
        if (code != KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (code != KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (code != KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (code != KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }*/
    }
}
