package ru.geekbrains.games.common_games_classes;

import java.awt.*;

@SuppressWarnings("WeakerAccess")
public class Sprite implements GameObject {

    protected float x; //центр спрайта
    protected float y; //центр спрайта
    protected float halfWidth;
    protected float halfHeight;

    public float getLeft(){
        return x - halfWidth;
    }

    public void setLeft(float left){
        x = left + halfWidth;
    }

    public float getRight(){
        return x + halfWidth;
    }

    public void setRight(float right) {
        x = right - halfWidth;
    }

    public float getTop(){
        return y - halfHeight;
    }

    public void setTop(float top) {
        y = top + halfHeight;
    }

    public float getBottom() {
        return y + halfHeight;
    }

    public void setBottom(float bottom){
        y = bottom - halfHeight;
    }

    public float getWidth(){
        return 2f * halfWidth;
    }

    public float getHeight(){
        return 2f * halfHeight;
    }

    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {}

    @Override
    public void render(GameCanvas gameCanvas, Graphics g){}
}
