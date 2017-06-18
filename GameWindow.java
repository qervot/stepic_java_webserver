package ru.geekbrains.games.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWindow extends JFrame {

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

    private Sprite[] sprites = new Sprite[START_BALLS_COUNT + 1];
    private int spritesCount;

    private GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(POS_X, POS_Y);
        setSize(WIDTH, HEIGHT);
//        setResizable(false);
        setTitle(TITLE);
        GameCanvas gameCanvas = new GameCanvas(this);
        gameCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                @Override
//                public void mousePressed(MouseEvent e){
//               int button == e.getButton();
//                if (button == MouseEvent.BUTTON1);
//                    System.out.println("");
               addSprite(new Ball(e.getX(), e.getY()));
            }
        });
        add(gameCanvas);
        initGame();
        setVisible(true);
    }

    private void addSprite(Sprite sprite){
        if(spritesCount == sprites.length){
            Sprite[] newSprites = new Sprite[sprites.length * 2];
            System.arraycopy(sprites, 0, newSprites, 0, sprites.length);
            sprites = newSprites;
        }
        sprites[spritesCount] = sprite;
        spritesCount++;
    }
    private void removeSprite() {

    }

    private void initGame(){
        addSprite(new Background());
        for (int i = 0; i < START_BALLS_COUNT; i++) addSprite(new Ball());
    }

    private static final float FPS_LOG_INTERVAL = 1f;
    private float fpsTimer;

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime) {
        float fps = 1f / deltaTime;
        fpsTimer += deltaTime;
        if(fpsTimer >= FPS_LOG_INTERVAL) {
            System.out.println((int) fps);
            fpsTimer = 0f;
        }
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime){
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].update(gameCanvas, deltaTime);
        }
    }

    private void render(GameCanvas gameCanvas, Graphics g){
        for (int i = 0; i < spritesCount; i++) {
            sprites[i].render(gameCanvas, g);
        }
    }
}
