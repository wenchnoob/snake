package com.snake.ui;

import java.awt.*;

public interface Drawable {

    public abstract void draw(Graphics g);

    void handleCollision(Drawable other);

    int getX();
    int getY();
    int getH();
    int getW();
}
