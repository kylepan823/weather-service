package au.origin.weather.weatherservice.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import au.origin.weather.weatherservice.model.City;
import au.origin.weather.weatherservice.model.Weather;
import au.origin.weather.weatherservice.service.WeatherService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WeatherController.class)
public class WeatherControllerTests {
  
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private WeatherService weatherService;
  List<City> mockCities = Arrays.asList(new City[] { 
      new City("Melbourne", "11"), new City("Sydney", "12"), 
      new City("Brisbane", "13")
      });
  Weather mockWeather = new Weather(mockCities);

  @Test
  public void getAllWeather_WhenGetAllCitiesWeather_thenStatus200() throws Exception {

      Mockito.when(weatherService.retrieveWeatherForAllCities()).thenReturn(mockWeather);

      RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
              "/temperature/city").accept(
              MediaType.APPLICATION_JSON);

      MvcResult result = mockMvc.perform(requestBuilder).andReturn();
      String expected = "{\"cities\":[{\"name\":\"Melbourne\",\"temperature\":\"11\"},{\"name\":\"Sydney\",\"temperature\":\"12\"},{\"name\":\"Brisbane\",\"temperature\":\"13\"}]}";
      JSONAssert.assertEquals(expected, result.getResponse()
              .getContentAsString(), false);
      Assert.assertEquals(200, result.getResponse().getStatus());
  }
  
  @Test
  public void getAllWeather_WhenApiNotFound_thenStatus404() throws Exception {

      Mockito.when(weatherService.retrieveWeatherForAllCities()).thenReturn(mockWeather);

      RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
              "/temperature/city11").accept(
              MediaType.APPLICATION_JSON);

      MvcResult result = mockMvc.perform(requestBuilder).andReturn();
      Assert.assertEquals(404, result.getResponse().getStatus());
  }
  
  @Test
  public void getAllWeather_WhenWeatherIsNull_thenStatus404() throws Exception {
    
    Weather mockWeather2 = null;
    Mockito.when(weatherService.retrieveWeatherForAllCities()).thenReturn(mockWeather2);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/temperature/city")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    Assert.assertEquals(404, result.getResponse().getStatus());
  }
  
  @Test
  public void getAllWeather_WhenCitiesIsEmpty_thenStatus404() throws Exception {
    
    Weather mockWeather3 = new Weather( Arrays.asList(new City[] {}));
    Mockito.when(weatherService.retrieveWeatherForAllCities()).thenReturn(mockWeather3);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/temperature/city")
        .accept(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    Assert.assertEquals(404, result.getResponse().getStatus());
  }
}
