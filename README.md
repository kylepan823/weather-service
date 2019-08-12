# weather-service
A simple weather service app demo

## Server
Inside the api directory, you can run some built-in commands:

Run API: `./gradlew bootRun or gradlew.bat bootRun`

Run Unit Tests: `./gradlew test`

I create `config`, `controller`, `service`, `model` and `exception` folders in `weatherservice` folder.

1. `config` folder contains file to all request CORS

2. `controller` folder contains file to set api route, handle request and return response. It will call functions in service file.

3. `service` folder contains file to fetch json file and convert them to java object.

4. `model` folder contains all DAO classes.

5. `exception` folder contains files to handle exceptions.

6. Create unit tests for both controller and service.

## Client
Inside the client directory, you can run some built-in commands:

Install all dependencies: `npm install`

Run App: `npm start`

Run Test: `npm test`

Runs the app in development mode. Open http://localhost:3000 to view it in the browser.

1. Create Weather and City two components. Weather is parent view component which uses
City.js as child component to show all city temperature.

2. Using redux to fetch data. Create one action named `loadWeather` which calls backend api to get weather data.
If successful, trigger LOAD_WEATHER and save data in state. If failed, trigger LOAD_WEATHER_FAIL and save error.

3. Weather.js shows weather table if state has weather data. Otherwise, show cannot find data message.

4. Create unit test for Weather component, City component, weather reducer and weather actions.
