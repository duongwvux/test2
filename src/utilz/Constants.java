package utilz;

import java.awt.event.KeyEvent;

import main.Game;

public class Constants {

    public static final float GRAVITY = 0.04f*Game.SCALE;
    public static final int ANI_SPEED=25;

    public static class Dialogue {
        public static final int QUESTION = 0;
        public static final int EXCLAMATION = 1;

        public static final int DIALOGUE_WIDTH = (int) (14 * Game.SCALE);
        public static final int DIALOGUE_HEIGHT = (int) (12 * Game.SCALE);

        public static int GetSpriteAmount(int type) {
            switch (type) {
                case QUESTION, EXCLAMATION:
                    return 5;
            }

            return 0;
        }
    }
    
    public static class Curve{
        public static final int STICK_WIDTH_DEFAULT = 80;
        public static final int STICK_HEIGHT_DEFAULT = 50;

        public static final int STICK_WIDTH = (int)(Game.SCALE*STICK_WIDTH_DEFAULT);
        public static final int STICK_HEIGHT = (int)(Game.SCALE*STICK_HEIGHT_DEFAULT);
        public static final float SPEED = 1.5f*Game.SCALE;



    }
    
    public static class Projectiles{
		public static final int CANNON_BALL_DEFAULT_WIDTH = 15;
		public static final int CANNON_BALL_DEFAULT_HEIGHT = 15;
		
		public static final int CANNON_BALL_WIDTH = (int)(Game.SCALE * CANNON_BALL_DEFAULT_WIDTH);
		public static final int CANNON_BALL_HEIGHT = (int)(Game.SCALE * CANNON_BALL_DEFAULT_HEIGHT);
		public static final float SPEED = 0.75f * Game.SCALE;
	}

    public static class Arrows{
        public static final int ARROW_DEFAULT_WIDTH = 30;
        public static final int ARROW_DEFAULT_HEIGHT = 10;

        public static final int ARROW_WIDTH = (int)(Game.SCALE*ARROW_DEFAULT_WIDTH);
        public static final int ARROW_HEIGHT = (int)(Game.SCALE*ARROW_DEFAULT_HEIGHT);
        public static final float SPEED = 0.4f*Game.SCALE;



    }

    public static class ObjectsConstants {
        public static final int RED_POTION = 0;
        public static final int BLUE_POTION = 1;
        public static final int BARREL = 2;
        public static final int BOX = 3;
        public static final int TRAP1 = 4;
        public static final int CHEST = 5;
        public static final int SCROLL = 6;
        public static final int SWORD = 7;
        public static final int CANNON_LEFT = 8;
        public static final int CANNON_RIGHT = 9;
        public static final int ARROW_TRAP = 10;
        public static final int TRAP2_LEFT = 11;
        public static final int TRAP2_RIGHT = 12;
        public static final int PEACH = 13;
        public static final int FLAG = 14;

        public static final int RED_POTION_VALUE = 15;
        public static final int BLUE_POTION_VALUE = 100;
        public static final int TRAP1_VALUE = 20;
        public static final int SWORD_VALUE = 20;
        
        public static final int PEACH_WIDTH_DEFAULT = 15;
        public static final int PEACH_HEIGHT_DEFAULT = 15;
        public static final int PEACH_WIDTH = (int) (PEACH_WIDTH_DEFAULT * Game.SCALE);
        public static final int PEACH_HEIGHT = (int) (PEACH_HEIGHT_DEFAULT * Game.SCALE);
        
        public static final int FLAG_WIDTH_DEFAULT = 35;
        public static final int FLAG_HEIGHT_DEFAULT = 35;
        public static final int FLAG_WIDTH = (int) (FLAG_WIDTH_DEFAULT * Game.SCALE);
        public static final int FLAG_HEIGHT = (int) (FLAG_HEIGHT_DEFAULT * Game.SCALE);
        
        public static final int TRAP2_WIDTH_DEFAULT = 90;
        public static final int TRAP2_HEIGHT_DEFAULT = 30;
        public static final int TRAP2_WIDTH = (int) (TRAP2_WIDTH_DEFAULT * Game.SCALE);
        public static final int TRAP2_HEIGHT = (int) (TRAP2_HEIGHT_DEFAULT * Game.SCALE);
        
        public static final int ARROW_TRAP_WIDTH_DEFAULT = 90;
		public static final int ARROW_TRAP_HEIGHT_DEFAULT = 30;
		public static final int ARROW_TRAP_WIDTH = (int) (ARROW_TRAP_WIDTH_DEFAULT * Game.SCALE);
		public static final int ARROW_TRAP_HEIGHT = (int) (ARROW_TRAP_HEIGHT_DEFAULT * Game.SCALE);
        
