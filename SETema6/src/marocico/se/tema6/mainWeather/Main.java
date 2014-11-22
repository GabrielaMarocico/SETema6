package marocico.se.tema6.mainWeather;

import java.io.IOException;

import marocico.se.tema6.controller.ControllerWeather;
import marocico.se.tema6.model.ModelWeather;
import marocico.se.tema6.view.ViewWeather;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		ViewWeather view=new ViewWeather();
		ModelWeather model=new ModelWeather();
		ControllerWeather controller=new ControllerWeather(view, model);
		
		view.setVisible(true);
	}
}
