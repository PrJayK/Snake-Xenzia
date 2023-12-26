import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Queue;

public class KeyHandler implements KeyListener {

    Queue<Integer> actionQueue = new LinkedList<>();
    boolean UP, LEFT, DOWN, RIGHT;
    GamePanel panel;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        panel = new GamePanel();
        int code = e.getKeyCode();
        actionQueue.add(code);

    }

    public void actionListener() {
        if(actionQueue.isEmpty()) {
            return;
        }
        int code = actionQueue.remove();
        if(code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
            if(!DOWN) {
                UP = true;
                LEFT = RIGHT = false;
            }
        }
        if(code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
            if(!RIGHT) {
                LEFT = true;
                UP = DOWN = false;
            }
        }
        if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
            if(!UP) {
                DOWN = true;
                LEFT = RIGHT = false;
            }
        }
        if(code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
            if(!LEFT) {
                RIGHT = true;
                UP = DOWN = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
