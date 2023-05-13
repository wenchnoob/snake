package com.snake.ui;

import com.snake.config.ConfigManager;

import javax.swing.*;

public class Screen extends JFrame {

    public Screen() {
        super();
        ConfigManager config = ConfigManager.getInstance();

        this.setMinimumSize(config.getWindowDims());
        // this.setMaximumSize(config.getWindowDims());
        this.setPreferredSize(config.getWindowDims());

        this.setResizable(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(config.getResizeable());
    }

}
