package marocico.se.tema6.webservice;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebService {

	// used for HTTP connection, retrieving weather information
	private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

	// used for HTTP connection, retrieving the image
	private static String IMG_URL = "http://openweathermap.org/img/w/";

	/**
	 * Get weather information
	 * 
	 * @param location
	 *            City introduced by the user
	 * @return Weather information for that city
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

	/**
	 * Get the bytes of an image
	 */
	public byte[] getImage(String code) {

		HttpURLConnection connection = null;
		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			connection = (HttpURLConnection) (new URL(IMG_URL + code + ".png"))
					.openConnection();

			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.connect();

			// Get the response
			inputStream = connection.getInputStream();

			byte[] buffer = new byte[1024];

			while (inputStream.read(buffer) != -1)
				baos.write(buffer);

			return baos.toByteArray();

		}

		catch (Throwable error) {
			error.printStackTrace();
		}

		finally {
			try {
				inputStream.close();
			} catch (Throwable t) {
			}

			try {
				connection.disconnect();
			} catch (Throwable t) {
			}
		}
		return baos.toByteArray();
	}
}
