//Hanterar den uppgraderade lasern, den aktiveras först när spelaren har x antal poäng

package states;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
 
import constants.Constants;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
 
public class PowerUpLaser implements Constants {
 
    private int xPos;
    private int yPos;
    private int size = Constants.standardLaserHeight*standardLaserWidth;
    private Image bosslaserImg;
 
    public PowerUpLaser(int x, int y, int s) {
        this.xPos = x;
        this.yPos = y;
        this.size = s;
        try {
            bosslaserImg = new Image(new FileInputStream(Constants.powerLaserImg));
        } catch (FileNotFoundException e) {
 
        }
    }

    public void drawLaser(GraphicsContext g) {
        g.drawImage(bosslaserImg, xPos, yPos, 40,80);

    }

    public boolean colide(StandardAlien alien) {
        Rectangle2D rectlaser = new Rectangle2D(xPos,yPos, Constants.AlienHeight, Constants.AlienWidth);
        Rectangle2D other = new Rectangle2D(alien.xPos,alien.yPos, Constants.AlienHeight, Constants.AlienWidth);
        return rectlaser.intersects(other);

    }
 
    
    public boolean colide(BossAlien bossalien) {
        Rectangle2D rectlaser = new Rectangle2D(xPos,yPos, Constants.AlienHeight, Constants.AlienWidth);
        Rectangle2D other = new Rectangle2D(bossalien.xPos,bossalien.yPos, Constants.AlienHeight, Constants.AlienWidth);
        return rectlaser.intersects(other);
    }
 
    
    public void draw(GraphicsContext g) {
        drawLaser(g);
    }
 
 
    public void update() {
        yPos -= Constants.standardLaserSpeed;


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
 
 
    

}
