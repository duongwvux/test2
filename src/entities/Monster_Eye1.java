package entities;

import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.EnemyConstants.ATTACK;
import static utilz.Constants.EnemyConstants.MONSTER_EYE1;
import static utilz.Constants.EnemyConstants.MONEYE1_HEIGHT;
import static utilz.Constants.EnemyConstants.MONEYE1_WIDTH;
import static utilz.Constants.EnemyConstants.HIT;
import static utilz.Constants.EnemyConstants.IDLE;
import static utilz.Constants.EnemyConstants.RUNNING;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import main.Game;

public class Monster_Eye1 extends Enemy {

	private int attackBoxOffsetX;
	
	    public Monster_Eye1(float x, float y) {
	        super(x, y, MONEYE1_WIDTH, MONEYE1_HEIGHT, MONSTER_EYE1);
	        initHitbox(30,30);
	        initAttackBox();
	        this.enemyHealthBarWidth = (int)(30* Game.SCALE);
	        this.enemyHealthBarHeight = (int)(2* Game.SCALE);
	        this.enemyHealthWidth = enemyHealthBarWidth;
	        this.walkSpeed = 0.3f * Game.SCALE;
	    }
	    
	    private void initAttackBox(){
	        attackBox=new Rectangle2D.Float(x,y,(int)(35*Game.SCALE),(int)(30*Game.SCALE));
	        attackBoxOffsetX = (int)(Game.SCALE*35);
	    }

	    public void update(int[][] lvlData,Player player){
	        updateBehaviour(lvlData,player);
	        updateAnimationTick();
	        updateAttackBoxFlip();
	        updateHealthBar();
	    }
	    
	    protected void updateAttackBoxFlip() {
	        if (walkDir == RIGHT)
	            attackBox.x = hitbox.x + hitbox.width;
	        else
	            attackBox.x = hitbox.x - attackBoxOffsetX;

	        attackBox.y = hitbox.y;
	    }

	protected void updateAttackBox() {
		attackBox.x= hitbox.x-attackBoxOffsetX;
		attackBox.y=hitbox.y;
	}

	private void updateBehaviour(int[][] lvlData,Player player) {
		if (firstUpdate){
			firstUpdateCheck(lvlData);

		}
		if(inAir) {
			updateInAir(lvlData);
		}else{
			switch (state){
				case IDLE :
					newState(RUNNING);
					break;
				case RUNNING:
					if(canSeePlayer(lvlData,player)) {
						turnTowardsPlayer(player);
						if (isPlayerCloseAttack(player))
							newState(ATTACK);
					}
					move(lvlData);
					break;
				case ATTACK:
					if(aniIndex==0)
						attackChecked = false;
					if(aniIndex== 4 &&!attackChecked)
						checkEnmyHit(attackBox,player);
					break;
				case HIT:
					break;
			}


		}
	}

	    
	    public void drawHealthBar(Graphics g, int xLvlOffset) {

		        g.setColor(Color.red);
		        g.fillRect((int) (hitbox.x + hitbox.width / 2 - enemyHealthBarWidth / 2 - xLvlOffset + this.flipHealth()),
		                (int) (hitbox.y + hitbox.height - attackBox.height - 8 * Game.SCALE), enemyHealthWidth,
		                enemyHealthBarHeight);
		        g.setColor(Color.WHITE);
		        g.fillRect((int) (hitbox.x + hitbox.width / 2 - enemyHealthBarWidth / 2 + enemyHealthWidth - xLvlOffset + this.flipHealth()),
		                (int) (hitbox.y + hitbox.height - attackBox.height - 8 * Game.SCALE),
		                enemyHealthBarWidth - enemyHealthWidth, enemyHealthBarHeight);
	    	
	    }

	public void drawAttackBox(Graphics g,int xLvlOffset){
		g.setColor(Color.red);
		g.drawRect((int)(attackBox.x-xLvlOffset),(int)(attackBox.y),(int)attackBox.width,(int)attackBox.height);
	    }
	    
	    private int flipHealth() {
	    	if(walkDir == RIGHT)
	    		return 5;
	    	else
	    		return -5;
	    }
	    
	    public int flipX(){
	        if(walkDir==RIGHT)
	            return 18;
	        else
	            return  width -3;
	    }
	    public int flipY(){
	          if(walkDir==RIGHT)
	              return 1;
	          else
	              return -1;    
	}


}


/*	public void update(){
		if(doAnimation)
			updateAnimationTick();
	}*/

	/*public int getTileY(){
		return tileY;
	}

	public void setAnimation(boolean doAnimation){
		this.doAnimation=doAnimation;
	}

	public void reset(){
		aniIndex = 0;
		aniTick = 0;
		active = true;


			doAnimation = true;

	}*/
