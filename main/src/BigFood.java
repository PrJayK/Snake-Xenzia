import java.awt.*;
public class BigFood {
    int x,y;
    Snake snake;

    public void setup() {
        snake = new Snake();
    }
    public void setNewPos() {
        this.x = GamePanel.bigFoodSize*((int)((GamePanel.windowWidth/GamePanel.bigFoodSize-1)*Math.random()));
        this.y = GamePanel.bigFoodSize*((int)((GamePanel.gameWindowHeight/GamePanel.bigFoodSize-1)*Math.random()));
    }

    public void draw(Graphics2D g2D) {
        if(GamePanel.bigFoodTurn) {
            g2D.setColor(Color.YELLOW);
            g2D.fillRect(this.x, this.y, GamePanel.bigFoodSize, GamePanel.bigFoodSize);
        }
    }
}
