package com.snake.ui;

import java.awt.*;

public interface Drawable {

    void draw(Graphics g);

    void handleCollision(Drawable other);

    int getX();
    int getY();
    int getH();
    int getW();
}
