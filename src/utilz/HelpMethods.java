package utilz;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.*;
import gameState.Playing;
import main.Game;
import objects.GameContainer;
import objects.Potion;
import objects.Projectile;
import objects.Trap1;
import objects.Trap2;
import objects.Arrow;
import objects.ArrowTrap;
import objects.Cannon;
import objects.Chest;
import objects.Flag;
import objects.Scroll;
import objects.Sword;

import static utilz.Constants.EnemyConstants.*;
import static utilz.Constants.ObjectsConstants.*;

public class HelpMethods {

    public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
        if (!IsSolid(x, y, lvlData))
            if (!IsSolid(x + width, y + height, lvlData))
                if (!IsSolid(x + width, y, lvlData))
                    if (!IsSolid(x, y + height, lvlData))
                        return true;
        return false;
    }

    private static boolean IsSolid(float x, float y, int[][] lvlData) {
        int maxWidth = lvlData[0].length * Game.TILES_SIZE;
        if (x < 0 || x >= maxWidth)
            return true;
        if (y < 0 || y >= Game.GAME_HEIGHT)
            return true;
        float xIndex = x / Game.TILES_SIZE;
        float yIndex = y / Game.TILES_SIZE;

        return IsTileSolid((int) xIndex, (int) yIndex, lvlData);
    }
    
    public static boolean IsProjectileHittingLevel(Projectile p, int[][] lvlData) {
		return IsSolid(p.getHitbox().x + p.getHitbox().width / 2, p.getHitbox().y + p.getHitbox().height / 2, lvlData);

	}
    
    public static boolean IsArrowHittingLevel(Arrow a, int[][] lvlData) {
		return IsSolid(a.getHitbox().x + a.getHitbox().width / 2, a.getHitbox().y + a.getHitbox().height / 2, lvlData);

	}

    public static boolean IsTileSolid(int xTile, int yTile, int[][] lvlData) {
        int value = lvlData[yTile][xTile];

        if (value >= 48 || value < 0 || value != 11)
            return true;
        return false;
    }

    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
        int currentTile = (int) (hitbox.x / Game.TILES_SIZE);
        if (xSpeed > 0) {
            // Right
            int tileXPos = currentTile * Game.TILES_SIZE;
            int xOffset = (int) (Game.TILES_SIZE - hitbox.width);
            return tileXPos + xOffset - 1;
        } else
            // Left
            return currentTile * Game.TILES_SIZE;
    }

    public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
        int currentTile = (int) (hitbox.y / Game.TILES_SIZE);
        if (airSpeed > 0) {
            // Falling - touching floor
            int tileYPos = currentTile * Game.TILES_SIZE;
            int yOffset = (int) (Game.TILES_SIZE - hitbox.height);
            return tileYPos + yOffset - 1;
        } else
            // Jumping
            return currentTile * Game.TILES_SIZE;

    }
    
    public static boolean IsStickHittingLevel(Stick st, int[][] lvlData) {
        return IsSolid(st.getHitbox().x + st.getHitbox().width / 2, st.getHitbox().y + st.getHitbox().height / 2, lvlData);
    }

    public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
        // Check the pixel below bottomleft and bottomright
        if (!IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData))
            if (!IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData))
                return false;

        return true;

    }


    public static boolean IsFloor(Rectangle2D.Float hitbox, float xSpeed, int[][] lvlData) {
        if(xSpeed>0)
            return IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData);
        else
        return IsSolid(hitbox.x + xSpeed, hitbox.y + hitbox.height + 1, lvlData);
    }
    
    public static boolean CanCannonSeePlayer(int[][] lvlData, Rectangle2D.Float firstHitbox, Rectangle2D.Float secondHitbox, int yTile) {
		int firstXTile = (int) (firstHitbox.x / Game.TILES_SIZE);
		int secondXTile = (int) (secondHitbox.x / Game.TILES_SIZE);

		if (firstXTile > secondXTile)
			return IsAllTilesClear(secondXTile, firstXTile, yTile, lvlData);
		else
			return IsAllTilesClear(firstXTile, secondXTile, yTile, lvlData);
	}

    public static boolean IsAllTilesClear(int xStart, int xEnd, int y, int[][] lvlData) {
		for (int i = 0; i < xEnd - xStart; i++)
			if (IsTileSolid(xStart + i, y, lvlData))
				return false;
		return true;
	}

    public static boolean IsAllTilesWalkable(int xStart, int xEnd, int y, int[][] lvlData) {
        for (int i = 0; i < xEnd - xStart; i++) {
            if (IsTileSolid(xStart + i, y, lvlData))
                return false;
            if (!IsTileSolid(xStart + i, y + 1, lvlData))
                return false;
        }

        return true;
    }

    public static boolean IsSightClear(int[][] lvlData, Rectangle2D.Float firstHitbox, Rectangle2D.Float secondHitbox, int yTile) {
        int firstXTile = (int) (firstHitbox.x / Game.TILES_SIZE);
        int secondXTile = (int) (secondHitbox.x / Game.TILES_SIZE);

        if (firstXTile > secondXTile)
            return IsAllTilesWalkable(secondXTile, firstXTile, yTile, lvlData);
        else
            return IsAllTilesWalkable(firstXTile, secondXTile, yTile, lvlData);

    }
    
    public static int[][] GetLevelData(BufferedImage img) {
        int[][] lvlData = new int[img.getHeight()][img.getWidth()];

        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();
                if (value >= 90)
                    value = 0;
                lvlData[j][i] = value;
            }
        return lvlData;

    }

    public static ArrayList<Crabby> GetCrabs(BufferedImage img) {
        ArrayList<Crabby> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == CRABBY)
                    list.add(new Crabby(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;

    }

    public static ArrayList<Potion> GetPotions(BufferedImage img) {
        ArrayList<Potion> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getBlue();
                if (value == RED_POTION || value == BLUE_POTION)
                    list.add(new Potion(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
            }
        return list;

    }
    
    public static ArrayList<Trap1> GetTrap1(BufferedImage img) {
        ArrayList<Trap1> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getBlue();
                if (value == TRAP1)
                    list.add(new Trap1(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
            }
        return list;

    }
    
    public static ArrayList<Scroll> GetScroll(BufferedImage img) {
        ArrayList<Scroll> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getBlue();
                if (value == SCROLL)
                    list.add(new Scroll(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
            }
        return list;

    }
    
    public static ArrayList<Sword> GetSwords(BufferedImage img) {
        ArrayList<Sword> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getBlue();
                if (value == SWORD)
                    list.add(new Sword(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
            }
        return list;

    }
    
    public static ArrayList<Cannon> GetCannons(BufferedImage img) {
		ArrayList<Cannon> list = new ArrayList<>();

		for (int j = 0; j < img.getHeight(); j++)
			for (int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if (value == CANNON_LEFT || value == CANNON_RIGHT)
					list.add(new Cannon(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
			}

		return list;
	}
    
    public static ArrayList<Trap2> GetTrap2(BufferedImage img) {
		ArrayList<Trap2> list = new ArrayList<>();

		for (int j = 0; j < img.getHeight(); j++)
			for (int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if (value == TRAP2_LEFT || value == TRAP2_RIGHT)
					list.add(new Trap2(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
			}

		return list;
	}
    
    public static ArrayList<ArrowTrap> GetArrowTraps(BufferedImage img) {
		ArrayList<ArrowTrap> list = new ArrayList<>();

		for (int j = 0; j < img.getHeight(); j++)
			for (int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getBlue();
				if (value == ARROW_TRAP)
					list.add(new ArrowTrap(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
			}

		return list;
	}
    
    public static ArrayList<Chest> GetChests(BufferedImage img) {
        ArrayList<Chest> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getBlue();
                if (value == CHEST)
                    list.add(new Chest(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
            }
        return list;

    }
    
    public static ArrayList<Flag> GetFlags(BufferedImage img) {
        ArrayList<Flag> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getBlue();
                if (value == FLAG)
                    list.add(new Flag(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
            }
        return list;

    }
    
    
    
    


    public static ArrayList<GameContainer> GetContainers(BufferedImage img) {
        ArrayList<GameContainer> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getBlue();
                if (value == BOX || value == BARREL)
                    list.add(new GameContainer(i * Game.TILES_SIZE, j * Game.TILES_SIZE, value));
            }
        return list;

    }

    public static ArrayList<Shark> GetSharks(BufferedImage img) {
        ArrayList<Shark> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == SHARK)
                    list.add(new Shark(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;

    }

    public static ArrayList<Minotaur> GetMinotaurs(BufferedImage img) {
        ArrayList<Minotaur> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == MINOTAUR)
                    list.add(new Minotaur(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;

    }
    
    public static ArrayList<Toro> GetToros(BufferedImage img) {
        ArrayList<Toro> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == TORO)
                    list.add(new Toro(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;
    }

    public static ArrayList<Boss1> GetBoss1(BufferedImage img) {
        ArrayList<Boss1> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == BOSS1)
                    list.add(new Boss1(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;
    }
    
    public static ArrayList<Boss4> GetBoss4(BufferedImage img) {
        ArrayList<Boss4> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == BOSS4)
                    list.add(new Boss4(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;
    }
    
    public static ArrayList<Boss5> GetBoss5(BufferedImage img) {
        ArrayList<Boss5> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == BOSS5)
                    list.add(new Boss5(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;
    }
    
    public static ArrayList<Monster_Eye1> GetMonEye1(BufferedImage img) {
        ArrayList<Monster_Eye1> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == MONSTER_EYE1)
                    list.add(new Monster_Eye1(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;
    }
    
    public static ArrayList<Monster2> GetMonster2(BufferedImage img) {
        ArrayList<Monster2> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == MONSTER2)
                    list.add(new Monster2(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;
    }
    
    
    public static ArrayList<Spider> GetSpider(BufferedImage img) {
        ArrayList<Spider> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == SPIDER)
                    list.add(new Spider(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;
    }
    
    public static ArrayList<Boss2> GetBoss2(BufferedImage img) {
        ArrayList<Boss2> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == BOSS2)
                    list.add(new Boss2(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;
    }
    
    public static ArrayList<Boss3> GetBoss3(BufferedImage img) {
        ArrayList<Boss3> list = new ArrayList<>();
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getGreen();
                if (value == BOSS3)
                    list.add(new Boss3(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
            }
        return list;
    }
    
    public static Point GetPlayerSpawn(BufferedImage img){
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                	int value = color.getGreen();
                	if (value == 100)
                		return new Point(i*Game.TILES_SIZE,j*Game.TILES_SIZE);
               
            }
        return new Point(1*Game.TILES_SIZE,1*Game.TILES_SIZE);
    }
    

   /* public static boolean IsBulletHittingLevel(Bullet b, int[][] lvlData) {
        return IsSolid(b.getHitbox().x + b.getHitbox().width / 2, b.getHitbox().y + b.getHitbox().height / 2, lvlData);
    }*/

    public static boolean CanMESeePlayer(int[][] lvlData, Rectangle2D.Float firstHitbox, Rectangle2D.Float secondHitbox, int yTile) {
        int firstXTile = (int) (firstHitbox.x / Game.TILES_SIZE);
        int secondXTile = (int) (secondHitbox.x / Game.TILES_SIZE);

        if (firstXTile > secondXTile)
            return IsAllTilesClear(secondXTile, firstXTile, yTile, lvlData);
        else
            return IsAllTilesClear(firstXTile, secondXTile, yTile, lvlData);
    }



}
