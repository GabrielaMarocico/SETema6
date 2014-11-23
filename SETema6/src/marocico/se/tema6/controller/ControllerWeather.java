package marocico.se.tema6.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import marocico.se.tema6.model.ModelWeather;
import marocico.se.tema6.view.ViewWeather;

import org.json.JSONException;

/**
 * 
 * @author gby
 * 
 *         The Controller class which will interact with both the Model and View
 *         classes
 * 
 */
public class ControllerWeather {

	// The Controller needs to interact with both the Model and View
	private ViewWeather mViewWeather;
	private ModelWeather mModelWeather;

	/**
	 * The constructor which initializes the members of ControllerWeather Class
	 * with the arguments, but also
	 * 
	 * @param view
	 *            The view component
	 * @param model
	 *            The model component
	 */
	public ControllerWeather(ViewWeather view, ModelWeather model) {

		this.mViewWeather = view;
		this.mModelWeather = model;

		this.mViewWeather.addListener(new ListenerWeather());
	}

	class ListenerWeather implements ActionListener {

		/**
		 * When RESET button is pressed, the View is initialized with values
		 * from Model
		 */
		public void actionPerformed(ActionEvent event) {

			// get from View the city introduced by the user
			String location = mViewWeather.getLocationValueFromLabel();

			try {
				mModelWeather.setWeatherInfo(location);
			} catch (JSONException e) {
				e.printStackTrace();
			}

			// set the value for temperature
			mViewWeather.setTemperatureValueFromLabel(mModelWeather
					.getTemperatureValue());

			// set the value for humidity
			mViewWeather.setHumidityValueFromLabel(mModelWeather
					.getHumidityValue());

			// set the value for wind
			mViewWeather.setWindValueFromLabel(mModelWeather.getWindValue());

			// set the icon
			mViewWeather.setIconWeather(mModelWeather.getIconWeather());

		}
	}

}