package ru.geekbrains.games.common_games_classes;

import java.awt.*;

public interface GameObject {

    void update(GameCanvas gameCanvas, float deltaTime);
    void render(GameCanvas gameCanvas, Graphics g);
}
