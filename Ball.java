package ru.geekbrains.games.circles;

import java.awt.*;

class Ball extends Sprite {

    private float vx = 150f + (float)(Math.random() * 200f);
    private float vy = 150f + (float)(Math.random() * 200f);
    private Color color =
            new Color((int)(Math.random() * 256f), (int)(Math.random() * 256f), (int)(Math.random() * 256f));

    Ball(){
        halfHeight = 20 + (float)(Math.random() * 50f);
        //noinspection SuspiciousNameCombination
        halfWidth = halfHeight;
    }

    Ball(int x, int y){
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
        x += vx * deltaTime;// x = x0 + v * t
        y += vy * deltaTime;
        if(getLeft() < gameCanvas.getLeft()){
            setLeft(gameCanvas.getLeft());
            vx = -vx;
        }
        if(getRight() > gameCanvas.getRight()){
            setRight(gameCanvas.getRight());
            vx = -vx;
        }
        if(getTop() < gameCanvas.getTop()){
            setTop(gameCanvas.getTop());
            vy = -vy;
        }
        if(getBottom() > gameCanvas.getBottom()){
            setBottom(gameCanvas.getBottom());
            vy = -vy;
        }
    }

    @Override
    void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)getLeft(), (int)getTop(), (int)getWidth(), (int)getHeight());
    }
}
