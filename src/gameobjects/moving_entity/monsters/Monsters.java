package gameobjects.moving_entity.monsters;

import gameobjects.moving_entity.Living_Creature;
import libraries.StdDraw;
import libraries.Vector2;

public class Monsters extends Living_Creature {
	private Vector2 destination;
	private int freeze; //freezing time and hero invincibility time are different
	
	public Monsters(Vector2 position, Vector2 size, double speed, Vector2 direction,
			int hitPoint, int damage, String imagePath, Vector2 destination) 
	{
		super(position, size, speed, hitPoint, damage,imagePath);
		this.destination = destination;
		this.freeze = 0;
		
	}
	
	public void updateGameObject()
	{
		if (freeze == 0) 
		moveTo(destination);
		else freeze --;
	}
	
	// donne des coordon�e au hasard 
	private Vector2 chooseRandomPoint() {
		double x = (Math.random()+0.1)*0.9;
		double y = (Math.random()+0.1)*0.9;	
		double rpx = (double)Math.round(x*10)/10;
		double rpy = (double) Math.round(y*10)/10;
		while (rpx==0||rpy==0||rpx==1|rpy==1 ||(rpx==0.5&&rpy==0.9)) {
			x = (Math.random()+0.1)*0.9;
			y = (Math.random()+0.1)*0.9;	
			rpx = (double)Math.round(x*10)/10;
			rpy = (double) Math.round(y*10)/10;
		}
		return new Vector2(rpx, rpy);
	}
		
		private void moveTo(Vector2 cible) {
			double posx =(double) Math.round(this.getPosition().getX()*10)/10;
			double posy =(double) Math.round(this.getPosition().getY()*10)/10;
			double cibx =(double) Math.round(cible.getX()*10)/10;
			double ciby =(double) Math.round(cible.getY()*10)/10;
			System.out.println("=>"+ posx + "|" + posy + "|"+ cibx + "|"+ciby + "|");
			if (posx==cibx && posy==ciby) {
				this.destination = chooseRandomPoint();
				return;
			}
			/*else if (posx<cibx && posy<ciby) { //pour bouger en diagonale
				goRightNext();goUpNext();
			}else if (posx<cibx && posy>ciby) {
				goRightNext();goDownNext();
			}else if(posx>cibx && posy<ciby) {
				goLeftNext();goUpNext();
			}else if (posx>cibx && posy>ciby) {
				goLeftNext();goDownNext();
			}*/if (posx<cibx) {
				goRightNext();
			}else if (posx>cibx) {
				goLeftNext();
			}else if (posy<ciby){
				goUpNext();
			}else {
				goDownNext();
			}
			Vector2 normalizedDirection = getNormalizedDirection();
			Vector2 positionAfterMoving = getPosition().addVector(normalizedDirection);
			setPosition(positionAfterMoving);
			this.setDirection(new Vector2());
		}

	
	
	/*// keep the monster in the room
	private boolean isAWall(Vector2 checkposition) {
		if (checkposition.getX()>(0.1) && checkposition.getX()<(0.9) &&
			checkposition.getY()>(0.1) && checkposition.getY()<(0.9)) {
			return true;
		}else {
			return false;
		}
	}*/
	
	
	/*
	 * Moving from key inputs. Direction vector is later normalised.
	 */
	public void goUpNext()
	{
		getDirection().addY(1);
	}

	public void goDownNext()
	{
		getDirection().addY(-1);
	}

	public void goLeftNext()
	{
		getDirection().addX(-1);
	}

	public void goRightNext()
	{
		getDirection().addX(1);
	}

	public Vector2 getNormalizedDirection()
	{
		Vector2 normalizedVector = new Vector2(getDirection());
		normalizedVector.euclidianNormalize(getSpeed());
		return normalizedVector;
	}
	
	public void drawGameObject()
	{
		StdDraw.picture(getPosition().getX(), getPosition().getY(), getImagePath(), getSize().getX(), getSize().getY(),
				0);
	}

	public Vector2 getDestination() {
		return destination;
	}

	public void setDestination(Vector2 destination) {
		this.destination = destination;
	}
	
	public void addFreezeTime(int freezeTime) {
		freeze += freezeTime;
	}
	
	
	
}
