package marocico.se.tema6.main;

import marocico.se.tema6.controller.ControllerWeather;
import marocico.se.tema6.model.ModelWeather;
import marocico.se.tema6.view.ViewWeather;

/**
 * 
 * @author gby
 * 
 *         This is the Main Class that represents the entry point to the project
 * 
 */
public class Main {

	public static void main(String[] args) {

		// Instantiate the MVC elements
		ViewWeather view = new ViewWeather();
		ModelWeather model = new ModelWeather();

		// Tell the controller about the model and the view
		ControllerWeather controller = new ControllerWeather(view, model);

		// Display the view
		view.setVisible(true);
	}
}
