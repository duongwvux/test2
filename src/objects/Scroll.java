package objects;

import main.Game;

public class Scroll extends GameObjects {
	public Scroll(int x, int y, int objType) {
		super(x, y, objType);
		
		initHitbox(13, 13);
		xDrawOffset = 0;
		yDrawOffset = (int) (5*Game.SCALE);
		hitbox.y += yDrawOffset + (int) (16*Game.SCALE);
	}
	public void update() {
		updateAnimationTick();
	}

}
