package marocico.se.tema6.model;

import java.util.Random;

public class ModelWeather {

	private int mTemperature;
	private int mUmidity;
	private int mWind;
	private String mLocation;

	public int getUmidityValue() {
		Random generateUmidity = new Random();
		mUmidity = 1 + generateUmidity.nextInt(100);
		System.out.println("umiditate:" + mUmidity);

		return mUmidity;
	}

	public int getTemperatureValue() {
		Random generateTemperature = new Random();
		mTemperature = 1 + generateTemperature.nextInt(40);
		System.out.println("temp:" + mTemperature);

		return mTemperature;
	}

	public int getWindValue() {
		Random generateWind = new Random();
		mWind = 1 + generateWind.nextInt(100);
		System.out.println("vant:" + mWind);

		return mWind;
	}

	public String getLocation() {

		String[] locations = { "Constanta", "Bucharest", "Iasi", "Sibiu",
				"Cluj-Napoca", "Timisoara", "Brasov" };

		int position = new Random().nextInt(locations.length);
		mLocation = (locations[position]);
		System.out.println("LOCATIA:" + mLocation);
		return mLocation;
	}
}
