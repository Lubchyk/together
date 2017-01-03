package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture spaceShip;
	Texture star;
	Texture bullet;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		star = new Texture("star.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1); //задає колір фону
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);// очищає екран кольором вище
		batch.begin(); // починає маювати
		batch.draw(star, 0, 0); // дану картинку в точці
		batch.end(); // закінчує малювання
	}
	
	@Override // клас який звільняє пам'ять
	public void dispose () {
		batch.dispose();
		star.dispose();
	}
	public void upDate () { // клас для розрахунків
		
	}
}

