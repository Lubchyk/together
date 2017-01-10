package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
	class Star {
		private Vector2 position; // ������ 2 �� ��������  x i y � ����� position
		private float speed;		
		public Star() {
			//Gdx.graphics.getWidth();// 1100 � 670 ����� ������� ������ ��������
			//Gdx.graphics.getHeight();
			position = new Vector2((float)Math.random() * 1100, (float)Math.random() * 670);
			speed = 1.0f + (float)Math.random() * 7.0f; // ������ ����� ���� ���� ��������
		}
		public void update() {
			position.x -= speed; // �������� �������� �����
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
	private Texture background; // ��������� ����� ��������
	private final int STARS_COUNT = 100; //����� ������� ������ ������ ��� ������� ������ final ������ �� �� ���������
	private Star[] stars;
	public Background() {
		background = new Texture("background_2.png");
		star = new Texture("star.png");
		stars = new Star[STARS_COUNT];// ��������� ������� ����� � ������� ���������
		for (int i = 0; i < STARS_COUNT; i++) { //���������� �� ������ ������ �������
			stars[i] = new Star();			
		}
	}
	public void render(SpriteBatch batch) { // ����� ���� ����� ����� ��� � ����� �������� ���������
		batch.draw(background, 0, 0);
		for (int i = 0; i < STARS_COUNT; i++){
			batch.draw(star, stars[i].position.x, stars[i].position.y);// ����������� �� ����� ������ ������ ���� �� ���������� � ����� ��� ����
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
