import java.awt.*;
import java.util.ArrayList;

public class Snake {
    int length = 0;
    Snake head;
    int x;
    int y;
    ArrayList<Integer> xPos = new ArrayList<>();
    ArrayList<Integer> yPos = new ArrayList<>();

    public void setup() {
        for(int i = 1; i < length+1; i++) {
            xPos.add(GamePanel.windowWidth /2 - GamePanel.foodSize *(2*i+1));
            yPos.add(GamePanel.gameWindowHeight /2 - GamePanel.foodSize);
        }
        head = new Snake();
        head.x = GamePanel.windowWidth /2;
        head.y = GamePanel.gameWindowHeight /2;
    }

    public boolean checkCollision() {
        for(int i = 0; i < length; i++) {
            if(head.x == xPos.get(i) && head.y == yPos.get(i)) {
                return true;
            }
        }
        return false;
    }
    public void increaseLength() {
        this.length++;
        if(length == 1) {
            this.xPos.add(head.x);
            this.yPos.add(head.y);
        } else {
            this.xPos.add(xPos.get(length-2));
            this.yPos.add(yPos.get(length-2));
        }
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.WHITE);
        for(int i = 0; i < length; i++) {
            g2D.fillRect(xPos.get(i), yPos.get(i), GamePanel.foodSize, GamePanel.foodSize);
        }
        if(!GamePanel.game) {
            g2D.setColor(Color.RED);
        }
        g2D.fillRect(head.x, head.y, GamePanel.foodSize, GamePanel.foodSize);
    }

    public void update() {
        for(int i = length - 1; i > 0; i--) {
            xPos.set(i, xPos.get(i-1));
            yPos.set(i, yPos.get(i-1));
        }
        if(length > 0) {
            xPos.set(0, head.x);
            yPos.set(0, head.y);
        }
    }

}