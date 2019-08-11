package au.origin.weather.weatherservice.model;

import java.util.List;

public class Weather {
  private List<City> cities;

  public Weather() {

  }

  public Weather(List<City> cities) {
    super();
    this.cities = cities;
  }

  public List<City> getCities() {
    return cities;
  }

  public void setCities(List<City> cities) {
    this.cities = cities;
  }
}
