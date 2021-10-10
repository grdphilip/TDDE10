//denna klass ansvarar för den andra nivån i spelet, är väldigt lik nivå ett med undantaget
//att vi även skapar en bossalien med möjligheten att skjutan tillbaka

package states;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import constants.Constants;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Level2PlayState extends GameState {

	private Image space;
	private Player player;
	private int currentPosX;
	private int score = 0;
	private int alienSize = 16;
	private GameOverState gameoverstate;
	// skapa array-aliens
	private ArrayList<StandardAlien> aliens = new ArrayList<>();
	private ArrayList<StandardLaser> lasers = new ArrayList<>();
	private ArrayList<BossAlien> bossaliens = new ArrayList<>();
	private ArrayList<PowerUpLaser> poweruplaser = new ArrayList<>();
	private ArrayList<AlienLaser> alienlasers = new ArrayList<>();

	public Level2PlayState(GameModel model) {
		super(model);
		player = new Player(400, 650, 50);
		player.setScore(model.getScore());

		for (int j = 0; j < 6; j++) {
			for (int i = 0; i < 14; i++) {
				aliens.add(new StandardAlien(0 + Constants.AlienWidth * i, +Constants.AlienHeight * j));
			}
		}

		for (int j = 0; j < 1; j++) {
			for (int i = 0; i < 2; i++) {
				bossaliens.add(new BossAlien(0 + Constants.bossAlienHeigth * i, 0 + Constants.bossAlienHeigth * j, 0));
				System.out.println("Här är jag inne i bossen");
			}
		}

		try {
			space = new Image(new FileInputStream(Constants.space_image));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		// laser.getYPos(), laser.getXPos());
		// Rectangle2D rect2 =new Rectangle2D(Constants.standardAlienWidth,
		// Constants.standardAlienHeight, alien.getxPos2(), alien.getxPos2());
	}

	public void update() {

		checkCollision();
		createAlienLaser();

		// UPPDATERAR FÖRFLYTTNINGAR UNDER PÅ SKÄRMEN

		for (StandardLaser laser : lasers) {
			laser.update();
		}

		for (StandardAlien alien : aliens) {
			alien.update();

		}

		for (BossAlien bossalien : bossaliens) {
			bossalien.update();
		}

		if (bossaliens.size() == 0) {
			model.setScore(player.getScore());
			model.switchState(new WinState(model));
		}

		for (PowerUpLaser bosslaser : poweruplaser) {
			bosslaser.update();
		}

		for (AlienLaser alienlaser : alienlasers) {
			alienlaser.update();
		}

	}

	// Flytta spelaren i här istället

	// for (StandardAlien alien : aliens) {
	// alien.move();
	// }

	public boolean checkCollision() {

		for (StandardAlien alien : aliens) {
			if (player.colide(alien)) {
				model.setScore(player.getScore());
				model.switchState(new GameOverState(model));
			}

			for (BossAlien bossalien : bossaliens) {
				if (player.colide(bossalien)) {
					model.setScore(player.getScore());
					model.switchState(new GameOverState(model));
				}

			}

			for (AlienLaser alienlaser : alienlasers) {
				if (player.colide(alienlaser)) {
					model.setScore(player.getScore());
					model.switchState(new GameOverState(model));
				}

			}

		}
		StandardAlien removedAlien = null;
		StandardLaser removedLaser = null;

		for (StandardAlien alien : aliens) {
			for (StandardLaser laser : lasers) {
				if (laser.colide(alien)) {
					removedLaser = laser;
					removedAlien = alien;
					player.setScore(player.getScore() + 10);
					System.out.println(score);
					break;
				}
			}
			lasers.remove(removedLaser);
		}
		aliens.remove(removedAlien);

		BossAlien removedBossAlien = null;
		PowerUpLaser removedBossLaser = null;

		for (StandardAlien alien : aliens) {
			for (PowerUpLaser bosslaser : poweruplaser) {
				if (bosslaser.colide(alien)) {
					removedBossLaser = bosslaser;
					removedAlien = alien;
					player.setScore(player.getScore() + 10);
					break;

				}
			}
			poweruplaser.remove(removedBossLaser);
		}
		aliens.remove(removedAlien);

		for (BossAlien bossalien : bossaliens) {
			for (PowerUpLaser bosslaser : poweruplaser) {
				if (bosslaser.colide(bossalien)) {
					player.setScore(player.getScore() + 20);
					bossalien.health -= 1;
					if (bossalien.health == 0) {

						removedBossLaser = bosslaser;
						removedBossAlien = bossalien;
						break;

					}

				}
			}
			poweruplaser.remove(removedBossLaser);
		}
		bossaliens.remove(removedBossAlien);

		for (BossAlien bossalien : bossaliens) {
			for (AlienLaser alienLaser : alienlasers) {
				if (alienLaser.colide(player) || bossalien.colide(player)) {
					model.setScore(player.getScore());
					model.switchState(new GameOverState(model));
				}
			}
		}
		bossaliens.remove(removedBossAlien);

		return false;

	}

	@Override
	public void draw(GraphicsContext g) {
		g.clearRect(0, 0, Constants.screen_width, Constants.screen_height);
		g.setFill(Color.BLACK);

		// g.drawImage(space, 0, 0, 800, 800);
		g.fillRect(0, 0, 800, 800);
		player.draw(g);

		for (StandardAlien alien : aliens) {
			if (alien.getyPos() < 700) {
				alien.draw(g);

			}
		}

		if (aliens.size() == 0) {
			for (BossAlien bossalien : bossaliens) {
				bossalien.draw(g);
			}
		}

		for (StandardLaser laser : lasers) {
			laser.draw(g);
		}

		for (PowerUpLaser bosslaser : poweruplaser) {
			bosslaser.draw(g);
		}

		for (AlienLaser alienlaser : alienlasers) {
			alienlaser.draw(g);

		}

	}

	@Override
	public void keyPressed(KeyEvent event) {

		/// RÖRELSER
		if (event.getCode().equals(KeyCode.LEFT)) {
			// player.setxPos(player.getxPos() - Constants.playerSpeed);
			player.moveLeft();

		}
		if (event.getCode().equals(KeyCode.RIGHT)) {
			// player.setxPos(player.getxPos() + Constants.playerSpeed);
			player.moveRight();
		}

		if (event.getCode().equals(KeyCode.UP)) {
			// player.setxPos(player.getxPos() + Constants.playerSpeed);
			player.moveUp();
		}

		if (event.getCode().equals(KeyCode.DOWN)) {
			// player.setxPos(player.getxPos() + Constants.playerSpeed);
			player.moveDown();
		}

		//// FÖR LASERN VI SKJUTER
		if (event.getCode().equals(KeyCode.X)) {
			if (player.getScore() < 400) {
				lasers.add(new StandardLaser(player.getxPos(), player.getyPos(), lasers.size()));

			} else {
				poweruplaser.add(new PowerUpLaser(player.getxPos(), player.getyPos(), poweruplaser.size()));

			}

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

	public void createAlienLaser() {
		if (player.getScore() >= 830 && player.getScore() <= 833) {
			alienlasers.add(new AlienLaser(player.getxPos(), 0, Constants.AlienHeight));
		}
		if (player.getScore() >= 1200 && player.getScore() <= 1210) {
			alienlasers.add(new AlienLaser(player.getxPos(), 0, Constants.AlienHeight));
		}
		if (player.getScore() >= 1400 && player.getScore() <= 1412) {
			alienlasers.add(new AlienLaser(player.getxPos(), 0, Constants.AlienHeight));
		}

	}

	public void addScore() {
		// TODO Auto-generated method stub

	}
}