        public static final int CANNON_WIDTH_DEFAULT = 40;
		public static final int CANNON_HEIGHT_DEFAULT = 26;
		public static final int CANNON_WIDTH = (int) (CANNON_WIDTH_DEFAULT * Game.SCALE);
		public static final int CANNON_HEIGHT = (int) (CANNON_HEIGHT_DEFAULT * Game.SCALE);

        public static final int CONTAINER_WIDTH_DEFAULT = 40;
        public static final int CONTAINER_HEIGHT_DEFAULT = 30;
        public static final int CONTAINER_WIDTH = (int) (CONTAINER_WIDTH_DEFAULT * Game.SCALE);
        public static final int CONTAINER_HEIGHT = (int) (CONTAINER_HEIGHT_DEFAULT * Game.SCALE);
        
        public static final int CHEST_WIDTH_DEFAULT = 48;
        public static final int CHEST_HEIGHT_DEFAULT = 48;
        public static final int CHEST_WIDTH = (int) (CHEST_WIDTH_DEFAULT * Game.SCALE);
        public static final int CHEST_HEIGHT = (int) (CHEST_HEIGHT_DEFAULT * Game.SCALE);
        
        public static final int SWORD_WIDTH_DEFAULT = 15;
        public static final int SWORD_HEIGHT_DEFAULT = 15;
        public static final int SWORD_WIDTH = (int) (SWORD_WIDTH_DEFAULT * Game.SCALE);
        public static final int SWORD_HEIGHT = (int) (SWORD_HEIGHT_DEFAULT * Game.SCALE);
        
        public static final int SCROLL_WIDTH_DEFAULT = 13;
        public static final int SCROLL_HEIGHT_DEFAULT = 13;
        public static final int SCROLL_WIDTH = (int) (SCROLL_WIDTH_DEFAULT * Game.SCALE);
        public static final int SCROLL_HEIGHT = (int) (SCROLL_HEIGHT_DEFAULT * Game.SCALE);
        
        public static final int TRAP1_WIDTH_DEFAULT = 32;
        public static final int TRAP1_HEIGHT_DEFAULT = 32;
        public static final int TRAP1_WIDTH = (int) (TRAP1_WIDTH_DEFAULT * Game.SCALE);
        public static final int TRAP1_HEIGHT = (int) (TRAP1_HEIGHT_DEFAULT * Game.SCALE);

        public static final int POTION_WIDTH_DEFAULT = 12;
        public static final int POTION_HEIGHT_DEFAULT = 16;
        public static final int POTION_WIDTH = (int) (POTION_WIDTH_DEFAULT * Game.SCALE);
        public static final int POTION_HEIGHT = (int) (POTION_HEIGHT_DEFAULT * Game.SCALE);

        public static int getSpriteAmount(int objType) {
            switch (objType) {
            	case TRAP2_LEFT, TRAP2_RIGHT:
            		return 10;
            	case ARROW_TRAP:
            		return 15;
                case RED_POTION, BLUE_POTION, CANNON_LEFT, CANNON_RIGHT:
                    return 7;
                case BARREL, BOX:
                    return 8;
                case CHEST:
                	return 3;
            }

            return 1;
        }
    }
    public static class EnemyConstants {
    	
        public static final int CRABBY = 0;
        public static final int MINOTAUR = 1;
        public static final int SHARK = 2;        
        public static final int MONSTER_EYE1 = 3;
        public static final int MONSTER2 = 4;
        public static final int SPIDER = 5;
        
        public static final int TORO = 6;
        public static final int BOSS1 = 7;
        public static final int BOSS2 = 8;
        public static final int BOSS3 = 9;
        public static final int BOSS4 = 10;
        public static final int BOSS5 = 11;
        
        
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int ATTACK = 2;
        public static final int HIT = 3;
        public static final int DEAD = 4;
        
        
        public static final int	BOSS5_WIDTH_DEFAULT = 96;
        public static final int BOSS5_HEIGHT_DEFAULT = 64;
        public static final int BOSS5_WIDTH = (int) (BOSS5_WIDTH_DEFAULT * Game.SCALE);
        public static final int BOSS5_HEIGHT = (int) (BOSS5_HEIGHT_DEFAULT * Game.SCALE);
        public static final int BOSS5_DRAWOFFSET_X = (int) (8 * Game.SCALE);
        public static final int BOSS5_DRAWOFFSET_Y = (int) (30 * Game.SCALE);
        
