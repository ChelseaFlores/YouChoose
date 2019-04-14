package application.model;

import java.util.Random;

import application.controller.MainController;

public class RandomSelection extends MainController{
	
	public static int randomNumber( int min, int max) {
		Random rand = new Random();
		int number = rand.nextInt((max - min) + 1) + min;
		return number;
	}
}
