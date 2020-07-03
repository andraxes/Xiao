package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import javax.sound.sampled.SourceDataLine;
import java.util.ArrayList;

public class Castle extends Rectangle {

    private Texture texture;
    private ArrayList<Soldier> arraySoldier;

    public void setTexture(Texture texture) {
        this.texture = texture;

        arraySoldier = new ArrayList<Soldier>();
    }

    public Texture getTexture() {
        return this.texture;
    }

    public void createSoldier(String s) {
        switch (s) {
            case "soldier": {
                arraySoldier.add(new Soldier());
                break;
            }
            case "ninja": {
                arraySoldier.add(new Ninja());
                break;
            }
        }

    }

    public ArrayList<Soldier> getArraySoldier() {
        return this.arraySoldier;
    }


}
