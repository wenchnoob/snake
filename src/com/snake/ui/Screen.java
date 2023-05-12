package com.snake.ui;

import com.snake.config.ConfigManager;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    public Screen() {
        ConfigManager config = ConfigManager.getInstance();

        this.setMinimumSize(config.getWindowDims());
        this.setMaximumSize(config.getWindowDims());
        this.setPreferredSize(config.getWindowDims());

        this.setResizable(config.getResizeable());
    }
}
