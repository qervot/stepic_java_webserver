package ru.geekbrains.games.game_circles;

import ru.geekbrains.games.common_games_classes.CanvasPaintListener;
import ru.geekbrains.games.common_games_classes.GameCanvas;
import ru.geekbrains.games.common_games_classes.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameWindow extends JFrame implements CanvasPaintListener, MouseListener {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String TITLE = "Circles";
    private static final int START_BALLS_COUNT = 10;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }

    private GameObject[] gameObjects = new GameObject[START_BALLS_COUNT + 1];
    private int gameObjectsCount;

    private GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(POS_X, POS_Y);
        setSize(WIDTH, HEIGHT);
//        setResizable(false);
        setTitle(TITLE);
        GameCanvas gameCanvas = new GameCanvas(this);
        gameCanvas.addMouseListener(this);
        add(gameCanvas);
        initGame();
        setVisible(true);
    }

    private void addGameObject(GameObject gameObject) {
        if (gameObjectsCount == gameObjects.length) {
            GameObject[] newGameObjects = new GameObject[gameObjects.length * 2];
            System.arraycopy(gameObjects, 0, newGameObjects, 0, gameObjects.length);
            gameObjects = newGameObjects;
        }
        gameObjects[gameObjectsCount] = gameObject;
        gameObjectsCount++;
    }

    private void removeSprite() {
        if (gameObjects[gameObjectsCount - 1] instanceof Background) return;
        gameObjects[--gameObjectsCount] = null;
    }

    private void initGame() {
        addGameObject(new Background());
        for (int i = 0; i < START_BALLS_COUNT; i++) addGameObject(new Ball());
    }

    private static final float FPS_LOG_INTERVAL = 1f;
    private float fpsTimer;

    @Override
    public void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        float fps = 1f / deltaTime;
        fpsTimer += deltaTime;
        if (fpsTimer >= FPS_LOG_INTERVAL) {
            System.out.println((int) fps);
            fpsTimer = 0f;
        }
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].update(gameCanvas, deltaTime);
        }
    }

    private void render(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < gameObjectsCount; i++) {
            gameObjects[i].render(gameCanvas, g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int button = e.getButton();
        if(button == MouseEvent.BUTTON1){
            addGameObject(new Ball(e.getX(), e.getY()));
        } else if(button == MouseEvent.BUTTON2) {
            System.out.println("button2");
        } else if(button == MouseEvent.BUTTON3) {
            if(gameObjectsCount != 0) removeSprite();
        }
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