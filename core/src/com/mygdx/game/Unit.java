package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Unit extends Rectangle {

    private Texture texture;
    int speed;

    Unit() {
        x = 300;
        y = 0;
        speed = 1;
    }

    public void render(SpriteBatch batch){}

    public void move() {
        this.x += this.speed;
    }

    public void dispose() {
        this.texture.dispose();
    }



}
