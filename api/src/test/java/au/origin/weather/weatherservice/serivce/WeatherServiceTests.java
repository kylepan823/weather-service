package au.origin.weather.weatherservice.serivce;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import au.origin.weather.weatherservice.model.City;
import au.origin.weather.weatherservice.model.Weather;
import au.origin.weather.weatherservice.service.WeatherService;

public class WeatherServiceTests {

  @InjectMocks
  private WeatherService weatherService;  
  
  @Before
  public void init() {
      MockitoAnnotations.initMocks(this);
  }

  @Test
  public void whenWeatherFileExists_thenGetWeatherObject() throws Exception {
    Weather weather = weatherService.retrieveWeatherForAllCities();
    List<City> cities = weather.getCities();
    Assert.assertEquals("Melbourne", cities.get(0).getName());
    Assert.assertEquals("15", cities.get(0).getTemperature());
  }
  
  @Test(expected = Exception.class)
  public void whenWeatherFileInexisting_thenGetException() throws Exception {
    weatherService.setFilePath("/testFile.json");
    Weather weather = weatherService.retrieveWeatherForAllCities();
  }
}
