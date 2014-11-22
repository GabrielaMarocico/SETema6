package marocico.se.tema6.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewWeather extends JFrame {

	JPanel panel = new JPanel(new GridBagLayout());
	GridBagConstraints grid = new GridBagConstraints();

	JLabel labelTemperature = new JLabel("Temperature");
	JLabel labelDegree = new JLabel();
	JLabel degreeIcon = new JLabel();
	JLabel labelWind = new JLabel("Wind");
	JLabel labelWindValue = new JLabel();
	JLabel labelHumidity = new JLabel("Humidity");
	JLabel labelHumidityValue = new JLabel();
	JLabel labelLocation = new JLabel("Your location :");
	JLabel labelLocationValue = new JLabel();
	JButton buttonReset = new JButton("Reset");

	Font maxFont = new Font("Courrier", Font.BOLD, 30);
	Font minFont = new Font("Courier", Font.ITALIC, 30);

	/**
	 * The constructor which creates the user interface, the panel which will be
	 * displayed
	 */
	public ViewWeather() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750, 500);
		this.setTitle("Weather information");
		this.setVisible(true);

		this.getContentPane().add(panel, BorderLayout.WEST);

		labelTemperature.setFont(maxFont);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.insets = new Insets(-180, -410, 0, 0);
		panel.add(labelTemperature, grid);

		labelDegree.setFont(minFont);
		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(-30, -1100, 0, 0);
		panel.add(labelDegree, grid);

		// showing the sign of Celsius degree
		ImageIcon image = new ImageIcon(
				"C:/Users/gby/Git/SETema6/SETema6/pictures/degree.jpg");

		if (image == null)
			System.out.println("eroare la incarcarea imaginii");

		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(-28, -1010, 0, 0);

		degreeIcon = new JLabel(image);
		panel.add(degreeIcon, grid);

		labelWind.setFont(maxFont);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.insets = new Insets(-180, 80, 0, 0);
		panel.add(labelWind, grid);

		// showing the power of wind
		labelWindValue.setFont(minFont);
		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(-30, -570, 0, 0);
		panel.add(labelWindValue, grid);

		labelHumidity.setFont(maxFont);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.insets = new Insets(-180, 530, 0, 0);
		panel.add(labelHumidity, grid);

		// showinf the values (%) of umidity
		labelHumidityValue.setFont(minFont);
		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(-30, -135, 0, 0);
		panel.add(labelHumidityValue, grid);

		// labels for Location
		labelLocation.setFont(maxFont);
		grid.gridx = 2;
		grid.gridy = 0;
		grid.insets = new Insets(180, -760, 0, 0);
		panel.add(labelLocation, grid);

		labelLocationValue.setFont(minFont);
		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(180, -345, 0, 0);
		panel.add(labelLocationValue, grid);

		// RESET button for updating the information (temperature,wind and
		// umidity)
		grid.gridx = 2;
		grid.gridy = 2;
		grid.insets = new Insets(120, -620, 0, 0);

		buttonReset.setFont(maxFont);
		panel.add(buttonReset, grid);

		this.add(panel);

	}

	/**
	 * Sets the Humidity with the value of the argument
	 * 
	 * @param humidityValue
	 *            Humidity value
	 */
	public void setHumidityValueFromLabel(int humidityValue) {
		labelHumidityValue.setText(Integer.toString(humidityValue) + "%");
	}

	/**
	 * Sets the Wind with the value of the argument
	 * 
	 * @param windValue
	 *            Wind value
	 */
	public void setWindValueFromLabel(int windValue) {
		labelWindValue.setText(Integer.toString(windValue) + "km/h");
	}

	/**
	 * Sets the Temperature with the value of the argument
	 * 
	 * @param temperatureValue
	 *            Temperature value
	 */
	public void setTemperatureValueFromLabel(int temperatureValue) {
		labelDegree.setText(Integer.toString(temperatureValue));
	}

	/**
	 * Sets the Location with the value of the argument
	 * 
	 * @param location
	 *            Location name
	 */
	public void setLocationValueFromLabel(String location) {
		labelLocationValue.setText(location);
	}

	public void addListener(ActionListener Reset) {
		buttonReset.addActionListener(Reset);
	}
}
