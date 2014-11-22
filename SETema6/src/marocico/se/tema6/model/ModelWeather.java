package marocico.se.tema6.model;

import java.util.Random;

import marocico.se.tema6.exception.FormatException;

/**
 * 
 * @author gby
 * 
 *         This class implements functions which returns values needed by
 *         Controller Class to fill the View
 * 
 */
public class ModelWeather {

	/**
	 * Member variables used by Controller to display the values of Temperature,
	 * Humidity, Wind and Location
	 */
	private int mTemperature;
	private int mHumidity;
	private int mWind;
	private String mLocation;

	/**
	 * Return Humidity value
	 */
	public int getHumidityValue() {
		Random generateHumidity = new Random();
		mHumidity = 1 + generateHumidity.nextInt(100);

		return mHumidity;
	}

	/**
	 * Return Temperature value
	 */
	public int getTemperatureValue() {
		Random generateTemperature = new Random();
		mTemperature = 1 + generateTemperature.nextInt(40);

		return mTemperature;
	}

	/**
	 * Return Wind value
	 */
	public int getWindValue() {
		Random generateWind = new Random();
		mWind = 1 + generateWind.nextInt(100);

		return mWind;
	}

	/**
	 * 
	 * @throws FormatException
	 *             A messageError is displayed where an error is caught using
	 *             FormatException class
	 */
	public void setLocation() throws FormatException {
		String[] locations = { "Constanta", "Bucharest", "Iasi", "Sibiu",
				"Cluj-Napoca", "Timisoara", "Brasov" };

		int position = -1;

		try {
			position = new Random().nextInt(locations.length);
			mLocation = (locations[position]);
		} catch (Exception e) {
			throw new FormatException(locations[position], e.getMessage());
		}
	}

	/**
	 * Return Location value
	 */
	public String getLocation() throws FormatException {
		setLocation();
		return mLocation;
	}
}
