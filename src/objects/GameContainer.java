package objects;

import main.Game;

import static utilz.Constants.ObjectsConstants.*;

public class GameContainer extends GameObjects {
    public GameContainer(int x, int y, int objType) {
        super(x, y, objType);
        createHitBox();
    }

    public void createHitBox() {

        if (objType == BOX){
            initHitbox(22, 19);
            xDrawOffset = (int) (7 * Game.SCALE);
            yDrawOffset = (int) (12 * Game.SCALE);
        }
        else {
            initHitbox(22, 19);
            xDrawOffset = (int) (8 * Game.SCALE);
            yDrawOffset = (int) (5 * Game.SCALE);
        }

        // hitbox.y += yDrawOffset + (int) (Game.SCALE * 2);
       // hitbox.x += (int) (xDrawOffset / 2);
    }

    public void update() {
        if (doAnimation)
            updateAnimationTick();
    }
}
