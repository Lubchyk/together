package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Life {
	private Vector2 position; // вектор 2 це поєднання  x i y в змінній position
	private Vector2 position2;
	private Vector2 position3;
	private int lifeCount = 3;
	private Texture life;
	
	public Life() {
		//lifeCount = 3;
		position = new Vector2(20, 630);
		position2 = new Vector2(60, 630);
		position3 = new Vector2(100, 630);
		life = new Texture("life.png");
		//speed = 1.0f + (float)Math.random() * 7.0f; // задаємо кожній зірці різну швидкість
	}	
	public void render(SpriteBatch batch) { // метод який малює задній фон в нього передаємо кординати
		batch.draw(life, position.x, position.y);
		batch.draw(life, position2.x, position.y);
		batch.draw(life, position3.x, position.y);
	}
	
	public void setPosition() {
		if (lifeCount == 3) position3.x = -150;
		if (lifeCount == 2) position2.x = -150;
		if (lifeCount == 1) position.x = -150;
		lifeCount--;
	}	
	public int getLifeCount() {
		return lifeCount;
	}	
	public void contact() {
		life.dispose();
	}
}
