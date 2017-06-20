package ru.geekbrains.games.common_games_classes;

import java.awt.*;

public interface CanvasPaintListener {

    void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime);
}
