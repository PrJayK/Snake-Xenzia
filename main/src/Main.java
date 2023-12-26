import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame gameFrame = new JFrame();
        gameFrame.setTitle("Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);

        GamePanel gamePanel = new GamePanel();
        gamePanel.setup();
        gameFrame.add(gamePanel);
        gameFrame.pack();
        gamePanel.startGameThread();

    }
}