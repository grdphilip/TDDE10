//Den primära fienden, har hand om att rita ut sig själv samt röra sig närmare spelaren

package states;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
 
import constants.Constants;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
 
public class StandardAlien {
    int xPos = 0;
    int yPos = 0;
    int size = Constants.AlienHeight*Constants.AlienWidth;
    int health = Constants.AlienHealth;
    int currentPosX = 0;

    private Image CoronaV;


 
    public StandardAlien(int x, int y ) {
        this.xPos=x;
        this.yPos=y;



        try {
            CoronaV = new Image(new FileInputStream(Constants.standardAlienImg));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
    public int getxPos() {
        return xPos;
    }
 
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }
 
    public int getyPos() {
        return yPos;
    }
 
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
 
    public void draw(GraphicsContext g) {
        drawAlien(g);

    }

    public boolean colide(StandardAlien corona) {
        Rectangle2D rectalien = new Rectangle2D(xPos,yPos, Constants.AlienHeight, Constants.AlienWidth);
        Rectangle2D other = new Rectangle2D(corona.xPos,corona.yPos, Constants.AlienHeight, Constants.AlienWidth);
        return rectalien.intersects(other);

    }


    public void drawAlien (GraphicsContext g )  {
        g.drawImage(CoronaV, getxPos() + 30, getyPos(), Constants.AlienHeight, Constants.AlienWidth);

       // setxPos2(getxPos2() + Constants.AlienWidth + 10);
    }
 
    public void update() {
        setxPos(getxPos() + Constants.AlienWidth + 1);
        if (getxPos() >= 700) {
            setxPos(0);
            yPos+=Constants.alienspeed;


        }

    }
 
    public void move() {
        //plussa p� x, om kanten n�s flytta y-v�rdet
    }
}
