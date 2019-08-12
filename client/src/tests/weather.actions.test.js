import configureMockStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import * as actions from '../redux/actions/weather/weather.actions';
import * as types from '../redux/actions/weather/weather.types';
import axios from 'axios'
import MockAdapter from 'axios-mock-adapter';

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);
const mock = new MockAdapter(axios);

describe('Weather actions', () => {

    it('creates LOAD_WEATHER when fetching weather has been done successfully', () => {
        mock.onGet('http://localhost:8080/temperature/city').reply(200, {
            body: {cities: [{name: 'Melbourne', temperature: '23'}]},
            headers: {'content-type': 'application/json'}
        });

        const store = mockStore({});

        return store.dispatch(actions.loadWeather()).then(() => {
            expect(store.getActions()[0].type).toEqual(types.LOAD_WEATHER)
        })
    });

    it('creates LOAD_WEATHER_FAIL when fetching weather has been done failed', () => {
        mock.onGet('http://localhost:8080/temperature/city').reply(404, {
                error: 'Not Found',
                message: 'No message available',
            }
        );
        const store = mockStore({});

        return store.dispatch(actions.loadWeather()).then(() => {
            expect(store.getActions()[0].type).toEqual(types.LOAD_WEATHER_FAIL)
        })
    })
})