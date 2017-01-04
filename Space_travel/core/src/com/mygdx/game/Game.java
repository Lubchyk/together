package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch batch; // область малювання
	Texture spaceShip;
	Texture bullet;
	Background background;
	Hero hero;
	final int ASTEROID_COUNT = 20;
	Asteroids[] asteroid;
	final int BULLET_COUNT = 10;
	public static Bullet[] bullet10;

	
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero(100, 100);
		asteroid = new Asteroids[ASTEROID_COUNT];
		for (int i = 0; i < ASTEROID_COUNT; i++) {
			asteroid[i] = new Asteroids();
		}
		bullet10 = new Bullet[BULLET_COUNT];
		for (int i = 0; i < BULLET_COUNT; i++) {
			bullet10[i] = new Bullet();
		}
		bullet = new Texture("bullet.png");
		
	}

	@Override
	public void render () {
		upDate(); // викликає метод який буде проводити розрахунки
		Gdx.gl.glClearColor(1, 0, 0, 1); //задає колір фону
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);// очищає екран кольором вище
		batch.begin(); // починає маювати
		background.render(batch); 
		hero.render(batch);
		for (int i = 0; i < ASTEROID_COUNT; i++) {
			asteroid[i].render(batch);
		}
		for (int i = 0; i < BULLET_COUNT; i++)
			if (bullet10[i].isActive()) {
				batch.draw(bullet, bullet10[i].getPosition().x, bullet10[i].getPosition().y);
			}
		
		
		batch.end(); // закінчує малювання
	}
	
	@Override // клас який звільняє пам'ять
	public void dispose () {
		batch.dispose();
		//star.dispose();
	}
	public void upDate () { // клас для розрахунків
		background.up_date();
		hero.update();
		for (int i = 0; i < ASTEROID_COUNT; i++) {
			asteroid[i].update();
		}
		for (int i = 0; i < BULLET_COUNT; i++)
			if (bullet10[i].isActive()) {
				bullet10[i].update();
				for (int j = 0; j < ASTEROID_COUNT; j++) { //так розраховується зіткнення із пулею
					if (asteroid[j].getRect().contains(bullet10[i].getPosition())) {//якщо прямокутник астероїда вміщає координати пулі то... 
						bullet10[i].destroy();
						asteroid[j].reCreate();
						
					}
				}
			}
	}
}

