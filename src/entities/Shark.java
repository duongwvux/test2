package entities;

import java.awt.*;

import main.Game;

import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.EnemyConstants.*;


public class Shark extends Enemy {


    private int attackBoxOffsetX;

    public Shark(float x, float y) {

        super(x, y, SHARK_WIDTH, SHARK_HEIGHT, SHARK);
        initHitbox(25, 22);
        initAttackBox(20,20,20);
        this.enemyHealthBarWidth = (int)(20* Game.SCALE);
        this.enemyHealthBarHeight = (int)(2* Game.SCALE);
        this.enemyHealthWidth = enemyHealthBarWidth;
        this.walkSpeed = 0.3f * Game.SCALE;
    }

    public void update(int[][] lvlData, Player player) {
        updateBehaviour(lvlData, player);
        updateAnimationTick();
        updateAttackBoxFlip();
        updateHealthBar();

    }
    
    protected void updateAttackBoxFlip() {
        if (walkDir == RIGHT)
            attackBox.x = hitbox.x + hitbox.width;
        else
            attackBox.x = hitbox.x - 30;

        attackBox.y = hitbox.y + 5;
    }

    protected void updateAttackBox() {
        attackBox.x = hitbox.x - attackBoxOffsetX;
        attackBox.y = hitbox.y;
    }

    private void updateBehaviour(int[][] lvlData, Player player) {
        if (firstUpdate) {
            firstUpdateCheck(lvlData);

        }
        if (inAir) {
            updateInAir(lvlData);
        } else {
            switch (state) {
                case IDLE:
                    newState(RUNNING);
                    break;

                case RUNNING:
                    if (canSeePlayer(lvlData, player)) {
                        turnTowardsPlayer(player);
                        if (isPlayerCloseAttack(player))
                            newState(ATTACK);
                    }
                    move(lvlData);
                    break;
                case ATTACK:
                    if (aniIndex == 0)
                        attackChecked = false;

                    if (aniIndex == 3 && !attackChecked)
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
                (int) (hitbox.y + hitbox.height - attackBox.height - 4 * Game.SCALE), enemyHealthWidth,
                enemyHealthBarHeight);
        g.setColor(Color.WHITE);
        g.fillRect((int) (hitbox.x + hitbox.width / 2 - enemyHealthBarWidth / 2 + enemyHealthWidth - xLvlOffset+ this.flipHealth()),
                (int) (hitbox.y + hitbox.height - attackBox.height - 4 * Game.SCALE),
                enemyHealthBarWidth - enemyHealthWidth, enemyHealthBarHeight);
	
	
    }
    
    public void drawAttackBox(Graphics g,int xLvlOffset){
        g.setColor(Color.red);
        g.drawRect((int)(attackBox.x-xLvlOffset),(int)(attackBox.y),(int)attackBox.width,(int)attackBox.height);

    }
    
    private int flipHealth() {
    	if(walkDir == RIGHT)
    		return 6;
    	else
    		return -10;
    }
    
    
    public int flipX(){
        if(walkDir==RIGHT)
            return width + 12;
        else
            return  -9;
    }
    public int flipY(){
        if(walkDir==RIGHT)
            return -1;
        else{
            return 1;
        }
    }

}


