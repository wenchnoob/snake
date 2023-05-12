package com.snake.config;

import java.awt.*;
import java.util.Hashtable;
import java.util.Objects;

public class ConfigManager {

    private static ConfigManager INSTANCE;
    private Hashtable<String, String> configs;

    private ConfigManager() {
        this.configs = new Hashtable<>();
        configs.put("resizeable", "false");
        configs.put("screen_width", "500");
        configs.put("screen_height", "500");
        configs.put("pellet_width", "20");
        configs.put("pellet_height", "20");
    }

    private ConfigManager(String configFile) {
        this();
        // read file and update configs
    }

    public static ConfigManager getInstance() {
        if (Objects.isNull(INSTANCE)) INSTANCE = new ConfigManager();
        return INSTANCE;
    }

    public static void setConfigSource(String configFile) {
        INSTANCE = new ConfigManager(configFile);
    }

    public String getValue(String key) {
        return configs.get(key);
    }

    public boolean getResizeable() {
        return Boolean.parseBoolean(configs.getOrDefault("resizeable", "false"));
    }

    public Dimension getPelletDims() {
        return new Dimension(getPelletWidth(), getPelletHeight());
    }

    public int getPelletWidth() {
        return Integer.parseInt(configs.getOrDefault("pellet_width", "10"));
    }

    public int getPelletHeight() {
        return Integer.parseInt(configs.getOrDefault("pellet_height", "10"));
    }

    public Dimension getWindowDims() {
        return new Dimension(getScreenWidth(), getScreenHeight());
    }

    public int getScreenWidth() {
        return Integer.parseInt(configs.getOrDefault("screen_width", "500"));
    }

    public int getScreenHeight() {
        return Integer.parseInt(configs.getOrDefault("screen_height", "500"));
    }
}
