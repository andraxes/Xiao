package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import javax.sound.sampled.SourceDataLine;
import java.util.ArrayList;

public class Castle extends Rectangle {

    private Texture texture;
    private ArrayList<Unit> arrayUnit;

    public void setTexture(Texture texture) {
        this.texture = texture;

        arrayUnit = new ArrayList<>();
    }

    public Texture getTexture() {
        return this.texture;
    }

    public void createUnit(String s) {
        switch (s) {
            case "soldier": {
                arrayUnit.add(new Soldier());
                break;
            }
            case "ninja": {
                arrayUnit.add(new Ninja());
                break;
            }
        }

    }

    public ArrayList<Unit> getArrayUnit() {
        return this.arrayUnit;
    }


}
