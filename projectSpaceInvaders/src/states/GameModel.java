package states;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

/**
 * This class represents the current state of the game.
 *
 * This implementation of a state machine keeps a reference to the current state
 * (see /src/states/GameState).
 *
 * Please note: This is just one way to do it, there are several other ways and
 * none of them work for every case, so if you want to implement your own state
 * machine make sure that it can do all the operations that you need for your
 * project.
 *
 * To change state simply call the switchState(GameState nextState) function
 * passing a reference to some other gameState.
 *
 * Initial State: MenuState
 *
 */

public class GameModel {

	private GameState currentState;

	public GameModel() {
		// We start out in the MenuState.
		this.currentState = new MenuState(this);
	}

	/**
	 * Switch to a new state, stored in the 'state' reference.
	 *
	 * This will call 'deactivate' on the current state, then store the new state as
	 * the current state, and finally call 'activate' on the new current state.
	 */
	public void switchState(GameState nextState) {
		currentState.deactivate();
		currentState = nextState;
		currentState.activate();
	}

	/**
	 * Delegates the keyPress from GamePanel to the current state
	 * 
	 * @param key
	 */
	public void keyPressed(KeyEvent key) {
		currentState.keyPressed(key);
	}

	/**
	 * The update function is called every iteration of the game loop. it's usually
	 * used to update the games logic e.g. objects position, velocity, etc...
	 */
	public void update() {
		currentState.update();
	}

	/**
	 * @param g Graphics object passed from GamePanel This function delegates
	 *          drawing from the GamePanel to the current state
	 */
	public void draw(GraphicsContext g) {
		currentState.draw(g);
	}
}
