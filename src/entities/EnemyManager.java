package entities;

import gameState.Playing;
import levels.Level;
import utilz.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {
	
	private int expUp;
	public boolean checkBoss = false;
	public String[] messBoss;
	
    private Playing playing;
    private BufferedImage[][] crabbyArr;
    private BufferedImage[][] sharkArr;
    private BufferedImage[][] minotaurArr;
    private BufferedImage[][] moneye1Arr;
    private BufferedImage[][] monster2Arr;
    private BufferedImage[][] spiderArr;

    private BufferedImage[][] toroArr;
    private BufferedImage[][] boss1Arr;
    private BufferedImage[][] boss2Arr;
    private BufferedImage[][] boss3Arr;
    private BufferedImage[][] boss4Arr;
    private BufferedImage[][] boss5Arr;

    private ArrayList<Crabby> crabbies = new ArrayList<>();
    private ArrayList<Shark> sharks = new ArrayList<>();
    private ArrayList<Minotaur> minotaurs = new ArrayList<>();
    private ArrayList<Toro> toros = new ArrayList<>();
    private ArrayList<Boss1> boss1 = new ArrayList<>();
    private ArrayList<Monster_Eye1> moneyes = new ArrayList<>();
    private ArrayList<Monster2> monster2s = new ArrayList<>();
    private ArrayList<Spider> spiders = new ArrayList<>();
    private ArrayList<Boss2> boss2 = new ArrayList<>();
    private ArrayList<Boss3> boss3 = new ArrayList<>();
    private ArrayList<Boss4> boss4 = new ArrayList<>();
    private ArrayList<Boss5> boss5 = new ArrayList<>();

    public EnemyManager(Playing playing) {
        this.playing = playing;
        loadEnemyImgsCrabby();
        loadEnemyImgsShark();
        loadEnemyImgsMinotaur();
        loadEnemyImgsToro();
        loadEnemyImgsBoss1();
        loadEnemyImgMoneye1();
        loadEnemyImgMonster2();
        loadEnemyImgSpider();
        loadEnemyImgsBoss2();
        loadEnemyImgsBoss3();
        loadEnemyImgsBoss4();
        loadEnemyImgsBoss5();
        
        this.messBoss = new String[3];
        
        

    }

    public void loadEnemies(Level level) {
        crabbies = level.getCrabs();
        sharks = level.getSharks();
        minotaurs = level.getMinotaurs();
        moneyes = level.getMonEye1();
        monster2s = level.getMonster2();
        spiders = level.getSpider();
        
        toros = level.getToros();
        boss1 = level.getBoss1();
        boss2 = level.getBoss2();
        boss3 = level.getBoss3();
        boss4 = level.getBoss4();
        boss5 = level.getBoss5();

    }

    public void update(int[][] lvlData, Player player) {
    	
  
    	
        boolean isAnyActiveCrabby = false;
        boolean isAnyActiveShark = false;
        boolean isAnyActiveMinotaur = false;
        boolean isAnyActiveMonEye1 = false;
        boolean isAnyActiveMonster2 = false;
        boolean isAnyActiveSpider = false;

        boolean isAnyActiveToro = false;
        boolean isAnyActiveBoss1 = false;
        boolean isAnyActiveBoss2 = false;
        boolean isAnyActiveBoss3 = false;
        boolean isAnyActiveBoss4 = false;
        boolean isAnyActiveBoss5 = false;

        
        for (Shark sh : sharks) 
            if (sh.isActive()) {
                sh.updateHealthBar();
                sh.update(lvlData, player);
                isAnyActiveShark = true;
            }

        for (Crabby c : crabbies)
            if (c.isActive()) {
                c.updateHealthBar();
                c.update(lvlData, player);
                isAnyActiveCrabby = true;
            }
        
            for (Minotaur mino : minotaurs) 
                if (mino.isActive()) {
                    mino.updateHealthBar();
                    mino.update(lvlData, player);
                    
                    isAnyActiveMinotaur = true;
                }
            
            for (Monster_Eye1 me : moneyes)
                if (me.isActive()) {
                    me.updateHealthBar();
                    me.update(lvlData, player);
                    isAnyActiveMonEye1 = true;
                }

            for (Monster2 me2 : monster2s)
                if (me2.isActive()) {
                    me2.updateHealthBar();
                    me2.update(lvlData, player);
                    isAnyActiveMonster2 = true;
                }

            for (Spider spi : spiders)
                if (spi.isActive()) {
                    spi.updateHealthBar();
                    spi.update(lvlData, player);
                    isAnyActiveSpider = true;
                }

            
            for (Toro t : toros) 
                if (t.isActive()) {
                    t.updateHealthBar();
                    t.update(lvlData, player);
                    isAnyActiveToro = true;
                }

            for (Boss1 b : boss1)
                if (b.isActive()) {
                    b.updateHealthBar();
                    b.update(lvlData, player);
                    isAnyActiveBoss1 = true;
                }
            
            for (Boss2 b2 : boss2)
                if (b2.isActive()) {
                    b2.updateHealthBar();
                    b2.update(lvlData, player);
                    isAnyActiveBoss2 = true;
                }

            for (Boss3 b3 : boss3)
                if (b3.isActive()) {
                    b3.updateHealthBar();
                    b3.update(lvlData, player);
                    isAnyActiveBoss3 = true;
                }

            for (Boss4 b4 : boss4)
                if (b4.isActive()) {
                    b4.updateHealthBar();
                    b4.update(lvlData, player);
                    isAnyActiveBoss4 = true;
                }

            for (Boss5 b5 : boss5)
                if (b5.isActive()) {
                	checkBoss= b5.getCheckBoss();
                	if(checkBoss) {
                		for(int i=0; i < 3;i ++)
                			messBoss[i] = b5.getDialogue(i);
                	}
                    b5.updateHealthBar();
                    b5.update(lvlData, player);
                    isAnyActiveBoss5 = true;
                }

            
            if (!isAnyActiveCrabby && !isAnyActiveShark && !isAnyActiveMinotaur && !isAnyActiveToro
                    && !isAnyActiveMonEye1 && !isAnyActiveBoss1
                    && !isAnyActiveMonster2 && !isAnyActiveSpider && !isAnyActiveBoss2 && !isAnyActiveBoss3
                    && !isAnyActiveBoss4 && !isAnyActiveBoss5) {

                playing.setLevelCompleted(true);

            }
        }

    public void draw(Graphics g, int xLvlOffset) {
        drawCrabs(g, xLvlOffset);
        drawSharks(g, xLvlOffset);
        drawMinotaurs(g, xLvlOffset);
        drawMonEye1(g, xLvlOffset);
        drawMon2(g, xLvlOffset);
        drawSpider(g, xLvlOffset);
        
        drawToros(g, xLvlOffset);
        drawBoss1(g, xLvlOffset);
        drawBoss2(g, xLvlOffset);
        drawBoss3(g, xLvlOffset);
        drawBoss4(g, xLvlOffset);
        drawBoss5(g, xLvlOffset);

    }

    private void drawBoss5(Graphics g, int xLvlOffset) {
        for (Boss5 b5 : boss5) {
            if (b5.isActive()) {
                g.drawImage(boss5Arr[b5.getState()][b5.getAniIndex()],
                        (int) (b5.getHitBox().x - xLvlOffset - BOSS5_DRAWOFFSET_X + b5.flipX()),
                        (int) (b5.getHitBox().y - BOSS5_DRAWOFFSET_Y - 20),
                        (int) (BOSS5_WIDTH * b5.flipY() * 1.2), (int) (BOSS5_HEIGHT * 1.2), null);
//                b5.drawHitbox(g, xLvlOffset);
//                b5.drawAttackBox(g, xLvlOffset);
                b5.drawHealthBar(g, xLvlOffset);
            }
        }
    }

    private void drawBoss4(Graphics g, int xLvlOffset) {
        for (Boss4 b4 : boss4) {
            if (b4.isActive()) {
                g.drawImage(boss4Arr[b4.getState()][b4.getAniIndex()],
                        (int) (b4.getHitBox().x - xLvlOffset - BOSS4_DRAWOFFSET_X + b4.flipX()),
                        (int) (b4.getHitBox().y - BOSS4_DRAWOFFSET_Y - 100),
                        (int) (BOSS4_WIDTH * b4.flipY()), (int) (BOSS4_HEIGHT), null);
//                b4.drawHitbox(g, xLvlOffset);
//                b4.drawAttackBox(g, xLvlOffset);
                b4.drawHealthBar(g, xLvlOffset);
            }
        }
    }

    private void drawBoss3(Graphics g, int xLvlOffset) {
        for (Boss3 b3 : boss3) {
            if (b3.isActive()) {
                g.drawImage(boss3Arr[b3.getState()][b3.getAniIndex()],
                        (int) (b3.getHitBox().x - xLvlOffset - BOSS3_DRAWOFFSET_X + b3.flipX()),
                        (int) (b3.getHitBox().y - BOSS3_DRAWOFFSET_Y  - 15),
                        (int) (BOSS3_WIDTH * b3.flipY()), (int) (BOSS3_HEIGHT), null);
//                b3.drawHitbox(g, xLvlOffset);
//                b3.drawAttackBox(g, xLvlOffset);
                b3.drawHealthBar(g, xLvlOffset);
            }
        }
    }

    private void drawBoss2(Graphics g, int xLvlOffset) {
        for (Boss2 b2 : boss2) 
            if (b2.isActive()) {
                g.drawImage(boss2Arr[b2.getState()][b2.getAniIndex()],
                        (int) (b2.getHitBox().x - xLvlOffset - BOSS2_DRAWOFFSET_X + b2.flipX()),
                        (int) (b2.getHitBox().y - BOSS2_DRAWOFFSET_Y - 45),
                        (int) (BOSS2_WIDTH * b2.flipY()), (int) (BOSS2_HEIGHT), null);
//            b2.drawHitbox(g, xLvlOffset);
//            b2.drawAttackBox(g, xLvlOffset);
            b2.drawHealthBar(g, xLvlOffset);
        }
    }
    
    private void drawBoss1(Graphics g, int xLvloffset) {
        for (Boss1 b : boss1) 
            if (b.isActive()) {
                g.drawImage(boss1Arr[b.getState()][b.getAniIndex()],
                        (int) (b.getHitBox().x - xLvloffset - BOSS1_DRAWOFFSET_X + b.flipX()),
                        (int) (b.getHitBox().y - BOSS1_DRAWOFFSET_Y - 60),
                        (int) (BOSS1_WIDTH * b.flipY() * 1.5), (int) (BOSS1_HEIGHT * 1.5), null);
//                b.drawHitbox(g, xLvloffset);
//                b.drawAttackBox(g, xLvloffset);
                b.drawHealthBar(g, xLvloffset);
            }
    }
    
    private void drawToros(Graphics g, int xLvlOffset) {
        for (Toro t : toros) 
            if (t.isActive()) {
                g.drawImage(toroArr[t.getState()][t.getAniIndex()],
                        (int) (t.getHitBox().x - xLvlOffset - TORO_DRAWOFFSET_X + t.flipX()),
                        (int) (t.getHitBox().y - TORO_DRAWOFFSET_Y  ),
                        (int) (TORO_WIDTH * t.flipY() * 1.2), (int) (TORO_HEIGHT * 1.2), null);
//                t.drawAttackHitbox(g, xLvlOffset);
//                t.drawHitbox(g, xLvlOffset);
                t.drawHealthBar(g, xLvlOffset);

            }        
    }
    

    private void drawSpider(Graphics g, int xLvlOffset) {
        for (Spider spi : spiders) {
            if (spi.isActive()){
                g.drawImage(spiderArr[spi.getState()][spi.getAniIndex()],
                        (int) (spi.getHitBox().x - xLvlOffset - SPIDER_DRAWOFFSET_X + spi.flipX()),
                        (int) (spi.getHitBox().y - SPIDER_DRAWOFFSET_Y - 100),
                        (int) (SPIDER_WIDTH * spi.flipY() * 3), (int) (SPIDER_HEIGHT * 3), null);
//            spi.drawAttackHitbox(g, xLvlOffset);
//            spi.drawHitbox(g, xLvlOffset);
            spi.drawHealthBar(g, xLvlOffset);
            }
        }
    }

    private void drawMon2(Graphics g, int xLvlOffset) {
        for (Monster2 me2 : monster2s) 
            if (me2.isActive()) {
                g.drawImage(monster2Arr[me2.getState()][me2.getAniIndex()],
                        (int) (me2.getHitBox().x - xLvlOffset - MON2_DRAWOFFSET_X + me2.flipX()),
                        (int) (me2.getHitBox().y - MON2_DRAWOFFSET_Y - 20),
                        (int) (MON2_WIDTH * me2.flipY() * 1.5), (int) (MON2_HEIGHT * 1.5), null);
//                me2.drawAttackHitbox(g, xLvlOffset);
//                me2.drawHitbox(g, xLvlOffset);
                me2.drawHealthBar(g, xLvlOffset);
            }
    }

    private void drawMonEye1(Graphics g, int xLvlOffset) {
        for (Monster_Eye1 me : moneyes) 
            if (me.isActive()) {
                g.drawImage(moneye1Arr[me.getState()][me.getAniIndex()],
                        (int) (me.getHitBox().x - xLvlOffset - MONEYE1_DRAWOFFSET_X + me.flipX()),
                        (int) (me.getHitBox().y - MONEYE1_DRAWOFFSET_Y + 5),
                        (int) (MONEYE1_WIDTH * me.flipY()), (int) (MONEYE1_HEIGHT), null);
                // me.drawHitbox(g, xLvlOffset);
                // me.drawAttackHitbox(g, xLvlOffset);
                me.drawHealthBar(g, xLvlOffset);
            }
    }

    private void drawCrabs(Graphics g, int xLvloffset) {
        for (Crabby c : crabbies) 
            if (c.isActive()) {
                g.drawImage(crabbyArr[c.getState()][c.getAniIndex()],
                        (int) c.getHitBox().x - xLvloffset - CRABBY_DRAWOFFSET_X + c.flipX(),
                        (int) c.getHitBox().y - CRABBY_DRAWOFFSET_Y, CRABBY_WIDTH * c.flipY(), CRABBY_HEIGHT, null);
//                c.drawAttackBox(g, xLvloffset);
//                c.drawHitbox(g, xLvloffset);
                c.drawHealthBar(g, xLvloffset);
            }
    }

    private void drawSharks(Graphics g, int xLvloffset) {
        for (Shark sh : sharks) 
            if (sh.isActive()) {
                g.drawImage(sharkArr[sh.getState()][sh.getAniIndex()],
                        (int) sh.getHitBox().x - xLvloffset - SHARK_DRAWOFFSET_X + sh.flipX(),
                        (int) sh.getHitBox().y - SHARK_DRAWOFFSET_Y, SHARK_WIDTH * sh.flipY(), SHARK_HEIGHT, null);
//                sh.drawAttackBox(g, xLvloffset);
//                sh.drawHitbox(g, xLvloffset);
                sh.drawHealthBar(g, xLvloffset);
            }
    }

    private void drawMinotaurs(Graphics g, int xLvloffset) {
        for (Minotaur mino : minotaurs) 
            if (mino.isActive()) {
                g.drawImage(minotaurArr[mino.getState()][mino.getAniIndex()],
                        (int) mino.getHitBox().x - xLvloffset - MINOTAUR_DRAWOFFSET_X + mino.flipX(),
                        (int) (mino.getHitBox().y - MINOTAUR_DRAWOFFSET_Y - 10),(int)(MINOTAUR_WIDTH * mino.flipY() * 1.2),
                        (int)(MINOTAUR_HEIGHT * 1.2), null);
//                mino.drawHitbox(g, xLvloffset);
//                mino.drawAttackBox(g, xLvloffset);
                mino.drawHealthBar(g, xLvloffset);
                
            }
    }

    
    public void checkEnemyHit(Rectangle2D.Float attackBox ,Player player) {
        for (Crabby c : crabbies)
            if (c.getCurrentHealth() > 0)
                if (attackBox.intersects(c.getHitBox())) {
                    c.hurt(player.playerDamage, player);
                    expUp = c.getExpUpdate();
                    return;
                }

        for (Shark shark : sharks)
            if (shark.isActive())
                if (shark.getCurrentHealth() > 0)
                    if (attackBox.intersects(shark.getHitBox())) {
                        shark.hurt(player.playerDamage, player);
                        expUp = shark.getExpUpdate();
                        return;
                    }
        
        for (Monster_Eye1 me : moneyes)
            if (me.isActive())
                if (me.getCurrentHealth() > 0)
                    if (attackBox.intersects(me.getHitBox())) {
                        me.hurt(player.playerDamage, player);
                        expUp = me.getExpUpdate();
                        return;
                    }
        
        for (Monster2 me2 : monster2s)
            if (me2.isActive())
                if (me2.getCurrentHealth() > 0)
                    if (attackBox.intersects(me2.getHitBox())) {
                        me2.hurt(player.playerDamage, player);
                        expUp = me2.getExpUpdate();
                        return;
                    }

        for (Spider spi : spiders)
            if (spi.isActive())
                if (spi.getCurrentHealth() > 0)
                    if (attackBox.intersects(spi.getHitBox())) {
                        spi.hurt(player.playerDamage, player);
                        expUp = spi.getExpUpdate();
                        return;
                    }

        for (Minotaur mino : minotaurs)
            if (mino.isActive())
                if (mino.getCurrentHealth() > 0)
                    if (attackBox.intersects(mino.getHitBox())) {
                        mino.hurt(player.playerDamage, player);
                        expUp = mino.getExpUpdate();
                        return;
                    }

        
        for (Toro t : toros)
            if (t.isActive())
                if (t.getCurrentHealth() > 0)
                    if (attackBox.intersects(t.getHitBox())) {
                        t.hurt(player.playerDamage, player);
                        expUp = t.getExpUpdate();
                        return;
                    }

        for (Boss1 b : boss1)
            if (b.isActive())
                if (b.getCurrentHealth() > 0)
                    if (attackBox.intersects(b.getHitBox())) {
                        b.hurt(player.playerDamage, player);
                        expUp = b.getExpUpdate();
                        return;
                    }

        for (Boss2 b2 : boss2)
            if (b2.isActive())
                if (b2.getCurrentHealth() > 0)
                    if (attackBox.intersects(b2.getHitBox())) {
                        b2.hurt(player.playerDamage, player);
                        expUp = b2.getExpUpdate();
                        return;
                    }

        for (Boss3 b3 : boss3)
            if (b3.isActive())
                if (b3.getCurrentHealth() > 0)
                    if (attackBox.intersects(b3.getHitBox())) {
                        b3.hurt(player.playerDamage, player);
                        expUp = b3.getExpUpdate();
                        return;
                    }

        for (Boss4 b4 : boss4)
            if (b4.isActive())
                if (b4.getCurrentHealth() > 0)
                    if (attackBox.intersects(b4.getHitBox())) {
                        b4.hurt(player.playerDamage, player);
                        expUp = b4.getExpUpdate();
                        return;
                    }

        for (Boss5 b5 : boss5)
            if (b5.isActive())
                if (b5.getCurrentHealth() > 0)
                    if (attackBox.intersects(b5.getHitBox())) {
                        b5.hurt(player.playerDamage, player);
                        expUp = b5.getExpUpdate();
                        return;
                    }

    }


    public boolean isStickHitEnemy(Rectangle2D.Float stickHitBox ,Player player) {
        for (Crabby c : crabbies)
            if (c.getCurrentHealth() > 0)
                if (stickHitBox.intersects(c.getHitBox())) {
                   return true;
                }

        for (Shark shark : sharks)
            if (shark.isActive())
                if (shark.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(shark.getHitBox())) {
                        return true;
                    }

        for (Monster_Eye1 me : moneyes)
            if (me.isActive())
                if (me.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(me.getHitBox())) {
                        return true;
                    }

        for (Monster2 me2 : monster2s)
            if (me2.isActive())
                if (me2.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(me2.getHitBox())) {
                        return true;
                    }

        for (Spider spi : spiders)
            if (spi.isActive())
                if (spi.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(spi.getHitBox())) {
                        return true;
                    }

        for (Minotaur mino : minotaurs)
            if (mino.isActive())
                if (mino.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(mino.getHitBox())) {
                        return true;
                    }


        for (Toro t : toros)
            if (t.isActive())
                if (t.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(t.getHitBox())) {
                        return true;
                    }

        for (Boss1 b : boss1)
            if (b.isActive())
                if (b.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(b.getHitBox())) {
                        return true;
                    }

        for (Boss2 b2 : boss2)
            if (b2.isActive())
                if (b2.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(b2.getHitBox())) {
                        return true;
                    }

        for (Boss3 b3 : boss3)
            if (b3.isActive())
                if (b3.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(b3.getHitBox())) {
                        return true;
                    }

        for (Boss4 b4 : boss4)
            if (b4.isActive())
                if (b4.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(b4.getHitBox())) {
                        return true;
                    }

        for (Boss5 b5 : boss5)
            if (b5.isActive())
                if (b5.getCurrentHealth() > 0)
                    if (stickHitBox.intersects(b5.getHitBox())) {
                        return true;
                    }

        return false;

    }

    private void loadEnemyImgSpider() {
        spiderArr = new BufferedImage[5][9];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.SPIDER_ATLAS);
        for (int j = 0; j < spiderArr.length; j++)
            for (int i = 0; i < spiderArr[j].length; i++)
                spiderArr[j][i] = temp.getSubimage(i * SPIDER_WIDTH_DEFAULT, j * SPIDER_HEIGHT_DEFAULT,
                        SPIDER_WIDTH_DEFAULT, SPIDER_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgMonster2() {
        monster2Arr = new BufferedImage[5][8];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MONSTER2_ATLAS);
        for (int j = 0; j < monster2Arr.length; j++)
            for (int i = 0; i < monster2Arr[j].length; i++)
                monster2Arr[j][i] = temp.getSubimage(i * MON2_WIDTH_DEFAULT, j * MON2_HEIGHT_DEFAULT,
                        MON2_WIDTH_DEFAULT, MON2_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgsCrabby() {
        crabbyArr = new BufferedImage[5][9];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.CRABBY_SPRITE);
        for (int j = 0; j < crabbyArr.length; j++)
            for (int i = 0; i < crabbyArr[j].length; i++)
                crabbyArr[j][i] = temp.getSubimage(i * CRABBY_WIDTH_DEFAULT, j * CRABBY_HEIGHT_DEFAULT,
                        CRABBY_WIDTH_DEFAULT, CRABBY_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgsShark() {
        sharkArr = new BufferedImage[5][8];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.SHARK_ATLAS);
        for (int j = 0; j < sharkArr.length; j++)
            for (int i = 0; i < sharkArr[j].length; i++)
                sharkArr[j][i] = temp.getSubimage(i * SHARK_WIDTH_DEFAULT, j * SHARK_HEIGHT_DEFAULT,
                        SHARK_WIDTH_DEFAULT, SHARK_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgsMinotaur() {
        minotaurArr = new BufferedImage[5][23];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MINOTAUR_ATLAS);
        for (int j = 0; j < minotaurArr.length; j++)
            for (int i = 0; i < minotaurArr[j].length; i++)
                minotaurArr[j][i] = temp.getSubimage(i * MINOTAUR_WIDTH_DEFAULT, j * MINOTAUR_HEIGHT_DEFAULT,
                        MINOTAUR_WIDTH_DEFAULT, MINOTAUR_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgMoneye1() {
        moneye1Arr = new BufferedImage[5][15];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MONSTER_EYE1_ATLAS);
        for (int j = 0; j < moneye1Arr.length; j++)
            for (int i = 0; i < moneye1Arr[j].length; i++)
                moneye1Arr[j][i] = temp.getSubimage(i * MONEYE1_WIDTH_DEFAULT, j * MONEYE1_HEIGHT_DEFAULT,
                        MONEYE1_WIDTH_DEFAULT, MONEYE1_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgsToro() {
        toroArr = new BufferedImage[5][9];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.TORO_ATLAS);
        for (int j = 0; j < toroArr.length; j++)
            for (int i = 0; i < toroArr[j].length; i++)
                toroArr[j][i] = temp.getSubimage(i * TORO_WIDTH_DEFAULT, j * TORO_HEIGHT_DEFAULT, TORO_WIDTH_DEFAULT,
                        TORO_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgsBoss1() {
        boss1Arr = new BufferedImage[5][7];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BOSS1_ATLAS);
        for (int j = 0; j < boss1Arr.length; j++)
            for (int i = 0; i < boss1Arr[j].length; i++)
                boss1Arr[j][i] = temp.getSubimage(i * BOSS1_WIDTH_DEFAULT, j * BOSS1_HEIGHT_DEFAULT,
                        BOSS1_WIDTH_DEFAULT, BOSS1_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgsBoss2() {
        boss2Arr = new BufferedImage[5][7];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BOSS2_ATLAS);
        for (int j = 0; j < boss2Arr.length; j++)
            for (int i = 0; i < boss2Arr[j].length; i++)
                boss2Arr[j][i] = temp.getSubimage(i * BOSS2_WIDTH_DEFAULT, j * BOSS2_HEIGHT_DEFAULT,
                        BOSS2_WIDTH_DEFAULT, BOSS2_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgsBoss3() {
        boss3Arr = new BufferedImage[5][7];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BOSS3_ATLAS);
        for (int j = 0; j < boss3Arr.length; j++)
            for (int i = 0; i < boss3Arr[j].length; i++)
                boss3Arr[j][i] = temp.getSubimage(i * BOSS3_WIDTH_DEFAULT, j * BOSS3_HEIGHT_DEFAULT,
                        BOSS3_WIDTH_DEFAULT, BOSS3_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgsBoss4() {
        boss4Arr = new BufferedImage[5][20];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BOSS4_ATLAS);
        for (int j = 0; j < boss4Arr.length; j++)
            for (int i = 0; i < boss4Arr[j].length; i++)
                boss4Arr[j][i] = temp.getSubimage(i * BOSS4_WIDTH_DEFAULT, j * BOSS4_HEIGHT_DEFAULT,
                        BOSS4_WIDTH_DEFAULT, BOSS4_HEIGHT_DEFAULT);
    }

    private void loadEnemyImgsBoss5() {
        boss5Arr = new BufferedImage[5][8];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BOSS5_ATLAS);
        for (int j = 0; j < boss5Arr.length; j++)
            for (int i = 0; i < boss5Arr[j].length; i++)
                boss5Arr[j][i] = temp.getSubimage(i * BOSS5_WIDTH_DEFAULT, j * BOSS5_HEIGHT_DEFAULT,
                        BOSS5_WIDTH_DEFAULT, BOSS5_HEIGHT_DEFAULT);
    }

    public void resetAllEnemies() {
        for (Crabby c : crabbies)
            c.resetEnemy();
        for (Shark sh : sharks)
            sh.resetEnemy();
        for (Minotaur mino : minotaurs)
            mino.resetEnemy();
        for (Monster_Eye1 me : moneyes)
            me.resetEnemy();
        for (Monster2 me2 : monster2s)
            me2.resetEnemy();
        for (Spider spi : spiders)
            spi.resetEnemy();
        
        for (Toro t : toros)
            t.resetEnemy();
        for (Boss1 b : boss1)
            b.resetEnemy();
        for (Boss2 b2 : boss2)
            b2.resetEnemy();
        for (Boss3 b3 : boss3)
            b3.resetEnemy();
        for (Boss4 b4 : boss4)
            b4.resetEnemy();
        for (Boss5 b5 : boss5)
            b5.resetEnemy();
       checkBoss = false;
    }
    
    
    public int getExpUp() {
    	return expUp;
    }
    
    public void setExpUp(int expUp) {
    	this.expUp = expUp;
    }

}
