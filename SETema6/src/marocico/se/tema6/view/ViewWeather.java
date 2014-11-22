package marocico.se.tema6.view;

import java.awt.BorderLayout;
import java.awt.Color;
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
	JLabel labelLocation = new JLabel("Your country :");
	JTextField fieldLocationValue = new JTextField("", 15);
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

		// labels for Location
		labelLocation.setFont(maxFont);
		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(-180, -910, 0, 0);
		panel.add(labelLocation, grid);

		fieldLocationValue.setFont(minFont);
		fieldLocationValue.setHorizontalAlignment(JTextField.CENTER);
		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(-180, -415, 0, 0);
		panel.add(fieldLocationValue, grid);

		// labels for Temperature
		labelTemperature.setFont(maxFont);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.insets = new Insets(-30, -410, 0, 0);
		panel.add(labelTemperature, grid);

		labelDegree.setFont(minFont);
		grid.gridx = 2;
		grid.gridy = 0;
		grid.insets = new Insets(120, -1100, 0, 0);
		panel.add(labelDegree, grid);

		// showing the sign of Celsius degree
		ImageIcon image = new ImageIcon(
				"C:/Users/gby/Git/SETema6/SETema6/pictures/degree.jpg");

		if (image == null)
			System.out.println("eroare la incarcarea imaginii");

		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(122, -1010, 0, 0);

		degreeIcon = new JLabel(image);
		panel.add(degreeIcon, grid);

		// labels for Wind
		labelWind.setFont(maxFont);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.insets = new Insets(-30, 80, 0, 0);
		panel.add(labelWind, grid);

		labelWindValue.setFont(minFont);
		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(120, -570, 0, 0);
		panel.add(labelWindValue, grid);

		// labels for Humidity
		labelHumidity.setFont(maxFont);
		grid.gridx = 0;
		grid.gridy = 0;
		grid.insets = new Insets(-30, 530, 0, 0);
		panel.add(labelHumidity, grid);

		// showinf the values (%) of umidity
		labelHumidityValue.setFont(minFont);
		grid.gridx = 1;
		grid.gridy = 0;
		grid.insets = new Insets(120, -135, 0, 0);
		panel.add(labelHumidityValue, grid);

		// RESET button for updating the information (temperature,wind and
		// umidity)
		grid.gridx = 2;
		grid.gridy = 2;
		grid.insets = new Insets(60, -620, 0, 0);

		buttonReset.setFont(maxFont);
		buttonReset.setBackground(Color.lightGray);
		panel.add(buttonReset, grid);

		this.add(panel);

	}

	/**
	 * Sets the Humidity with the value of the argument
	 * 
	 * @param humidityValue
	 *            Humidity value
	 */
	public void setHumidityValueFromLabel(double humidityValue) {
		labelHumidityValue.setText("" + humidityValue + "%");
	}

	/**
	 * Sets the Wind with the value of the argument
	 * 
	 * @param windValue
	 *            Wind value
	 */
	public void setWindValueFromLabel(double windValue) {
		labelWindValue.setText("" + windValue + "m/s");
	}

	/**
	 * Sets the Temperature with the value of the argument
	 * 
	 * @param temperatureValue
	 *            Temperature value
	 */
	public void setTemperatureValueFromLabel(double temperatureValue) {
		// Convert from Kelvin to Celsius
		temperatureValue = temperatureValue - 273.15;
		labelDegree.setText("" + (int) temperatureValue);
	}

	/**
	 * Sets the Location with the value of the argument
	 * 
	 * @param location
	 *            Location name
	 */
	public void setLocationValueFromLabel(String location) {
		fieldLocationValue.setText(location);
	}

	/**
	 * Return the location/country introduced by the user in JTextField
	 */
	public String getLocationValueFromLabel() {
		return fieldLocationValue.getText();
	}

	public void addListener(ActionListener Reset) {
		buttonReset.addActionListener(Reset);
	}
}
