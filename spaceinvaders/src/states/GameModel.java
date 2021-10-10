//ansvarar f�r att byta states och det funkar bra, j�ttebra

package states;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class GameModel {

	private GameState currentState;
	private int score = 0;
	private int highScore = 0;

	public GameModel() {
		this.currentState = new MenuState(this);

	}

	public void switchState(GameState nextState) {
		currentState.deactivate();
		currentState = nextState;
		currentState.activate();

	}

	public void update() {
		currentState.update();

	}

	public void draw(GraphicsContext g) {
		currentState.draw(g);

	}

	public void keyPressed(KeyEvent event) {
		currentState.keyPressed(event);
	}

	public void checkCollision() {

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int highScore() {

		try {
			File myObj = new File("src/HighScore.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				highScore = Integer.parseInt(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return highScore;
	}

}
