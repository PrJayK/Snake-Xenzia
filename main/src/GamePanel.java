import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    Thread gameThread;
    static boolean game;
    static boolean bigFoodTurn;
    static final int gameWindowHeight = 600;
    static final int windowWidth = 800;
    static final int scoreWindowHeight = 100;
    static final int foodSize = 20;
    final int startFPS = 8;
    final int FPSIncrease = 70;
    final int speed = foodSize;
    static final int bigFoodSize = foodSize*2;
    final int bigFoodInterval = 5;
    int FPS;
    int score;
    int foodCounter;
    KeyHandler KeyH = new KeyHandler();
    Snake snake;
    Food food;
//    BigFood bigFood;

    GamePanel() {
        this.setPreferredSize(new Dimension(windowWidth, gameWindowHeight + scoreWindowHeight));
        this.setDoubleBuffered(true);
        this.setBackground(new Color(40,40,40));
        this.addKeyListener(KeyH);
        this.setFocusable(true);
//        this.addMouseListener(mouseH);
    }

    void setup() {
        game = true;
        FPS = startFPS;
        score = 0;
        foodCounter = 0;
        bigFoodTurn = false;
        snake = new Snake();
        snake.setup();
        food = new Food();
        food.setup();
//        bigFood = new BigFood();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        food.draw(g2D);
//        bigFood.draw(g2D);
        snake.draw(g2D);
        g2D.setColor(Color.WHITE);
        g2D.drawLine(0, gameWindowHeight, windowWidth, gameWindowHeight);
//        g2D.setFont(new Font("Arial", Font.PLAIN, 113));
//        g2D.drawString(String.valueOf(score), 100, gameWindowHeight + scoreWindowHeight/2);
    }

    public void update() {
        if(snake.checkCollision()) {
            game = false;
            gameThread = null;
            return;
        }
        snake.update();
        if(snake.head.x == food.x && snake.head.y == food.y) {
            food.setNewPos();
            snake.increaseLength();
            score += 10;
            foodCounter++;
        }
        if(foodCounter % bigFoodInterval == 0 && !bigFoodTurn) {
            bigFoodTurn = true;
//            bigFood.setNewPos();
        } else {
            bigFoodTurn = false;
        }
        FPS = startFPS + score/FPSIncrease;
        if(KeyH.UP) {
            snake.head.y -= speed;
            if (snake.head.y < 0) {
                snake.head.y = gameWindowHeight - foodSize;
            }
        }
        if(KeyH.LEFT) {
            snake.head.x -= speed;
            if (snake.head.x < 0) {
                snake.head.x = windowWidth - foodSize;
            }
        }
        if(KeyH.DOWN) {
            snake.head.y += speed;
            if (snake.head.y > gameWindowHeight - foodSize) {
                snake.head.y = 0;
            }
        }
        if(KeyH.RIGHT) {
            snake.head.x += speed;
            if (snake.head.x > windowWidth - foodSize) {
                snake.head.x = 0;
            }
        }
    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000/FPS;
        long lastTime = System.nanoTime();
        double delta = 0;
        long currentTime;
        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            lastTime = currentTime;
            if (delta > 1) {
                KeyH.actionListener();
                update();
                repaint();
                delta--;
            }
            drawInterval = (double) 1000000000/FPS;
        }

    }

}
