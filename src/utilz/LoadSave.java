package utilz;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;




public class LoadSave {
    public static final String PLAYER_ATLAS ="players_sprites.png";
    
    
    public static final String LEVEL_ATLAS ="tiletest.png";
    public static final String MENU_BACKGROUND ="menu_background.png";
    public static final String MENU_BACKGROUND_IMG ="baner.png";
    public static final String PLAYING_BACKGROUND_IMG ="forest_background.png";
    public static final String  COMPLETED_IMG ="completed_sprite.png";
    public static final String  DEATH_SCREEN ="death_screen.png";
    public static final String LEVEL_UP_IMG="levelUp.png";
 
    public static final String MENU_BUTTONS ="button_atlas.png";
    public static final String PAUSE_BACKGROUND ="pause_menu.png";
    public static final String SOUND_BUTTON ="sound_button.png";
    public static final String URM_BUTTON ="urm_buttons.png";
    public static final String VOLUME_BUTTONS ="volume_buttons.png";
    public static final String STATUS_BAR ="health_power_bar.png";
    public static final String  OPTIONS_MENU ="options_background.png";
    //public static final String BIG_CLOUDS ="big_clouds.png";
    //public static final String SMALL_CLOUDS ="small_clouds.png";
    
    
    public static final String CRABBY_SPRITE ="crabby_sprite.png";
    public static final String SHARK_ATLAS = "shark_atlas.png";
    public static final String MINOTAUR_ATLAS = "NightBorne.png";
    public static final String MONSTER_EYE1_ATLAS = "moneye1_atlas.png";
    public static final String MONSTER2_ATLAS = "monster2_atlas.png";
    public static final String SPIDER_ATLAS = "spider_atlas.png";
    
    public static final String TORO_ATLAS = "Minotaur.png";
    public static final String BOSS1_ATLAS = "boss1_atlas.png";
    public static final String BOSS2_ATLAS = "boss2_atlas.png";
    public static final String BOSS3_ATLAS = "boss3_atlas.png";
    public static final String BOSS4_ATLAS = "boss4_atlas.png";
    public static final String BOSS5_ATLAS = "boss5_atlas.png";

    public static final String STICK_IMG = "stick.png";


    public static final String POTIONS_ATLAS = "potions_sprites.png";
    public static final String CONTAINER_ATLAS = "objects_sprites.png";
    public static final String TRAP1_ATLAS = "trap1_atlas.png";
    public static final String CHEST_ATLAS = "chest.png";
    public static final String TOXICTRAP_ATLAS = "ToxicTrap.png";
    public static final String SCROLL_ATLAS = "scroll_atlas.png";
    public static final String SWORD_ATLAS = "sword_atlas.png";
    public static final String CANNON_ATLAS = "cannon_atlas.png";
	public static final String CANNON_BALL = "ball.png";
	public static final String ARROWTRAP_ATLAS = "arrowtrap.png";
	public static final String ARROW_ATLAS = "arrow.png";
	public static final String TRAP2_ATLAS = "trap2.png";
	public static final String FLAG_ATLAS = "flag.png";


    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }
    public static BufferedImage[] GetAllLevels(){
        URL url = LoadSave.class.getResource("/lvls");
        File file = null;
  try {
      file = new File(url.toURI());
  }catch(URISyntaxException e){
      e.printStackTrace();
  }
  File[] files = file.listFiles();
  File[] filesSorted =new File[files.length];

  for(int i=0;i<filesSorted.length;i++)
      for(int j=0;j<filesSorted.length;j++){
          if(files[j].getName().equals((i+1)+".png"))
              filesSorted[i]=files[j];

      }

  BufferedImage[] imgs = new BufferedImage[filesSorted.length];
       for(int i=0;i< imgs.length;i++) {
           try {
               imgs[i]=ImageIO.read(filesSorted[i]);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }

  return imgs;
    }




}
