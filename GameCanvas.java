package ru.geekbrains.games.common_games_classes;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private static final int SLEEPING_TIME = 17;

    private final CanvasPaintListener listener;
    private long lastTime;

    public GameCanvas(CanvasPaintListener listener){
        this.listener = listener;
        lastTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastTime) * 1e-9f;
        lastTime = currentTime;

        listener.onDrawFrame(this, g, deltaTime);
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft(){
        return 0;
    }

    public int getRight(){
        return getWidth() - 1;
    }

    public int getTop(){
        return 0;
    }

    public int getBottom(){
        return getHeight() - 1;
    }
}
