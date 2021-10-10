//Playstate är där spelet utspelas, den skriver ut fiender, spelaren, skott, uppdaterar alöla rörelser osv, detta är level 1
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
 
public class PlayState extends GameState {
 
    private Image space;
    private Player player;
 
    // skapa array-aliens
    private ArrayList<StandardAlien> aliens = new ArrayList<>();
    private ArrayList<StandardLaser> lasers = new ArrayList<>();

    public PlayState(GameModel model) {
        super(model);
        player = new Player(400, 650, 50);
        System.out.println("PLAYER");
 
        // gameoverstate = new GameOverState(model);
 
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 14; i++) {
                aliens.add(new StandardAlien(Constants.AlienWidth * i, Constants.AlienHeight * j));
            }
        }
        System.out.println("aliens");
 
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
 
        for (StandardLaser laser : lasers) {
            laser.update();
        }
 
        for (StandardAlien alien : aliens) {
            alien.update();
 
        }
 
        if (aliens.size() == 0) {
        	model.setScore(player.getScore());
            model.switchState(new Level2PlayState(model));
        }
 
    }
 
    public boolean checkCollision() {
 
        for (StandardAlien alien : aliens) {
            if (player.colide(alien)) {
            	 model.setScore(player.getScore());
                 model.switchState(new GameOverState(model));
 
            }
        }
 
        StandardAlien removedAlien = null;
        StandardLaser removedLaser = null;
 
        for (StandardAlien alien : aliens) {
            for (StandardLaser laser : lasers) {
                if (laser.colide(alien)) {
                    removedLaser = laser;
                    removedAlien = alien;
                    player.setScore(player.getScore()+10);
                    break;
 
                }
            }
            lasers.remove(removedLaser);
        }
        aliens.remove(removedAlien);
 
        return false;
 
    }
 
    @Override
    public void draw(GraphicsContext g) {
        g.clearRect(0, 0, Constants.screen_width, Constants.screen_height);
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 800, 800);
        player.draw(g);
 
        for (StandardAlien alien : aliens) {
            if (alien.getyPos() < 700) {
                alien.draw(g);
 
            }
        }
 
        for (StandardLaser laser : lasers) {
            laser.draw(g);
 
        }
 
    }
 
    @Override
    public void keyPressed(KeyEvent event) {
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
 
        if (event.getCode().equals(KeyCode.X)) {
            if (player.getScore() < 400) {
                lasers.add(new StandardLaser(player.getxPos(), player.getyPos(), lasers.size()));
            }
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
