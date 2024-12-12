package objects;

import main.Game;

public class Chest extends GameObjects {
	public Chest(int x, int y, int objType) {
		super(x, y, objType);
		initHitbox(32, 32);
		xDrawOffset = (int) (2*Game.SCALE);
		yDrawOffset = (int) (4*Game.SCALE);
		hitbox.y += yDrawOffset + (int) (Game.SCALE * 8) ;
        
	}
	
	public void update() {
		if (doAnimation) {
			updateAnimationTick();
			
		}
    }

	

}
