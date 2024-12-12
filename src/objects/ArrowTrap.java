package objects;

import main.Game;

public class ArrowTrap extends GameObjects{
	public ArrowTrap(int x, int y, int objType) {
		super(x, y, objType);
		initHitbox(20, 14);
        xDrawOffset = (int) (20* Game.SCALE);
        yDrawOffset = (int) (15* Game.SCALE);
        hitbox.y += yDrawOffset ;
    }
    public void update() {
    		updateAnimationTick();
    }
}
