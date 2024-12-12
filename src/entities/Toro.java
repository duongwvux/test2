package entities;

import static utilz.Constants.Directions.*;


import static utilz.Constants.EnemyConstants.*;
import static utilz.Constants.EnemyConstants.HIT;
import static utilz.Constants.EnemyConstants.IDLE;
import static utilz.Constants.EnemyConstants.RUNNING;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import main.Game;

public class Toro extends Enemy {
	
	private int attackBoxOffsetX;

	public Toro(float x, float y) {
		super(x , y, TORO_WIDTH, TORO_HEIGHT, TORO);
		initHitbox(40, 30);
		this.enemyHealthBarWidth = (int)(35* Game.SCALE);
        this.enemyHealthBarHeight = (int)(3* Game.SCALE);
        this.enemyHealthWidth = enemyHealthBarWidth;
        this.walkSpeed = 0.38f * Game.SCALE;
        this.setDialogue();
		initAttackBox();
	}
	
	//khai bao attackbox
	private void initAttackBox() {
		attackBox = new Rectangle2D.Float(x , y, (int)(Game.SCALE * 40),(int)(Game.SCALE * 30));
		attackBoxOffsetX = (int)(Game.SCALE *40);
		
	}

	public void update(int[][] lvlData, Player player) {
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

        attackBox.y = hitbox.y ;
    }
	private void updateBehaviour(int[][] lvlData, Player player) {
		if(firstUpdate) 
			firstUpdateCheck(lvlData);
		
		if(inAir) {
			updateInAir(lvlData);
		}else {
			switch(state) {
			case IDLE:
				newState(RUNNING);
				break;
			case RUNNING:
				if(canSeePlayer(lvlData, player)) {
					count ++;
					turnTowardsPlayer(player);
				if(isPlayerCloseAttack(player))
					newState(ATTACK);
				}
				move(lvlData);
				break;
			case ATTACK:
				if(aniIndex ==0)
					attackChecked = false;
				
				if(aniIndex == 3  && !attackChecked)
					checkEnmyHit(attackBox, player);
				break;
			case HIT:
				break;
			}
		}
	}
	
	public void drawHealthBar(Graphics g, int xLvlOffset) {

        g.setColor(Color.red);
        g.fillRect((int) (hitbox.x + hitbox.width / 2 - enemyHealthBarWidth / 2 - xLvlOffset + this.flipHealth()),
                (int) (hitbox.y + hitbox.height - attackBox.height - 12 * Game.SCALE), enemyHealthWidth,
                enemyHealthBarHeight);
        g.setColor(Color.WHITE);
        g.fillRect((int) (hitbox.x + hitbox.width / 2 - enemyHealthBarWidth / 2 + enemyHealthWidth - xLvlOffset + this.flipHealth()),
                (int) (hitbox.y + hitbox.height - attackBox.height - 12 * Game.SCALE),
                enemyHealthBarWidth - enemyHealthWidth, enemyHealthBarHeight);
	
}
	private int flipHealth() {
    	if(walkDir == RIGHT)
    		return 5;
    	else
    		return -5;
    }
	
	public int flipX() {
		if(walkDir == RIGHT)
			return 0;
		else
			return width + 15;
	}
	
	public int flipY() {
		if(walkDir == RIGHT)
			return 1;
		else
			return -1;
		
	}
}
