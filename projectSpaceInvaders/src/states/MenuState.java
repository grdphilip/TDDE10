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
    private Color fontColor;
    private Image background;
    private PlayState playstate;

    public MenuState(GameModel model) {
        super(model);
        try {
        	 background = new Image(new FileInputStream(Constants.menu_bg));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        informationText = "Press ENTER to play \n Press ESCAPE to exit\nPress SPACEBAR for scoreboard";
        playstate = new PlayState(model);
        fontColor = Color.AQUA;

    }

    public void draw(GraphicsContext g) {

        //drawBg(g);
        g.drawImage(background, 0, 0, Constants.screen_height, Constants.screen_width);

        g.setFill(fontColor);
        g.setFont(new Font(30));
        g.fillText(informationText, Constants.screen_height/ 2 - 150, Constants.screen_width/2);
        System.out.println("MenuState");

    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            model.switchState(playstate);
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