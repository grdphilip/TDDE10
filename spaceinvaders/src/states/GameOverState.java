//Denna klass ansvarar f�r det som sker n�r spelaren f�rlorar, ritar ut bilden och �r en 
//v�g till att starta om eller kolla p� highscore

package states;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import constants.Constants;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverState extends GameState {

	private Image gameoverbg;
	private String informationtext;
	private String scoreText;
	private Color fontColor;
	private MenuState menustate;
	private Player player;

	// skapa array-aliens

	public GameOverState(GameModel model) {
		super(model);
		informationtext = "GAME OVER! \nPress ENTER to get back to main menu\nPress ESCAPE to exit\nPress SPACEBAR for scoreboard";
		scoreText = "Your score was";
		fontColor = Color.AQUAMARINE;
		menustate = new MenuState(model);
		player = new Player(400, 650, 5);

		try {
			gameoverbg = new Image(new FileInputStream(Constants.gameover_bg));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		// laser.getYPos(), laser.getXPos());
		// Rectangle2D rect2 =new Rectangle2D(Constants.standardAlienWidth,
		// Constants.standardAlienHeight, alien.getxPos2(), alien.getxPos2());
	}

	public void update() {
		super.saveScore();
	}

	@Override
	public void draw(GraphicsContext g) {

		g.drawImage(gameoverbg, 0, 0, 800, 800);
	}

	@Override
	public void keyPressed(KeyEvent event) {

		if (event.getCode().equals(KeyCode.ENTER)) {
			model.switchState(menustate);
		}
		if (event.getCode().equals(KeyCode.ESCAPE)) {
			System.exit(0);
		}
		if (event.getCode().equals(KeyCode.SPACE)) {
			model.switchState(new ScoreState(model));
		}
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void activate() {

	}

}
