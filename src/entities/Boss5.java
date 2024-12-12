package entities;

import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.EnemyConstants.ATTACK;
import static utilz.Constants.EnemyConstants.BOSS5;
import static utilz.Constants.EnemyConstants.BOSS5_HEIGHT;
import static utilz.Constants.EnemyConstants.BOSS5_WIDTH;
import static utilz.Constants.EnemyConstants.HIT;
import static utilz.Constants.EnemyConstants.IDLE;
import static utilz.Constants.EnemyConstants.RUNNING;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import main.Game;

public class Boss5 extends Enemy {
	
	private int count =0;
	private boolean check ;

	public Boss5(float x, float y) {
		 super(x, y, BOSS5_WIDTH, BOSS5_HEIGHT, BOSS5);
	        initHitbox(30,25);
	        this.enemyHealthBarWidth = (int)(35* Game.SCALE);
	        this.enemyHealthBarHeight = (int)(3* Game.SCALE);
	        this.enemyHealthWidth = enemyHealthBarWidth;
	        this.walkSpeed = 0.38f * Game.SCALE;
	        this.setDialogue();
	        
	        initAttackBox();
		
	}
	 private void initAttackBox(){
	        attackBox=new Rectangle2D.Float(x,y,(int)(40*Game.SCALE),(int)(25*Game.SCALE));
	        attackBoxOffsetX = (int)(Game.SCALE*40);
	    }

	    public void update(int[][] lvlData,Player player){
	    	updateBehaviour(lvlData,player);
	        updateAnimationTick();
	        updateAttackBoxFlip();
	        updateHealthBar();
	        
	        

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
	                    	count ++;
	                        turnTowardsPlayer(player);
	                        if (isPlayerCloseAttack(player))
	                            newState(ATTACK);
	                    }
	                    move(lvlData);
	                    break;
	                case ATTACK:
	                    if(aniIndex==0)
	                        attackChecked = false;

	                    if(aniIndex== 2 &&!attackChecked)
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
	                (int) (hitbox.y + hitbox.height - attackBox.height - 25 * Game.SCALE), enemyHealthWidth,
	                enemyHealthBarHeight);
	        g.setColor(Color.WHITE);
	        g.fillRect((int) (hitbox.x + hitbox.width / 2 - enemyHealthBarWidth / 2 + enemyHealthWidth - xLvlOffset + this.flipHealth()),
	                (int) (hitbox.y + hitbox.height - attackBox.height - 25 * Game.SCALE),
	                enemyHealthBarWidth - enemyHealthWidth, enemyHealthBarHeight);
		}
		private int flipHealth() {
	    	if(walkDir == RIGHT)
	    		return 2;
	    	else
	    		return -2;
	    }


	    public void drawAttackBox(Graphics g,int xLvlOffset){
	        g.setColor(Color.red);
	        g.drawRect((int)(attackBox.x-xLvlOffset),(int)(attackBox.y),(int)attackBox.width,(int)attackBox.height);

	    }
	    public int flipX(){
	        if(walkDir==RIGHT)
	            return -40;
	        else
	            return  width - 20;
	    }
	    public int flipY(){
	          if(walkDir==RIGHT)
	              return 1;
	          else{
	              return -1;
	          }
	    }
	    
	  //chỉ cập nhật trò chuyện ở lần đầu xuất hiện
	    public boolean getCheckBoss() {
	    	if(count == 1)
	    		return true;
	    	else
	    		return false;
//	    	return check;
	    }
}
