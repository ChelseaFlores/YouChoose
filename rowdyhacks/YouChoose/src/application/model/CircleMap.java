package application.model;

import java.util.LinkedHashMap;

import javafx.scene.shape.Circle;

public class CircleMap {
	
	LinkedHashMap<Circle, String> map;
	
	public CircleMap()
	{
		this.map = new LinkedHashMap<Circle,String>();
	}

	public LinkedHashMap<Circle, String> getMap() {
		return map;
	}

	public void setMap(LinkedHashMap<Circle, String> map) {
		this.map = map;
	}

}
