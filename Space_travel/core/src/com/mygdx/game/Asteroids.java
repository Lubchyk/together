package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroids {
	private static Texture asteroid;
	private Vector2 position; // ������ 2 �� ��������  x i y � ����� position
	private float speed;
	private Rectangle rect; // ������� �����������
	
	public Rectangle getRect() { // ����� ��������������� ��� ���� ��� ������ � �� �������� ������ �� �����
		return rect;
	}
	public Asteroids() {
		position = new Vector2(1100 + (float)Math.random() * 1100, (float)Math.random() * 670);
		rect = new Rectangle(position.x, position.y, 95, 95 ); 
		speed = 6.0f + (float)Math.random() * 6.0f; // ������ ����� ���� ���� ��������
		if (asteroid == null) asteroid = new Texture("asteroids.png");
	}	
	public void reCreate(){ // ����������� �������� �� �������
		position.x = 1100 + (float)Math.random() * 1100;
		position.y = (float)Math.random() * 670;
		speed = 6.0f + (float)Math.random() * 6.0f;
	}
	public void render(SpriteBatch batch) { // ����� ��������
		batch.draw(asteroid, position.x, position.y);
	}	
	public void update() {
		position.x -= speed; // �������� ��������
		if (position.x < -60) reCreate();
		rect.x = position.x;
		rect.y = position.y - 12;
	}
}
