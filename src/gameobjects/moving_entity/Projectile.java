package gameobjects.moving_entity;

import libraries.StdDraw;
import libraries.Vector2;

public class Projectile {
	private Vector2 proj_position;
	private Vector2 proj_direction;
	private Vector2 proj_size;
	private double proj_speed;
	private int proj_degat;
	private String proj_imagePath;
	
	public Projectile(Vector2 proj_position ,Vector2 proj_direction ,Vector2 proj_size, double proj_speed, int proj_degat,
			String proj_imagePath) {
		this.proj_position = proj_position;
		this.proj_size = proj_size;
		this.proj_speed = proj_speed;
		this.proj_direction = proj_direction;
		this.proj_degat = proj_degat;
		this.proj_imagePath = proj_imagePath;
	}
	
	
	protected void move()
	{
		System.out.println(proj_direction);
		Vector2 normalizedDirection = getNormalizedDirection();
		Vector2 positionAfterMoving = getProjPosition().addVector(normalizedDirection);
		setProjPosition(positionAfterMoving);
	}
	
	
	public Vector2 getNormalizedDirection()
	{
		Vector2 normalizedVector = new Vector2(proj_direction);
		normalizedVector.euclidianNormalize(proj_speed);
		return normalizedVector;
	}
	
	public void drawGameObject()
	{
		StdDraw.picture(getProjPosition().getX(), getProjPosition().getY(), getProjImagePath(), getProjSize().getX(), getProjSize().getY(),
				0);
	}

	
	

	public Vector2 getProjPosition() {
		return proj_position;
	}
	
	public void setProjPosition(Vector2 proj_position) {
		this.proj_position = proj_position;
	}
	
	public Vector2 getProjDirection() {
		return proj_direction;
	}
	
	public void setProjDirection(Vector2 proj_direction) {
		this.proj_direction = proj_direction;
	}
	
	public Vector2 getProjSize() {
		return proj_size;
	}

	public double getProjSpeed() {
		return proj_speed;
	}

	public int getProjDegat() {
		return proj_degat;
	}
	
	public String getProjImagePath() {
		return proj_imagePath;
	}
		
	
}
