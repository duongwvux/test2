package levels;

import entities.Boss1;
import entities.Boss2;
import entities.Boss3;
import entities.Boss4;
import entities.Boss5;
import entities.Crabby;
import entities.Minotaur;
import entities.Monster2;
import entities.Monster_Eye1;
import entities.Shark;
import entities.Spider;
import entities.Toro;
import gameState.Playing;
import main.Game;
import objects.GameContainer;
import objects.Potion;
import objects.Scroll;
import objects.Sword;
import objects.Trap1;
import objects.Trap2;
import objects.ArrowTrap;
import objects.Cannon;
import objects.Chest;
import objects.Flag;
import utilz.HelpMethods;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static utilz.Constants.ObjectsConstants.CANNON_LEFT;
import static utilz.Constants.ObjectsConstants.CANNON_RIGHT;
import static utilz.HelpMethods.*;

public class Level {
    private BufferedImage img;
    private int lvlTilesWide;
    private int maxTilesOffset;
    private int maxLvlOffsetX;
    private int[][] lvlData;
    
    
    private ArrayList<Crabby> crabs;
    private ArrayList<GameContainer> containers;
    private ArrayList<Potion> potions;
    private ArrayList<Trap1> trap1;
    private ArrayList<Chest> chests;
    private ArrayList<Scroll> scrolls;
    private ArrayList<Sword> swords;
    private ArrayList<Cannon> cannons;
    private ArrayList<ArrowTrap> arrowTraps;
    private ArrayList<Trap2> trap2;
    private ArrayList<Flag> flags;
    
    private ArrayList<Shark> sharks;
    private ArrayList<Minotaur> minotaurs;
    private ArrayList<Monster_Eye1> monEye1;
    private ArrayList<Monster2> monster2;
    private ArrayList<Spider> spiders;
    
    private ArrayList<Toro> toros;
    private ArrayList<Boss1> boss1;
    private ArrayList<Boss2> boss2;
    private ArrayList<Boss3> boss3;
    private ArrayList<Boss4> boss4;
    private ArrayList<Boss5> boss5;

    
    private Point playerSpawn;

    
 public Level(BufferedImage img){
    this.img=img;
     createLevelData();
     createEnemies();
     createContainers();
     createPotions();
     createTrap1();
     createChest();
     createScroll();
     createSword();
     createCannons();
     createArrowTraps();
     createTrap2();
     createFlags();
     
     calcLvlOffsets();
     calcPlayerSpawn();
 }
 
 	private void createFlags() {
 		flags = HelpMethods.GetFlags(img);
	
}

	private void createTrap2() {
 		trap2 = HelpMethods.GetTrap2(img);
	
}

	private void createArrowTraps() {
 		arrowTraps = HelpMethods.GetArrowTraps(img);
	
}

	private void createCannons() {
		cannons = HelpMethods.GetCannons(img);
	}

   

	private void createSword() {
		swords = HelpMethods.GetSwords(img);
	
}



	private void createScroll() {
		scrolls = HelpMethods.GetScroll(img);
	
}



	private void createChest() {
    	chests = HelpMethods.GetChests(img);
	
}

	private void createTrap1() {
    	trap1 = HelpMethods.GetTrap1(img);
	
}

	private void calcPlayerSpawn() {
		playerSpawn = GetPlayerSpawn(img);
    }

    private void createContainers() {
        containers = HelpMethods.GetContainers(img);
    }

    private void createPotions() {
        potions = HelpMethods.GetPotions(img);
    }

    private void createEnemies() {
     crabs = GetCrabs(img);
     sharks=GetSharks(img);
     minotaurs=GetMinotaurs(img);
     monEye1 = GetMonEye1(img);
     monster2 = GetMonster2(img);
     spiders = GetSpider(img);
     
     toros = GetToros(img);
     boss1 = GetBoss1(img);
     boss2 = GetBoss2(img);
     boss3 = GetBoss3(img);
     boss4 = GetBoss4(img);
     boss5 = GetBoss5(img);

    }

    private void createLevelData() {
        lvlData = GetLevelData(img);
    }

    private void calcLvlOffsets() {
        lvlTilesWide = img.getWidth();
        maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;
        maxLvlOffsetX = Game.TILES_SIZE * maxTilesOffset;
    }

    public int getSpriteIndex(int x, int y) {
        return lvlData[y][x];

    }

    public int[][] getLvlData() {
        return lvlData;
    }

    public int getLvlOffset() {
        return maxLvlOffsetX;
    }

    public ArrayList<Crabby> getCrabs() {
        return crabs;
    }
    public ArrayList<Chest> getChests() {
        return chests;
    }
    public ArrayList<Sword> getSwords(){
    	return swords;
    }
    


    public ArrayList<GameContainer> getContainers() {
        return containers;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }
    
    public ArrayList<Flag> getFlag() {
    	return flags;
    }
    public ArrayList<Scroll> getScrolls() {
    	return scrolls;
    }
    public ArrayList<Trap2> getTrap2() {
    	return trap2;
    }
    public ArrayList<Trap1> getTrap1() {
    	return trap1;
    }
    public ArrayList<Cannon> getCannons(){
		return cannons;
	}
    public ArrayList<ArrowTrap> getArrowTraps() {
    	return arrowTraps;
    }
    public ArrayList<Shark> getSharks(){return  sharks;}

    public ArrayList<Minotaur> getMinotaurs() {
        return minotaurs;
    }

    public ArrayList<Monster_Eye1> getMonEye1(){
    	return monEye1;
    }
    
    public ArrayList<Monster2> getMonster2(){
    	return monster2;
    }
    
    public ArrayList<Spider> getSpider(){
    	return spiders;
    }
    
    
    public ArrayList<Toro> getToros(){
    	return toros;
    }
    
    public ArrayList<Boss1> getBoss1(){
    	return boss1;
    }
    
    public ArrayList<Boss2> getBoss2(){
    	return boss2;
    }
    
    public ArrayList<Boss3> getBoss3(){
    	return boss3;
    }
    
    public ArrayList<Boss4> getBoss4(){
    	return boss4;
    }
    
    public ArrayList<Boss5> getBoss5(){
    	return boss5;
    }		
    
  public Point getPlayerSpawn(){
     return playerSpawn;
  }
  
  public Point getFlag1() {
	  for (Flag f : flags) {
		  return new Point((int) f.getHitbox().x, (int) f.getHitbox().y);
	  }
	  return new Point(1*Game.TILES_SIZE,1*Game.TILES_SIZE);
	  
	  
  }
    public int getMapHeight() {
        return lvlData.length; // Số hàng trong mảng 2D là chiều cao của bản đồ (theo số tile)
    }
}
