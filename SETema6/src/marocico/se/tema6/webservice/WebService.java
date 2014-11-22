package marocico.se.tema6.webservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebService {

	static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

	/**
	 * The constructor
	 */
	public String getWeatherInfo(String location) {

		InputStreamReader inputStreamReader = null;
		HttpURLConnection connection = null;

		StringBuffer weatherInfo = new StringBuffer();

		try {

			connection = (HttpURLConnection) (new URL(WEATHER_URL + location))
					.openConnection();

			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			connection.setDoOutput(true);

			connection.connect();

			// Get the response
			inputStreamReader = new InputStreamReader(
					connection.getInputStream());

			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String line = null;

			// Put the response into a BufferedReader variable, line by line
			while ((line = bufferedReader.readLine()) != null) {
				weatherInfo.append(line + "\r\n");
			}

			bufferedReader.close();
			inputStreamReader.close();
			connection.disconnect();

		} catch (Throwable error) {
			error.printStackTrace();
		} finally {
			try {
				inputStreamReader.close();
			} catch (Throwable error) {
			}
			try {
				connection.disconnect();
			} catch (Throwable t) {
			}
		}

		return weatherInfo.toString();
	}
}
