package logics;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.paint.Color;

public class MyColor extends Model {

	private ArrayList<Color> selectColor = new ArrayList<Color>();
	
	public MyColor(ArrayList<Color> selectColor) {
		this.selectColor = selectColor;
		
	}
	
	public ArrayList<Color> add(Color color) {
		return selectColor;
	}


}
