package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics2D;


import gameState.Playing;
import main.Game;
import main.GamePanel;

public class UI {
	Playing playing;
	Font arial_40;
	Font arial_5;
	public boolean messageOn = false;
	public String message;
	private int counter =0;
	
	
	private String[] text1;
	private int textLength;
	
	public UI(Playing playing) {
		this.playing = playing ;
		arial_40 = new Font("Arial", Font.BOLD, 25);
		arial_5 = new Font("Arial", Font.ITALIC, 15);
		text1 = new String[10];	
	}
	
	public void showMessage(String text) {
		
		message = text;
		messageOn = true;
	}
	
	//hien thi FPS va phan tang kinh nghiem
	public void draw(Graphics2D g2) {
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawString("FPS: " + playing.getGame().getFPS(),  1090, 50);
		
		if(messageOn) {
			counter ++;
			g2.setFont(g2.getFont().deriveFont(20F));
			g2.setColor(Color.green);
			g2.drawString(message, Game.GAME_WIDTH/2 - 20, 40);
			
			if( counter > 115) {
				counter =0;
				messageOn = false;
			}
		}
	}
	
	public void setText(String[] text, int count) {
		textLength = count;
		for(int i=0; i < count; i++) {
			this.text1[i] = text[i];
		}
	}
	
	//hien thi khung tro chuyen giua nhan vat va boss
	public void drawDialogueScreen(Graphics2D g2, int textIndex) {
		
		int x = Game.GAME_WIDTH /12;
		int y = Game.GAME_HEIGHT/2  - 200;
		int width = Game.GAME_WIDTH - (Game.TILES_SIZE*4);
		int height = Game.TILES_SIZE * 4;
		
		drawSubWindow(x, y, width, height, g2, textIndex);
	}

	private void drawSubWindow(int x, int y, int width, int height, Graphics2D g2, int textIndex) {
		String intro1 = "Nhấn nút ENTER để tiếp tục";
		String intro2 = "Nhấn nút Q để chiến đấu";
		
		//nen cua dialogue
		Color c = new Color(0,0,0,100);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 50, 35);
		
		//viền cua dialogue
		c=new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y + 5, width -10, height -10, 40, 25);
		
		
		
		if(textIndex >= textLength-1) {
			g2.setFont(arial_5);
			g2.setColor(Color.red);
			g2.drawString(intro2, x + 800, y + 150);
		}else {
			g2.setFont(arial_5);
			g2.setColor(Color.red);
			g2.drawString(intro1, x + 800, y + 150);
		}	
		
		
		//hiển thị chữ
		if(textIndex >= textLength)
			textIndex = textLength -1;
		drawText(text1, textIndex, g2, x + 10, y + 50);
		
		
	}
	
	private void drawText(String[] text, int index, Graphics2D g2, int x, int y) {
		g2.setFont(g2.getFont().deriveFont(25F));
		g2.setColor(Color.green);
		
		for(String line: text[index].split("\n")) {
			g2.drawString(line, x + 10, y);
			y+= 26;
		}
	}
}
