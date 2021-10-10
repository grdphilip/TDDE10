//Denna klass amvänds för att skapa rutan på skärmen som spelet utspelar sig på
//denna avgör storleken och startar draw-funktionen som används i alla klasser

package main;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import states.GameModel;

public class GameFrame extends Canvas {

	public GameFrame() {
		this.setHeight(1280);
		this.setWidth(800);
		this.setStyle("-fx-background-color: #000000;");

	}

	public void draw(KeyEvent event, GameModel model) {

	}

}
