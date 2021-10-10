//Här skapar vi vår spelare, har hand om att flytta sig själv och se om den kolliderar med något

package states;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import constants.Constants;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Player extends Rectangle {
	private int xPos = 400;
	private int yPos = 650;
	private int size = Constants.playerHeight * Constants.playerWidth;
	private Image playerImg;
	private int score;
	private String informantionText = "Score:";
	private Color fontColor = Color.WHITE;
	// Rectangle2D rect = new Rectangle2D(getxPos(), getyPos(),
	// Constants.player_height, Constants.player_width);

	public Player(int x, int y, int s) {

		this.xPos = x;
		this.yPos = y;
		this.size = s;

		try {
			playerImg = new Image(new FileInputStream(Constants.player_image));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public boolean colide(StandardAlien alien) {
		Rectangle2D rectplayer = new Rectangle2D(xPos, yPos, Constants.AlienHeight, Constants.AlienWidth);
		Rectangle2D other = new Rectangle2D(alien.xPos, alien.yPos, Constants.AlienHeight, Constants.AlienWidth);
		return rectplayer.intersects(other);

	}

	public boolean colide(BossAlien bossalien) {
		Rectangle2D rectplayer = new Rectangle2D(xPos, yPos, Constants.AlienHeight, Constants.AlienWidth);
		Rectangle2D other = new Rectangle2D(bossalien.xPos, bossalien.yPos, Constants.AlienHeight,
				Constants.AlienWidth);
		return rectplayer.intersects(other);

	}

	public boolean colide(AlienLaser alienlaser) {
		Rectangle2D rectplayer = new Rectangle2D(getxPos(), getyPos(), Constants.AlienHeight, Constants.AlienWidth);
		Rectangle2D other = new Rectangle2D(alienlaser.getxPos(), alienlaser.getyPos(), Constants.AlienHeight,
				Constants.AlienWidth);
		return rectplayer.intersects(other);

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public void draw(GraphicsContext g) {
		drawTegnell(g);

	}

	public void drawTegnell(GraphicsContext g) {
		g.setFill(fontColor);
		g.setFont(Font.font("Verdana", 20));
		g.fillText(informantionText, 50, 600);
		g.fillText(Integer.toString(getScore()), 120, 600);
		g.drawImage(playerImg, getxPos(), getyPos(), Constants.playerHeight, Constants.playerWidth);
	}

	public void moveRight() {
		xPos += 20;

	}

	public void moveLeft() {
		xPos -= 20;

	}

	public void moveUp() {
		yPos -= 20;
	}

	public void moveDown() {
		yPos += 20;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
