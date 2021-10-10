package main;

import javafx.scene.layout.HBox;
import states.GameModel;

/**
 * This class Wraps a HBox: A HBox is a second level JavaFX container used
 * organize contents in the window (Stage/Scene).
 *
 * The GameFrame, in this case, has the job of creating the game panel, and
 * adding it to itself in order for it to show.
 *
 */
public class GameFrame extends HBox {
	private GamePanel g;

	public GameFrame(GameModel model, int width, int height) {
		// Create a new GamePanel and add's it to the frame
		g = new GamePanel(model, width, height);
		this.getChildren().add(g);
	}
	
	

	public GameFrame(GamePanel model, int width, int height) {
		// TODO Auto-generated constructor stub
	}



	public void repaint() {
		g.repaint();
	}
}
