package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Ninja extends Soldier {

    private Texture texture;

    Ninja() {
        this.texture = new Texture("ninja.png");
        x = 300;
        y = 0;
    }

    public void render(SpriteBatch batch) {
        move();

        batch.draw(this.texture, this.x, this.y);
    }

    public void move() {
        this.x += 2;
    }

    public void dispose() {
        this.texture.dispose();
    }



}