        public static final int	BOSS4_WIDTH_DEFAULT = 288;
        public static final int BOSS4_HEIGHT_DEFAULT = 160;
        public static final int BOSS4_WIDTH = (int) (BOSS4_WIDTH_DEFAULT * Game.SCALE);
        public static final int BOSS4_HEIGHT = (int) (BOSS4_HEIGHT_DEFAULT * Game.SCALE);
        public static final int BOSS4_DRAWOFFSET_X = (int) (108 * Game.SCALE);
        public static final int BOSS4_DRAWOFFSET_Y = (int) (54 * Game.SCALE);
        
        public static final int	BOSS3_WIDTH_DEFAULT = 128;
        public static final int BOSS3_HEIGHT_DEFAULT = 96;
        public static final int BOSS3_WIDTH = (int) (BOSS3_WIDTH_DEFAULT * Game.SCALE);
        public static final int BOSS3_HEIGHT = (int) (BOSS3_HEIGHT_DEFAULT * Game.SCALE);
        public static final int BOSS3_DRAWOFFSET_X = (int) (38 * Game.SCALE);
        public static final int BOSS3_DRAWOFFSET_Y = (int) (44 * Game.SCALE);
        
        public static final int	BOSS2_WIDTH_DEFAULT = 128;
        public static final int BOSS2_HEIGHT_DEFAULT = 96;
        public static final int BOSS2_WIDTH = (int) (BOSS2_WIDTH_DEFAULT * Game.SCALE);
        public static final int BOSS2_HEIGHT = (int) (BOSS2_HEIGHT_DEFAULT * Game.SCALE);
        public static final int BOSS2_DRAWOFFSET_X = (int) (41 * Game.SCALE);
        public static final int BOSS2_DRAWOFFSET_Y = (int) (24 * Game.SCALE);
        
        public static final int	SPIDER_WIDTH_DEFAULT = 32;
        public static final int SPIDER_HEIGHT_DEFAULT = 32;
        public static final int SPIDER_WIDTH = (int) (SPIDER_WIDTH_DEFAULT * Game.SCALE);
        public static final int SPIDER_HEIGHT = (int) (SPIDER_HEIGHT_DEFAULT * Game.SCALE);
        public static final int SPIDER_DRAWOFFSET_X = (int) (23 * Game.SCALE);
        public static final int SPIDER_DRAWOFFSET_Y = (int) (9 * Game.SCALE);
        
        public static final int	MON2_WIDTH_DEFAULT = 32;
        public static final int MON2_HEIGHT_DEFAULT = 32;
        public static final int MON2_WIDTH = (int) (MON2_WIDTH_DEFAULT * Game.SCALE);
        public static final int MON2_HEIGHT = (int) (MON2_HEIGHT_DEFAULT * Game.SCALE);
        public static final int MON2_DRAWOFFSET_X = (int) (2 * Game.SCALE);
        public static final int MON2_DRAWOFFSET_Y = (int) (9 * Game.SCALE);
        
        public static final int	MONEYE1_WIDTH_DEFAULT = 64;
        public static final int MONEYE1_HEIGHT_DEFAULT = 64;
        public static final int MONEYE1_WIDTH = (int) (MONEYE1_WIDTH_DEFAULT * Game.SCALE);
        public static final int MONEYE1_HEIGHT = (int) (MONEYE1_HEIGHT_DEFAULT * Game.SCALE);
        public static final int MONEYE1_DRAWOFFSET_X = (int) (23 * Game.SCALE);
        public static final int MONEYE1_DRAWOFFSET_Y = (int) (30 * Game.SCALE);
        
        public static final int	BOSS1_WIDTH_DEFAULT = 96;
        public static final int BOSS1_HEIGHT_DEFAULT = 64;
        public static final int BOSS1_WIDTH = (int) (BOSS1_WIDTH_DEFAULT * Game.SCALE);
        public static final int BOSS1_HEIGHT = (int) (BOSS1_HEIGHT_DEFAULT * Game.SCALE);
        public static final int BOSS1_DRAWOFFSET_X = (int) (34 * Game.SCALE);
        public static final int BOSS1_DRAWOFFSET_Y = (int) (16 * Game.SCALE);

        public static final int CRABBY_WIDTH_DEFAULT = 72;
        public static final int CRABBY_HEIGHT_DEFAULT = 32;
        public static final int CRABBY_WIDTH = (int) (CRABBY_WIDTH_DEFAULT * Game.SCALE);
        public static final int CRABBY_HEIGHT = (int) (CRABBY_HEIGHT_DEFAULT * Game.SCALE);
        public static final int CRABBY_DRAWOFFSET_X = (int) (26 * Game.SCALE);
        public static final int CRABBY_DRAWOFFSET_Y = (int) (1 * Game.SCALE);

