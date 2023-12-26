import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    boolean mouseClicked = false;
    int x, y;
    GamePanel panel;

    @Override
    public void mouseClicked(MouseEvent e) {
        panel = new GamePanel();
//        panel.requestFocus();
        mouseClicked = true;
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
