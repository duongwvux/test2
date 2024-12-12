package objects;

import main.Game;

public class Trap2 extends GameObjects {

	private int tileY;

	public Trap2(int x, int y, int objType) {
		super(x, y, objType);
		tileY = y / Game.TILES_SIZE;
		initHitbox(35, 24);
		hitbox.x -= (int) (4 * Game.SCALE);
		hitbox.y += (int) (14 * Game.SCALE);
	}

	public void update() {
		 if (doAnimation)
			updateAnimationTick();
	}

	public int getTileY() {
		return tileY;
	}

}