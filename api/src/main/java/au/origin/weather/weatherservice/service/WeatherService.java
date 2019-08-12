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
  private String filePath = "static/weather-results.json";

  ObjectMapper mapper = new ObjectMapper();

  public Weather retrieveWeatherForAllCities() throws Exception {
    weather = mapper.readValue(
        new File(getClass().getClassLoader().getResource(filePath).getFile()), Weather.class);
    return weather;
  }
  
  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
}
