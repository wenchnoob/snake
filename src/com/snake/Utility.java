package com.snake;

import com.snake.ui.Drawable;

public class Utility {


    public static boolean rectangularCollision(Drawable obj1, Drawable obj2) {
        int x1 = obj1.getX();
        int x2 = obj1.getX() + obj1.getW();

        int y1 = obj1.getY();
        int y2 = obj1.getY() + obj1.getH();

        int x1_obj2 = obj2.getX();
        int x2_obj2 = obj2.getX() + obj2.getW();

        int y1_obj2 = obj2.getY();
        int y2_obj2 = obj2.getY() + obj2.getH();

        boolean x_intersects = (x1_obj2 < x1 && x1 < x2_obj2) || (x1_obj2 < x2 && x2 < x2_obj2);
        boolean y_intersects = (y1_obj2 < y1 && y1 < y2_obj2) || (y1_obj2 < y2 && y2 < y2_obj2);

        return x_intersects && y_intersects;
    }
}
