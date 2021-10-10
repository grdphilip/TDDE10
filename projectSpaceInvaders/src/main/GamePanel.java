package main;

import states.GameModel;

import javafx.scene.canvas.Canvas;

/**
 * The GamePanel wraps a Canvas
 *
 * The main responsibilities of the GamePanel are:
 *      - Supplying the game with a GraphicsContext object for painting different states
 *      - Governing the size of the "game-surface".
 */
public class GamePanel extends Canvas {

	private GameModel model;

    public GamePanel(final GameModel model, int width, int height) {
        this.model = model;
        this.setWidth(width);
        this.setHeight(height);
    }





	



	public GamePanel() {
		// TODO Auto-generated constructor stub
	}









	public void repaint() {
    	model.draw(getGraphicsContext2D());
    }

	public void update() {
		// TODO Auto-generated method stub
		
	}
}
