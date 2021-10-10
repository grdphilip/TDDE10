//klassen som har hand om menyn �r liuk de andra meny-statsen

package states;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import constants.Constants;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuState extends GameState {

	private String informationText;

	private String welcomeText;
	private Color fontColor;
	private Image background;

	public MenuState(GameModel model) {
		super(model);
		try {
			background = new Image(new FileInputStream(Constants.menu_bg));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		welcomeText = "Welcome to tegnellInvaders!";
		informationText = "Press ENTER to play \nPress ESCAPE to exit\nPress SPACEBAR for scoreboard";

		fontColor = Color.AQUA;

	}

	public void draw(GraphicsContext g) {

		g.drawImage(background, 0, 0, 800, 800);
	}

	@Override
	public void update() {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ENTER)) {
			model.switchState(new PlayState(model));
		}

		if (e.getCode().equals(KeyCode.ESCAPE)) {
			System.exit(0);
		}
		if (e.getCode().equals(KeyCode.SPACE)) {
			model.switchState(new ScoreState(model));
		}

	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

}
