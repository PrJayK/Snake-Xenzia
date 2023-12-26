import java.awt.*;
public class Food {
    int x,y;
    Snake snake;

    public void setup() {
        snake = new Snake();
        setNewPos();
    }
    public void setNewPos() {
        this.x = GamePanel.foodSize *((int)((GamePanel.windowWidth/GamePanel.foodSize)*Math.random()));
        this.y = GamePanel.foodSize *((int)((GamePanel.gameWindowHeight/GamePanel.foodSize)*Math.random()));
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.GREEN);
        g2D.fillRect(this.x, this.y, GamePanel.foodSize, GamePanel.foodSize);
    }
}
