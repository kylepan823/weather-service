package au.origin.weather.weatherservice.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.origin.weather.weatherservice.exception.WeatherException;
import au.origin.weather.weatherservice.model.Weather;

@Component
public class WeatherService {
  private static Weather weather = new Weather();
  ObjectMapper mapper = new ObjectMapper();

  public Weather retrieveWeatherForAllCities() throws Exception {
    weather = mapper.readValue(
        new File(getClass().getClassLoader().getResource("static/weather-results.json").getFile()), Weather.class);
    return weather;
  }
}
