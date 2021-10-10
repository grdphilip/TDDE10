package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage gameStage) throws Exception {
		gameStage.setTitle("TotallyAwesomeGame, sort of");
		gameStage.setWidth(1000);
		gameStage.setHeight(800);
		GamePanel model = new GamePanel();
		GameFrame frame = new GameFrame(model, 1000, 800);
		Scene gameScene = new Scene(frame);
		// Set the target number of frames per second
		final double targetFps = 50.0;
		// Calculate frequency in nano seconds
		final double nanoPerUpdate = 1000000000.0 / targetFps;

		gameStage.setScene(gameScene);

		// We set up a setOnKeyPressed, to handle keyboard input,
		// like we had a onMouseClick in the canvas for the paint lab.
		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				// We send it on to the model, to handle it in the various
				// states of the game.
			}
		});

		// We set an AnimationTimer, to control the flow of the game.
		new AnimationTimer() {
			long lastUpdate = 0;

			// This method will be called
			public void handle(long now) {
				// Perform game update and game rendering. This will
				// execute approximately 60 times per second, or as
				// close to that as possible. Can vary greatly between systems.
				// If we want closer control we use something like the
				// if-statement below to control frame rate.

				if ((now - lastUpdate) > nanoPerUpdate) {
					model.update();
					frame.repaint();
					lastUpdate = now;
				}
			}
		}.start(); // We start the timer.

		gameStage.show();

	}
}
