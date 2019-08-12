import { reducer } from '../redux/reducers/weather';
import * as types from '../redux/actions/weather/weather.types';

describe('Weather reducer', () => {

    it('should handle LOAD_WEATHER', () => {
        const successAction = {
            type: types.LOAD_WEATHER,
            payload: {data: {cities: [{name: 'Melbourne', temperature: '23'}]}},
        };
        expect(reducer({}, successAction).weather.cities.length).toEqual(1);
        expect(reducer({}, successAction).error).toEqual(null);
    });

    it('should handle LOAD_WEATHER_FAIL', () => {
        const failAction = {
            type: types.LOAD_WEATHER_FAIL,
            payload: {data: {status: 404, message: "Error"}}, // important to pass correct payload, that's what the tests are for ;)
        };
        expect(reducer({}, failAction).weather).toEqual(null);
        expect(reducer({}, failAction).error.status).toEqual(404);
        expect(reducer({}, failAction).error.message).toEqual("Error");
    });
});