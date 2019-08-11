package au.origin.weather.weatherservice.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WeatherException extends RuntimeException {
  static final Logger logger = LogManager.getLogger(WeatherException.class);

  public WeatherException(String message) {
    super(message);
    logger.info(message);
  }
}
