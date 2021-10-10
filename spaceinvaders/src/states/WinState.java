//Skapas när spelaren har avklarat båda nivåerna och dess fiender

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

public class WinState extends GameState {

	private Image winbg;
	private String informationtext;
	private int score = 0;
	private Color fontColor;
	private MenuState menustate;

	// skapa array-aliens

	public WinState(GameModel model) {
		super(model);
		informationtext = "Congratulations, You won!! \nPress ENTER to get back to main menu\nPress ESCAPE to exit\nPress SPACEBAR for scoreboard";
		fontColor = Color.GOLD;
		menustate = new MenuState(model);
		try {
			winbg = new Image(new FileInputStream(Constants.win_bg));

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
		g.drawImage(winbg, 0, 0, 800, 800);

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
