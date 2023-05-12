package com.snake.ui.characters;

import com.snake.ui.Drawable;
import com.snake.ui.Drawn;

import java.awt.*;
import java.util.Objects;

public class SnakeHead extends Drawn {

    private static SnakeHead INSTANCE;
    private Orientation orientation;

    private SnakeHead(int x, int y, int w, int h, Color color) {
        super(x, y, w, h, color);
        this.orientation = Orientation.EAST;
    }

    public static SnakeHead getInstance() {
        if (Objects.isNull(INSTANCE)) INSTANCE = new SnakeHead(200, 200, 25, 25, Color.GREEN);;
        return INSTANCE;
    }

    public void forward() {
        switch (this.orientation) {
            case NORTH -> this.setY(this.getY() - 1);
            case EAST -> this.setX(this.getX() + 1);
            case SOUTH -> this.setY(this.getY() + 1);
            case WEST -> this.setX(this.getX() - 1);
        }
    }

    public void north() {
        this.orientation = Orientation.NORTH;
    }

    public void east() {
        this.orientation = Orientation.EAST;
    }

    public void south() {
        this.orientation = Orientation.SOUTH;
    }

    public void west() {
        this.orientation = Orientation.WEST;
    }


    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillOval(this.getX(), this.getY(), this.getW(), this.getH());
    }

    @Override
    public void handleCollision(Drawable other) {

    }

    public enum Orientation {
        NORTH, EAST, SOUTH, WEST;
    }
}
