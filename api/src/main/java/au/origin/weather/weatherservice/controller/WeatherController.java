package au.origin.weather.weatherservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import au.origin.weather.weatherservice.exception.WeatherException;
import au.origin.weather.weatherservice.model.Weather;
import au.origin.weather.weatherservice.service.WeatherService;

@RestController
public class WeatherController {

  @Autowired
  private WeatherService weatherService;

  @GetMapping("/temperature/city")
  public Weather retrieveWeather() {
    try {
      Weather weather = weatherService.retrieveWeatherForAllCities();
      if (null == weather || null == weather.getCities() || weather.getCities().size() == 0) {
        throw new WeatherException("Weather not found");
      } else {
        return weather;
      }
    } catch (Exception e) {
      throw new WeatherException("Weather not found");
    }
  }
}
