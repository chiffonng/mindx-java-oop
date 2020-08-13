package game;

import Player.Player;
import screen.PlayScreen;
import screen.ScreenManager;
import screen.WelcomeScreen;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;

    public GamePanel() {
//        background = new Background();
//        player = new Player();
//        new EnemySummoner();
        ScreenManager.signNewScreen(new WelcomeScreen());
    }

    @Override
    public void paint(Graphics g) {
//            g.setColor(Color.red);
//            g.drawRect(100, 100, 100, 100);
//            g.fillRect(300, 100, 100, 100);
        // fix bug render: fill white for background in every frame move in gameLoop()
        g.setColor(Color.white);
        g.fillRect(0, 0, Settings.GAME_WIDTH, Settings.GAME_HEIGHT);
        GameObject.renderAll(g);
        if (ScreenManager.currentScreen instanceof PlayScreen) {
            g.setColor(Color.BLACK);
            g.fillRect(Settings.BACKGROUND_WIDTH, 0, Settings.GAME_WIDTH - Settings.BACKGROUND_WIDTH, Settings.GAME_HEIGHT);
        }
    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 1000000000 / 40) {
                repaint(); //rerun paint
                GameObject.runAll();
                lastTime = currentTime;
            }
        }
    }
}

