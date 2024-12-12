package entities;

import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.EnemyConstants.ATTACK;
import static utilz.Constants.EnemyConstants.HIT;
import static utilz.Constants.EnemyConstants.IDLE;
import static utilz.Constants.EnemyConstants.MON2_HEIGHT;
import static utilz.Constants.EnemyConstants.MON2_WIDTH;
import static utilz.Constants.EnemyConstants.MONSTER2;
import static utilz.Constants.EnemyConstants.RUNNING;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import main.Game;

public class Monster2 extends Enemy {
	private int attackBoxOffsetX;

    public Monster2(float x, float y) {
        super(x, y, MON2_WIDTH, MON2_HEIGHT, MONSTER2);
        initHitbox(40,20);
        initAttackBox();
        this.enemyHealthBarWidth = (int)(30* Game.SCALE);
        this.enemyHealthBarHeight = (int)(1.5* Game.SCALE);
        this.enemyHealthWidth = enemyHealthBarWidth;
        this.walkSpeed = 0.3f * Game.SCALE;
    }
    
    private void initAttackBox(){
        attackBox=new Rectangle2D.Float(x,y ,(int)(15 *Game.SCALE),(int)(20*Game.SCALE));
        attackBoxOffsetX = (int)(Game.SCALE*15);
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

        attackBox.y = hitbox.y + 10;
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
                    if(aniIndex==4&&!attackChecked)
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
	                (int) (hitbox.y + hitbox.height - attackBox.height - 12 * Game.SCALE), enemyHealthWidth,
	                enemyHealthBarHeight);
	        g.setColor(Color.WHITE);
	        g.fillRect((int) (hitbox.x + hitbox.width / 2 - enemyHealthBarWidth / 2 + enemyHealthWidth - xLvlOffset + this.flipHealth()),
	                (int) (hitbox.y + hitbox.height - attackBox.height - 12 * Game.SCALE),
	                enemyHealthBarWidth - enemyHealthWidth, enemyHealthBarHeight);
    }

    public void drawAttackBox(Graphics g,int xLvlOffset){
        g.setColor(Color.green);
        g.drawRect((int)(attackBox.x-xLvlOffset),(int)(attackBox.y),(int)attackBox.width,(int)attackBox.height);

    }
    
    
    private int flipHealth() {
    	if(walkDir == RIGHT)
    		return 10;
    	else
    		return -10;
    }
    
    public int flipX(){
        if(walkDir==RIGHT)
            return 12;
        else
            return  60;
    }
    public int flipY(){
          if(walkDir==RIGHT)
              return 1;
          else{
              return -1;
          }
    }

}
