package au.origin.weather.weatherservice.model;

public class City {
  private String name;
  private String temperature;
  
  public City() {
    
  }
  
  public City(String name, String temperature) {
    super();
    this.name = name;
    this.temperature = temperature;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }
}
