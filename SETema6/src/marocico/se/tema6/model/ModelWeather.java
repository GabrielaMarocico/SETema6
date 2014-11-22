package marocico.se.tema6.model;

import java.util.Random;

import org.json.JSONException;
import org.json.JSONObject;

import marocico.se.tema6.exception.FormatException;
import marocico.se.tema6.webservice.WebService;

/**
 * 
 * @author gby
 * 
 *         This class implements functions which returns values needed by
 *         Controller Class to fill the View
 * 
 */
public class ModelWeather {

	private static final String String = null;
	/**
	 * Member variables used by Controller to display the values of Temperature,
	 * Humidity, Wind and Location
	 */
	private double mTemperature;
	private double mHumidity;
	private double mWind;
	private String mLocation;

	WebService service = new WebService();

	public void setHumidityValue(double humidity) throws FormatException {
		mHumidity = humidity;
	}

	/**
	 * Return Humidity value
	 */
	public double getHumidityValue() {
		return mHumidity;
	}

	public void setTemperatureValue(double temperature) {
		mTemperature = temperature;
	}

	/**
	 * Return Temperature value
	 * 
	 * @throws JSONException
	 */
	public double getTemperatureValue() {
		return mTemperature;
	}

	public void setWindValue(Double wind) {
		mWind = wind;
	}

	/**
	 * Return Wind value
	 */
	public double getWindValue() {
		return mWind;
	}

	/**
	 * 
	 * @throws FormatException
	 *             A messageError is displayed where an error is caught using
	 *             FormatException class
	 */
	public void setLocation(String location) {
		mLocation = location;
	}

	/**
	 * Return Location value
	 */
	public String getLocation() throws FormatException {
		return mLocation;
	}

	/**
	 * 
	 * Parse the json content and modify values for temperature,humidity and
	 * wind.
	 * 
	 * @param location
	 *            Country from where data is extracted
	 * 
	 */
	public void setWeatherInfo(String location) throws JSONException {

		String weatherInfo = service.getWeatherInfo(location);

		JSONObject jsonObject = new JSONObject(weatherInfo);

		JSONObject jSONObject_main = jsonObject.getJSONObject("main");
		double temperature = jSONObject_main.getDouble("temp");
		double humidity = jSONObject_main.getDouble("humidity");

		JSONObject jSONObject_wind = jsonObject.getJSONObject("wind");
		double wind = jSONObject_wind.getDouble("speed");

		mHumidity = humidity;
		mTemperature = temperature;
		mWind = wind;

	}
}
