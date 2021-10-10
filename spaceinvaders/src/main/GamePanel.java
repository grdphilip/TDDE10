//Skapar canvasen i rutan som gameframe skapar

package main;

import states.GameModel;
import static constants.Constants.screen_width;

import javafx.scene.canvas.Canvas;

import javafx.scene.input.KeyEvent;
import static constants.Constants.screen_height;

public class GamePanel extends Canvas {

	public GamePanel(final GameModel model) {
		this.setWidth(screen_width);
		this.setHeight(screen_height);
	}

	public void repaint(GameModel model) {

		model.draw(getGraphicsContext2D());
		System.out.println("GamePanel");

	}

	public void keyPressed(KeyEvent event) {

	}

	public void draw(GameModel model) {
		model.draw(getGraphicsContext2D());

	}
}
