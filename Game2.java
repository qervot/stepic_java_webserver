package ru.geekbrains.games.game_2;

import ru.geekbrains.games.common_games_classes.CanvasPaintListener;
import ru.geekbrains.games.common_games_classes.GameCanvas;

import javax.swing.*;
import java.awt.*;

public class Game2 extends JFrame implements CanvasPaintListener {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String TITLE = "Game2";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game2();
            }
        });
    }

    private Game2() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(POS_X, POS_Y);
        setSize(WIDTH, HEIGHT);
//        setResizable(false);
        setTitle(TITLE);
        GameCanvas gameCanvas = new GameCanvas(this);
        add(gameCanvas);
        setVisible(true);
    }

    @Override
    public void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {

    }
}