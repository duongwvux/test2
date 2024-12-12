package objects;

import main.Game;

public class Sword extends GameObjects {
	public Sword(int x, int y, int objType) {
		super(x, y, objType);
		initHitbox(16, 16);
		xDrawOffset = 0;
		yDrawOffset = (int) (5*Game.SCALE);
		
	}
	
	public void update() {
		updateAnimationTick();
	}

}
