package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
	private Vector2 position; // ������ 2 �� ��������  x i y � ����� position
	private float speed;
	private boolean active; // ���� ������� �� �������
	
	public Vector2 getPosition() {//�����
		return position;
	}
	public boolean isActive() { // �����
		return active;
	}
	public Bullet() {
		position = new Vector2(0,0);
		speed = 0.0f ;
	}
	public void destroy() {
		active = false;
	}
	public void setup(float posX, float posY) {
		active = true;
		position.x = posX + 70;;
		position.y = posY + 5;
		speed = 15.0f;
	}
	public void update() {
		position.x += speed; // �������� �������� �����
		if (position.x > 1100) {
			destroy();			
		}
	}
}
