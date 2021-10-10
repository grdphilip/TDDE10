//Startar applikationen, h�ller i spelloopen, h�r skapar vi ocks� gamepanel, gameframe och model

package main;

import constants.Constants;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import states.GameModel;
import states.PlayState;
import states.StandardAlien;

public class Main extends Application {

	public void start(Stage primaryStage) throws Exception {

		try {

			primaryStage.setTitle("Space invaders HD");
			primaryStage.setWidth(Constants.screen_width);
			primaryStage.setHeight(Constants.screen_height);
			HBox mainLayout = new HBox();
			Scene scene = new Scene(mainLayout);
			GameFrame gameFrame = new GameFrame();
			GameModel model = new GameModel();
			GamePanel gamePanel = new GamePanel(model);

			
			mainLayout.getChildren().add(gamePanel);
			gamePanel.repaint(model);
			

			primaryStage.setScene(scene);

			// Set the target number of frames per second
			final double targetFps = 120.0;
			// Calculate frequency in nano seconds
			final double nanoPerUpdate = 1000000000.0 / targetFps;

			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					// We send it on to the model, to handle it in the various
					// states of the game.
					model.keyPressed(event);
					
				}
			});

			new AnimationTimer() {
				long lastUpdate = 0;

				public void handle(long now) {

					//if ((now - lastUpdate) > nanoPerUpdate) {
						gamePanel.draw(model);
						model.update();
						//lastUpdate = now;
					//}
				}
			}.start();

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Underlying" + e.getCause());

		}
	}

	public static void main(String[] args) {
		launch(args);

	}


}