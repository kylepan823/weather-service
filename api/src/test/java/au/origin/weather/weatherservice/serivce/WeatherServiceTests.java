package au.origin.weather.weatherservice.serivce;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.origin.weather.weatherservice.exception.WeatherException;
import au.origin.weather.weatherservice.model.City;
import au.origin.weather.weatherservice.model.Weather;
import au.origin.weather.weatherservice.service.WeatherService;

public class WeatherServiceTests {
  private static Weather weather = new Weather();

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
