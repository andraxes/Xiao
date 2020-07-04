package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class ButtonUnit extends Rectangle {

    private Texture texture;

    ButtonUnit(Texture texture) {
        this.texture = texture;
        this.width = 80;
        this.height = 100;
    }

    public Texture getTexture() {
        return this.texture;
    }

    public void clicked(Castle castle, String s) {
        castle.createUnit(s);
    }


}
