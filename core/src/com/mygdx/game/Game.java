package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Game extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	SpriteBatch batchButton;
	SpriteBatch batchBackground;
	Texture img;
	Castle castle;
	int dragX = 0;
	boolean isAllowDrag = false;
	Texture background;
	Texture background2;
	//String tap;

	ButtonUnit buttonSoldier;
	Texture tbuttonSoldier;
	ButtonUnit buttonNinja;
	Texture tbuttonNinja;

    private OrthographicCamera camera;
	@Override
	public void create () {
		batch = new SpriteBatch();
		batchButton = new SpriteBatch();
		batchBackground = new SpriteBatch();
		img = new Texture("castle.png");
		castle = new Castle();
		castle.setTexture(img);
		background = new Texture("background.png");
		background2 = new Texture("background2.png");
		//tap = new String();

		tbuttonSoldier = new Texture("buttonSoldier.png");
		buttonSoldier = new ButtonUnit(tbuttonSoldier);
		buttonSoldier.setPosition(50,360);

		tbuttonNinja = new Texture("buttonNinja.png");
		buttonNinja = new ButtonUnit(tbuttonNinja);
		buttonNinja.setPosition(150,360);


        Gdx.input.setInputProcessor(this);
        camera = new OrthographicCamera(800, 480);
        camera.translate(200,240);
	}

	@Override
	public void render () {
	    update();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batchBackground.begin();
		batchBackground.draw(background2,-(camera.position.x-200)/28f,0);
		batchBackground.draw(background, -(camera.position.x-200)/2.35f,0);
		batchBackground.end();

		batch.begin();
		batch.draw(castle.getTexture(), castle.x, castle.y);

		for (Unit unit : castle.getArrayUnit()) {
			unit.render(batch);
		}

		batch.end();

		batchButton.begin();
		batchButton.draw(buttonSoldier.getTexture(), buttonSoldier.x, buttonSoldier.y);
		batchButton.draw(buttonNinja.getTexture(),buttonNinja.x,buttonNinja.y);
		batchButton.end();
	}

	public void update() {
        camera.update();

        batch.setProjectionMatrix(camera.combined);
    }
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		batchButton.dispose();
		tbuttonSoldier.dispose();
		for (Unit unit : castle.getArrayUnit()) {
		    unit.dispose();
        }
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	    dragX = screenX;
	    isAllowDrag = true;

	    if (buttonSoldier.contains(screenX,  Gdx.graphics.getHeight()-screenY)) {
	    	buttonSoldier.clicked(castle, "soldier");
	    	//tap = "buttonSoldier";
	    	isAllowDrag = false;
		}

		if (buttonNinja.contains(screenX,  Gdx.graphics.getHeight()-screenY)) {
			buttonNinja.clicked(castle, "ninja");
			isAllowDrag = false;
		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {

//	    if (buttonSoldier.contains(screenX,  Gdx.graphics.getHeight()-screenY) /*&& tap == "buttonSoldier"*/) {
//	        System.out.println("a");
//        }


	    //tap = "";

		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {

	    if (isAllowDrag) {
	    	if (camera.position.x >= 200 && dragX-screenX < 0 || camera.position.x <= 3000 && dragX-screenX > 0) {
				camera.translate(dragX-screenX, 0);
			}

            dragX = screenX;
        }

	    return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
