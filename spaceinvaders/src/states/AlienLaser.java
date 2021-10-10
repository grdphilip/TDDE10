//ansvarar f�r laser som aliens skjuter ut

package states;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import constants.Constants;

import javafx.geometry.Rectangle2D;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.image.Image;

public class AlienLaser implements Constants {

	private int xPos;
	private int yPos;
	private int size = 0;
	private Image laserImg;

	public AlienLaser(int x, int y, int s) {

		this.xPos = x;
		this.yPos = y;
		this.size = s;

		try {

			laserImg = new Image(new FileInputStream(Constants.standardAlienImg));

		} catch (FileNotFoundException e) {

		}

	}

	public void drawLaser(GraphicsContext g) {

		g.drawImage(laserImg, xPos, yPos, 10, 50);

	}

	/// Kollar tr�ff och g�r rektanglar

	public boolean colide(StandardAlien alien) {

		Rectangle2D rectlaser = new Rectangle2D(xPos, yPos, Constants.AlienHeight, Constants.AlienWidth);
		Rectangle2D other = new Rectangle2D(alien.xPos, alien.yPos, Constants.AlienHeight, Constants.AlienWidth);
		return rectlaser.intersects(other);

	}

	public boolean colide(Player player) {

		Rectangle2D rectlaser = new Rectangle2D(xPos, yPos, Constants.AlienHeight, Constants.AlienWidth);
		Rectangle2D other = new Rectangle2D(player.getxPos(), player.getyPos(), Constants.AlienHeight,
				Constants.AlienWidth);
		return rectlaser.intersects(other);

	}

	public void draw(GraphicsContext g) {

		drawLaser(g);
	}

	public void update() {

		yPos += 7;
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

}
