package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Soldier extends Unit {

    private Texture texture;

    Soldier() {
        this.texture = new Texture("soldier.png");
    }

    public void render(SpriteBatch batch) {
        move();
        batch.draw(this.texture, this.x, this.y);
    }
}
