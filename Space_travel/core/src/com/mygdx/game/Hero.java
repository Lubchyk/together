package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;



public class Hero {
	private Texture hero;
	private Vector2 position;
	private float speed;
	private int fireCount;
	private int fireRade; // частота із якою корабель буде стріляти
	public Rectangle rect;
	Game game;
	Life life;
	
	public Hero(float posX, float posY){
		hero = new Texture("spaceShip.png");
		speed = 12.0f;
		position = new Vector2(posX, posY);
		fireRade = 6;
		rect = new Rectangle(position.x, position.y, 100, 50 );
		game = new Game();
		life = new Life();
		
	}
	public void render(SpriteBatch batch) {
		batch.draw(hero, position.x, position.y);
	}
	public Vector2 getPosition() {//гетер
		return position;
	}
	public void setPosition(float posX, float posY) {//сетер
		this.position.x = posX;
		this.position.y = posY;
	}
	public void update() { // реакція на натискання клавіш
			
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			position.y += speed;
			if (position.y > 670) {
				position.y = -20;
				rect.y = position.y;
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			position.y -= speed;
			if (position.y < -20) {
				position.y = 670;
				rect.y = position.y;
			} 	
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			position.x -= speed;
			if (position.x < 0) {
				position.x = 0;
				rect.x = position.x;
				}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			position.x += speed;
			if (position.x > 997) {
				position.x = 997; 
				rect.x = position.x;
			}
			}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) { //коли ми викликаємо даний метод нажимаючи на клавішу
			fireCount++; // збільшується лічильник
			if (fireCount > fireRade) { //коли він перевершить час очікування ви вистрілимо і обнулемо лічильник
				fireCount = 0;
				fire(); // робиться для того щоб пулівилітали по черзі
			}
		}
		
	
		
//		for (int j = 0; j < game.ASTEROID_COUNT; j++) { //так розраховується зіткнення із пулею
//			if (game.asteroid[j].getRect().contains(bullet10[i].getPosition())) {//якщо прямокутник астероїда вміщає координати пулі то... 
//				bullet10[i].destroy();
//				asteroid[j].reCreate();
//				
//			}
//		}
//		
		
		
//		for (int i = 0; i < game.ASTEROID_COUNT; i++) {
//			if (game.asteroid[i].getRect().contains(rect.x, rect.y)){
//				life.contact();
//			}
//				
//		}
		
		
		
	}
	public void fire() {
		for (int i = 0; i < Game.bullet10.length; i++) {
			if (!Game.bullet10[i].isActive()) {
				Game.bullet10[i].setup(position.x, position.y);
				break;
			}
		}
	}
	public void dispose () {
		//batch.dispose();
		hero.dispose();
		
	}
	
}
