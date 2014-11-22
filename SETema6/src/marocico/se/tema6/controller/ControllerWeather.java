package marocico.se.tema6.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import marocico.se.tema6.model.ModelWeather;
import marocico.se.tema6.view.ViewWeather;

public class ControllerWeather {
	private ViewWeather mViewWeather;
	private ModelWeather mModelWeather;

	public ControllerWeather(ViewWeather view, ModelWeather model) {
		// TODO Auto-generated constructor stub

		this.mViewWeather = view;
		this.mModelWeather = model;

		this.mViewWeather.addListener(new ListenerWeather());
	}

	class ListenerWeather implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			mViewWeather.setTemperatureValueFromLabel(mModelWeather
					.getTemperatureValue());
			mViewWeather.setUmidityValueFromLabel(mModelWeather
					.getUmidityValue());
			mViewWeather.setWindValueFromLabel(mModelWeather.getWindValue());
			mViewWeather.setLocationValueFromLabel(mModelWeather.getLocation());

		}
	}

}