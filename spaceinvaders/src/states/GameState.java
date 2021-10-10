//superklassen f�r alla states, inneh�ller de gaenerella metoderna f�r ett state

package states;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import static constants.Constants.screen_height;
import static constants.Constants.screen_width;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class GameState {

	protected GameModel model;

	public GameState(GameModel model) {
		this.model = model;

	}

	public abstract void update();

	public abstract void draw(GraphicsContext g);

	public abstract void keyPressed(KeyEvent e);

	public abstract void deactivate();

	public abstract void activate();

	public void saveScore() {
		if (model.getScore() > model.highScore()) {
			try {
				FileWriter writer = new FileWriter("src/HighScore.txt");
				writer.write("");
				writer.write(Integer.toString(model.getScore()));
				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				// }
			}
		}

	}

}
