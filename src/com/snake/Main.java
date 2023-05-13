package com.snake;

import com.snake.ui.GamePane;
import com.snake.ui.Screen;
import com.snake.ui.characters.Pellet;
import com.snake.ui.characters.SnakeHead;
import com.snake.util.Utility;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String...args) {
        ExecutorService es = Executors.newCachedThreadPool();

        SwingUtilities.invokeLater(() -> {
            GamePane gamePane = GamePane.getInstance();
            SnakeHead sn = SnakeHead.getInstance();
            gamePane.addDrawable(sn);
            gamePane.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP -> sn.north();
                        case KeyEvent.VK_RIGHT -> sn.east();
                        case KeyEvent.VK_DOWN -> sn.south();
                        case KeyEvent.VK_LEFT -> sn.west();
                    }
                }
            });

            Screen screen = new Screen();
            screen.add(gamePane);
            gamePane.setFocusable(true);
            screen.pack();
            screen.setLocationRelativeTo(null);
            screen.setVisible(true);
            gamePane.requestFocusInWindow();
        });

        es.submit(Main::move);
        es.submit(Main::play);
    }

    public static void move() {
        while(true) {
            SnakeHead.getInstance().forward();

            SwingUtilities.invokeLater(() -> {
                GamePane.getInstance().repaint();
            });
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void play() {
        Pellet p = Pellet.Factory.random();
        while(true) {
            if (Utility.rectangularCollision(p, SnakeHead.getInstance())) {
                p.handleCollision(SnakeHead.getInstance());
                SnakeHead.getInstance().handleCollision(p);
                p = Pellet.Factory.random();
            }
        }
    }
}