        public static final int MINOTAUR_WIDTH_DEFAULT = 80;
        public static final int MINOTAUR_HEIGHT_DEFAULT = 80;
        public static final int MINOTAUR_WIDTH = (int) (MINOTAUR_WIDTH_DEFAULT * Game.SCALE);
        public static final int MINOTAUR_HEIGHT = (int) (MINOTAUR_HEIGHT_DEFAULT * Game.SCALE);
        public static final int MINOTAUR_DRAWOFFSET_X = (int) (-50 * Game.SCALE);
        public static final int MINOTAUR_DRAWOFFSET_Y = (int) (35* Game.SCALE);
        
        public static final int TORO_WIDTH_DEFAULT = 96;
        public static final int TORO_HEIGHT_DEFAULT = 96;
        public static final int TORO_WIDTH = (int) (TORO_WIDTH_DEFAULT * Game.SCALE);
        public static final int TORO_HEIGHT = (int) (TORO_HEIGHT_DEFAULT * Game.SCALE);
        public static final int TORO_DRAWOFFSET_X = (int) (32 * Game.SCALE);
        public static final int TORO_DRAWOFFSET_Y = (int) (32* Game.SCALE);

        public static final int SHARK_WIDTH_DEFAULT = 34;
        public static final int SHARK_HEIGHT_DEFAULT = 30;
        public static final int SHARK_WIDTH = (int) (SHARK_WIDTH_DEFAULT * Game.SCALE);
        public static final int SHARK_HEIGHT = (int) (SHARK_HEIGHT_DEFAULT * Game.SCALE);
        public static final int SHARK_DRAWOFFSET_X = (int) (8 * Game.SCALE);
        public static final int SHARK_DRAWOFFSET_Y = (int) (0 * Game.SCALE);

        public static int GetSpriteAmount(int enemy_type, int enemy_state) {
            switch (enemy_state) {

                case IDLE:
                    if (enemy_type == CRABBY)
                        return 9;
                    else if ( enemy_type == SHARK || enemy_type == BOSS5)
                        return 8;
                    else if(enemy_type == MINOTAUR)
                        return 9;
                    else if( enemy_type == TORO || enemy_type == SPIDER)
                    	return 5;
                    else if( enemy_type == BOSS1 || enemy_type == BOSS4 )
                    	return 6;
                    else if(enemy_type == MONSTER_EYE1)
                    	return 15;
                    else if(enemy_type == MONSTER2 || enemy_type == BOSS3)
                    	return 4;
                    else if(enemy_type == BOSS2)
                    	return 7;
                    

                case RUNNING:
                	if(enemy_state == TORO || enemy_state == MONSTER2 || enemy_type == BOSS5)
                		return 8;
                	else if(enemy_type == MONSTER_EYE1 || enemy_type == BOSS4)
                    	return 12;
                	else if(enemy_type == SPIDER)
                    	return 5;
                	else if(enemy_type == BOSS2 || enemy_type == BOSS3)
                    	return 7;
                    return 6;
                case ATTACK:
                    if (enemy_type == SHARK || enemy_type == BOSS5)
                        return 8;
                    else if(enemy_type==MINOTAUR)
                        return 12;
                    else if (enemy_type == TORO)
                    	return 9;
                    else if( enemy_type == BOSS1 || enemy_type == BOSS2)
                    	return 6;
                    else if(enemy_type == MONSTER_EYE1)
                    	return 9;
                    else if(enemy_type == SPIDER || enemy_type == BOSS3)
                    	return 4;
                    else if(enemy_type == BOSS4)
                    	return 15;
                    return 7;
                case HIT:
                    if(enemy_type==MINOTAUR || enemy_type == BOSS4)
                        return 5;
                    else if (enemy_type == TORO || enemy_type == BOSS1 || enemy_type == SPIDER || enemy_type == BOSS3)
                    	return 3;
                    else if(enemy_type == MONSTER_EYE1)
                    	return 6;
                    return 4;
                    
                case DEAD:
                    if(enemy_type==MINOTAUR)
                        return 23;
                    else if (enemy_type == TORO || enemy_type == MONSTER2 || enemy_type == BOSS2)
                    	return 6;
                    else if (enemy_type == BOSS1)
                    	return 4;
                    else if(enemy_type == MONSTER_EYE1 || enemy_type == SPIDER)
                    	return 9;
                    else if(enemy_type == BOSS3)
                    	return 7;
                    else if(enemy_type == BOSS4)
                    	return 19;
                    return 5;
            }

            return 0;

        }

