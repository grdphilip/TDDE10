//Har hand om att visa användaren sin senaste poäng och även högsta poäng

package states;
 
import java.io.File;
import java.io.FileInputStream;
 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import constants.Constants;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
 
public class ScoreState extends GameState {
 
    private Image space;
    private String informationtext;
    private int score = 0;
    private Color fontColor = Color.BLACK;
    private MenuState menustate;
    private Player player;
 
    
 
    // skapa array-aliens
 
    public ScoreState(GameModel model) {
        super(model);
        informationtext = "HIGHSCORES \n\n\n\nPress ENTER to get back to main menu\nPress ESCAPE to exit";
        player = new Player(400, 650, 50);
        player.setScore(model.getScore());
        menustate = new MenuState(model);
        try {
            space = new Image(new FileInputStream(Constants.score_bg));
 
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
 
            e.printStackTrace();
        }
 
        // laser.getYPos(), laser.getXPos());
        // Rectangle2D rect2 =new Rectangle2D(Constants.standardAlienWidth,
        // Constants.standardAlienHeight, alien.getxPos2(), alien.getxPos2());
    }
 
    public void update() {

    }
 
        
 
    @Override
    public void draw(GraphicsContext g) {
        g.clearRect(0, 0, Constants.screen_width, Constants.screen_height);
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 800, 800);
        g.setFill(fontColor);
        g.drawImage(space, 0, 0, 800, 800);
        g.setFont(Font.font("Verdana", 20));
        g.fillText("YOUR SCORE: ", 250, 320);
        g.fillText(Integer.toString(player.getScore()), 410, 320);
        g.fillText("HIGHSCORE:", 250, 360);
        try {
            File myObj = new File("src/HighScore.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              g.fillText(data, 410, 360);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }


 
    @Override
    public void keyPressed(KeyEvent event) {
 
        if (event.getCode().equals(KeyCode.ENTER)) {
            model.switchState(menustate);
        }
        if (event.getCode().equals(KeyCode.ESCAPE)) {
                System.exit(0);
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
