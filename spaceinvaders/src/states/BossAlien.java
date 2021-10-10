//H�r skriver vi skelettet f�r en bossalien, det ansvar f�r allt som kr�vs f�r att instansiera en bossalien

package states;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import constants.Constants;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BossAlien {
	int xPos = 0;
	int yPos = 0;
	int size = Constants.bossAlienHeigth;
	int health = Constants.bossAlienHealth;
	int currentPosX = 0;

	private Image CoronaBoss;
	// Rectangle2D rectalien = new Rectangle2D(xPos,yPos, Constants.AlienHeight,
	// Constants.AlienWidth);

	public BossAlien(int x, int y, int s) {
		this.xPos = x;
		this.yPos = y;
		this.size = s;

		try {
			CoronaBoss = new Image(new FileInputStream(Constants.bossAlienImg));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		drawBossAlien(g);

	}

	public boolean colide(StandardLaser rectlaser) {
		Rectangle2D rectalien = new Rectangle2D(xPos, yPos, Constants.bossAlienHeigth, Constants.bossAlienWidth);
		Rectangle2D other = new Rectangle2D(rectlaser.getxPos(), rectlaser.getyPos(), Constants.bossAlienHeigth,
				Constants.bossAlienWidth);
		return rectalien.intersects(other);
	}

	public boolean colide(Player player) {
		Rectangle2D rect = new Rectangle2D(xPos, yPos, Constants.bossAlienHeigth, Constants.bossAlienWidth);
		Rectangle2D other = new Rectangle2D(player.getxPos(), player.getyPos(), player.getHeight(),
				player.getArcWidth());
		return rect.intersects(other);

	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void drawBossAlien(GraphicsContext g) {
		g.drawImage(CoronaBoss, getxPos(), getyPos(), Constants.bossAlienHeigth, Constants.bossAlienWidth);

		// setxPos2(getxPos2() + Constants.AlienWidth + 10);
	}

	public void update() {
		setxPos(getxPos() + Constants.AlienWidth + 1);
		if (getxPos() >= 700) {
			setxPos(0);
			yPos += 3;

		}

	}

	public void move() {
		// plussa p� x, om kanten n�s flytta y-v�rdet
	}
}
