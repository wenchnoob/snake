package com.snake.ui.characters;

import com.snake.config.ConfigManager;
import com.snake.ui.Drawable;
import com.snake.ui.Drawn;
import com.snake.ui.GamePane;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Pellet extends Drawn {

    public static class Factory {
        public static Pellet random() {
            ConfigManager config = ConfigManager.getInstance();
            int randX = ThreadLocalRandom.current().nextInt(config.getScreenWidth());
            int randY = ThreadLocalRandom.current().nextInt(config.getScreenHeight());
            return new Pellet(randX, randY, config.getPelletWidth(), config.getPelletHeight(), Color.YELLOW);
        }
    }

    public Pellet(int x, int y, int w, int h, Color color) {
        super(x, y, w, h, color);
        GamePane.getInstance().addDrawable(this);
    }

    public void handleCollision(Drawable other) {
        GamePane.getInstance().removeDrawable(this);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fillOval(this.getX(), this.getY(), this.getW(), this.getH());
    }
}
