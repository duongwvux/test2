package objects;

import main.Game;

public class Flag extends GameObjects {
	public Flag(int x, int y, int objType) {
		super(x, y, objType);
		initHitbox(15, 35);
		xDrawOffset = 0;
		yDrawOffset = (int) (5*Game.SCALE);
		hitbox.y += yDrawOffset;
	}
	
	public void update() {
		updateAnimationTick();
	}

}
