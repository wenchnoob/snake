package com.snake.ui;

import com.snake.ui.characters.SnakeHead;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.List;

public class GamePane extends JPanel {

    public static GamePane INSTANCE;
    private final List<Drawable> toDraw;

    private GamePane() {
        this.setSize(400, 400);
        this.setPreferredSize(new Dimension(400, 400));
        this.setMinimumSize(new Dimension(200, 200));
        toDraw = new LinkedList<>();
    }

    public void addDrawable(Drawable d) {
        toDraw.add(d);
    }

    public void removeDrawable(Drawable d) {
        toDraw.remove(d);
    }

    public static GamePane getInstance() {
        if (Objects.isNull(INSTANCE)) INSTANCE = new GamePane();
        return INSTANCE;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        toDraw.forEach(d -> d.draw(g));
    }
}
