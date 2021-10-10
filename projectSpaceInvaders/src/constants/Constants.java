package constants;

import javafx.geometry.Dimension2D;

public interface Constants {

    //Lasers & Projectiles
    int standardLaserId = 1;
    int standardLaserDamage = 1;
    int standardLaserWidth = 20;
    int standardLaserHeight = 32;
    String standardLaserImg = "";
    int powerLaserId = 2;
    int powerLaserDamage = 2;
    int powerLaserWidth = 20;
    int powerLaserHeight = 32;
    String powerLaserImg = "";
    int alienProjectileId = 3;
    int alienProjectileDamage = 1;
    int alienProjectileWidth = -40;
    int alienProjectileHeight = -40;
    String alienProjectileImg = "";

    //Aliens
    int standardAlienWidth = 50;
    int standardAlienHeight = 50;
    int standardAlienHealth = 1;
    String standardAlienImg = "";
    int bossAlienWidth = 75;
    int bossAlienHeigth = 75;
    int bossAlienHealth = 20;
    String bossAlienImg = "";
    int alienHorizontal = 4;
    int alienVertical = 10;
    int alienModifiedMovement = 25;

    //Player
    int playerWidth = 200;
    int playerHeight = 100;
    int playerSpeed = 5;
    int playerPowerSpeed = 10;
    int playerPosY = 650;
    int playerPosX = 400;
    String playerImg = "";

    //Direction Id:s
    public void moveleft();
    public void moveRight();
    int directionDown = 1;
    int directionLeft = 2;
    int directionRight = 3;

    //SCREEN
	int screen_width = 800;
	int screen_height = 800;
	String space_image = "src/Space.png";
	String menu_bg = "src/MenuBackground.png";
	
	// PLAYER
	 int player_width = 100;
	 int player_height = 100;
	 int player_speed = 5;
	 String player_image = "src/Tegnell.png";

}



