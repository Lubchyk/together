package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
	class Star {
		private Vector2 position; // вектор 2 це поєднання  x i y в змінній position
		private float speed;		
		public Star() {
			//Gdx.graphics.getWidth();// 1100 і 670 можна замінити даними методами
			//Gdx.graphics.getHeight();
			position = new Vector2((float)Math.random() * 1100, (float)Math.random() * 670);
			speed = 1.0f + (float)Math.random() * 7.0f; // задаємо кожній зірці різну швидкість
		}
		public void update() {
			position.x -= speed; // дозволяє рухатися зіркам
			if (position.x < -20) {
				position.x = 1100;
				position.y = ((float)Math.random() * 670);
				speed = 1.0f + (float)Math.random() * 7.0f;
			}
		}		
		public void dispose () {
			//batch.dispose();
			star.dispose();
		}
	}
	
	private Texture star;
	private Texture background; // обявляємо змінну текстура
	private final int STARS_COUNT = 100; //перед масивом пишема скільки нам потрібно комірок final означає що це константа
	private Star[] stars;
	public Background() {
		background = new Texture("background_2.png");
		star = new Texture("star.png");
		stars = new Star[STARS_COUNT];// створюємо порожній масив в кількості константи
		for (int i = 0; i < STARS_COUNT; i++) { //заповнюємо всі комірки масива хзірками
			stars[i] = new Star();			
		}
	}
	public void render(SpriteBatch batch) { // метод який малює задній фон в нього передаємо кординати
		batch.draw(background, 0, 0);
		for (int i = 0; i < STARS_COUNT; i++){
			batch.draw(star, stars[i].position.x, stars[i].position.y);// проходиться по кожній комірці масива буру їх координати і малює там зірку
		}
	}
	public void up_date() {
		for (int i = 0; i < STARS_COUNT; i++){
			stars[i].update();
		}
	}
	public void gameOver() {
	background = new Texture("gameOver.png");
	}
}