        public static int GetExperience(int enemy_type){
            switch (enemy_type) {
                case CRABBY:
                      return 10;
                  case MINOTAUR:
                      return 50;
                  case SHARK:
                      return 15;
                  case TORO:
                      return 35;
                  default:
                      return 20;
              }
        }

        public static int GetMaxHealth(int enemy_type) {
            switch (enemy_type) {
              case CRABBY:
                    return 50;
                case MINOTAUR:
                    return 50;
                case SHARK:
                    return 50;
                case TORO: 
                	return 50;
                case BOSS1:
                	return 50;
                case BOSS2:
                	return 50;
                case BOSS3:
                	return 50;
                case BOSS4:
                	return 50;
                case BOSS5:
                	return 50;
                case MONSTER_EYE1:
                	return 50;
                case MONSTER2:
                	return 50;
                case SPIDER:
                	return 50;
                default:
                    return 50;
            }
        }

        public static int GetEnemyDmg(int enemy_type) {
            switch (enemy_type) {
               case CRABBY:
                   return 2;
                case MINOTAUR:
                   return 20;
               case SHARK:
              	return 2;
                case TORO:
               	return 2;
                case BOSS1:
               	return 2;
               case BOSS2:
               	return 2;
                case BOSS3:
                	return 2;
                case BOSS4:
                	return 2;
                case BOSS5:
               	return 2;
                case MONSTER_EYE1:
                	return 2;
                case SPIDER :
                	return 2;
                default:
                	return 10;
            }
        }
        
        
        public static int GetNumberMessageBoss(int enemy_type) {
        	switch(enemy_type) {
//        	case TORO:
//        	case BOSS2:
//        	case BOSS3:
//        	case BOSS4:
//        	case BOSS5:
        	default:
        		return 3;
        	}
        }
    }



    public static class Environment {
        public static final int BIG_CLOUD_WIDTH_DEFAULT = 448;
        public static final int BIG_CLOUD_HEIGHT_DEFAULT = 101;
        public static final int SMALL_CLOUD_WIDTH_DEFAULT = 74;
        public static final int SMALL_CLOUD_HEIGHT_DEFAULT = 24;

        public static final int BIG_CLOUD_WIDTH = (int) (BIG_CLOUD_WIDTH_DEFAULT * Game.SCALE);
        public static final int BIG_CLOUD_HEIGHT = (int) (BIG_CLOUD_HEIGHT_DEFAULT * Game.SCALE);
        public static final int SMALL_CLOUD_WIDTH = (int) (SMALL_CLOUD_WIDTH_DEFAULT * Game.SCALE);
        public static final int SMALL_CLOUD_HEIGHT = (int) (SMALL_CLOUD_HEIGHT_DEFAULT * Game.SCALE);
    }

    public static class UI {
        public static class Buttons {
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
            public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
        }

        public static class PauseButtons {
            public static final int SOUND_SIZE_DEFAULT = 42;
            public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);
        }

        public static class URMButtons {
            public static final int URM_DEFAULT_SIZE = 56;
            public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);

        }

        public static class VolumeButtons {
            public static final int VOLUME_DEFAULT_WIDTH = 28;
            public static final int VOLUME_DEFAULT_HEIGHT = 44;
            public static final int SLIDER_DEFAULT_WIDTH = 215;

            public static final int VOLUME_WIDTH = (int) (VOLUME_DEFAULT_WIDTH * Game.SCALE);
            public static final int VOLUME_HEIGHT = (int) (VOLUME_DEFAULT_HEIGHT * Game.SCALE);
            public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * Game.SCALE);
        }
    }

    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int ATTACK = 4;
        
        public static final int HIT = 5;
        public static final int DEAD = 6;

        public static int GetSpriteAmount(int player_action) {
            switch (player_action) {
                case DEAD:
                    return 8;
                case RUNNING:
                    return 6;
                case IDLE:
                    return 5;
                case HIT:
                    return 4;
                case JUMP:
                case ATTACK:
                    return 3;
                case FALLING:
                default:
                    return 1;
            }
        }

        //Mana hao tốn
        public static int GetStamina(int player_action){
            switch(player_action){
                case JUMP:
                    return 5;
                case ATTACK:
                    return 3;
                default: 
                    return 0;
            }
        }

        public static int GetAniFromKey(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    return JUMP;
                
                case KeyEvent.VK_F:
                    return ATTACK;
                default: 
                    return IDLE;
            }
        }

        public static boolean NeedToCheckStamina(KeyEvent e){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                case KeyEvent.VK_F:
                    return true;
                default: 
                    return false;
            }
        }
    }

}
