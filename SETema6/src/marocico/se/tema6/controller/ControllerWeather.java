package marocico.se.tema6.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONException;

import marocico.se.tema6.exception.FormatException;
import marocico.se.tema6.model.ModelWeather;
import marocico.se.tema6.view.ViewWeather;

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

			String location = mViewWeather.getLocationValueFromLabel();

			try {
				mModelWeather.setWeatherInfo(location);
			} catch (JSONException e) {
				e.printStackTrace();
			}

			mViewWeather.setTemperatureValueFromLabel(mModelWeather
					.getTemperatureValue());

			mViewWeather.setHumidityValueFromLabel(mModelWeather
					.getHumidityValue());

			mViewWeather.setWindValueFromLabel(mModelWeather.getWindValue());

		}
	}

}