package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;



public class Hero {
	private Texture hero;
	private Vector2 position;
	private float speed;
	private int fireCount;
	private int fireRade; // частота із якою корабель буде стріляти
	
	public Hero(float posX, float posY){
		hero = new Texture("spaceShip.png");
		speed = 12.0f;
		position = new Vector2(posX, posY);
		fireRade = 6;
		
	}
	public void render(SpriteBatch batch) {
		batch.draw(hero, position.x, position.y);
	}
	
	public void update() { // реакція на натискання клавіш
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			position.y += speed;
			if (position.y > 670) {
				position.y = -20;
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			position.y -= speed;
			if (position.y < -20) {
				position.y = 670;
			} 	
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			position.x -= speed;
			if (position.x < 0) position.x = 0;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			position.x += speed;
			if (position.x > 997) position.x = 997;
			}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) { //коли ми викликаємо даний метод нажимаючи на клавішу
			fireCount++; // збільшується лічильник
			if (fireCount > fireRade) { //коли він перевершить час очікування ви вистрілимо і обнулемо лічильник
				fireCount = 0;
				fire(); // робиться для того щоб пулівилітали по черзі
			}
		}
	}
	public void fire() {
		for (int i = 0; i < Game.bullet10.length; i++) {
			if (!Game.bullet10[i].isActive()) {
				Game.bullet10[i].setup(position.x, position.y);
				break;
			}
		}
	}
}
