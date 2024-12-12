package entities;
import main.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static utilz.Constants.Directions.*;
import static utilz.Constants.EnemyConstants.*;


public class Spider extends Enemy{

	
    private int attackBoxOffsetX;

    public Spider(float x, float y) {

        super(x, y, SPIDER_WIDTH, SPIDER_HEIGHT, SPIDER);
        initHitbox(40,12);
        initAttackBox();
        this.enemyHealthBarWidth = (int)(20 * Game.SCALE);
        this.enemyHealthBarHeight = (int)(1.5 * Game.SCALE);
        this.enemyHealthWidth = enemyHealthBarWidth;
        this.walkSpeed = 0.3f * Game.SCALE;
        
    }
    private void initAttackBox(){
        attackBox=new Rectangle2D.Float(x,y,(int)(20*Game.SCALE),(int)(12*Game.SCALE));
        attackBoxOffsetX = (int)(Game.SCALE*20);
    }

    
    public void update(int[][] lvlData,Player player){
        updateBehaviour(lvlData,player);
        updateAnimationTick();
        updateAttackBoxFlip1();
        updateHealthBar();

    }
    
    private void updateAttackBoxFlip1() {
    	if (walkDir == RIGHT)
            attackBox.x = hitbox.x + hitbox.width ;
        else
            attackBox.x = hitbox.x - attackBoxOffsetX;

        attackBox.y = hitbox.y;
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

                    if(aniIndex==3&&!attackChecked) {
                        checkEnmyHit(attackBox,player);
                    }
                    break;
                case HIT:
                    break;
            }

        }

    }


	public void drawAttackBox(Graphics g,int xLvlOffset){
        g.setColor(Color.red);
        g.drawRect((int)(attackBox.x-xLvlOffset),(int)(attackBox.y),(int)attackBox.width,(int)attackBox.height);

    }
    public int flipX(){
        if(walkDir==RIGHT)
            return width  + 90;
        else
            return  -15;
    }
    public int flipY(){
          if(walkDir==RIGHT)
              return -1;
          else{
              return 1;
          }
    }

}
