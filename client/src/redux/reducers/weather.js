import {LOAD_WEATHER, LOAD_WEATHER_FAIL} from '../actions/weather/weather.types';

export const reducer = (state = {}, action = {}) => {
    switch (action.type) {
        case LOAD_WEATHER:
            return {
                ...state,
                weather: action.payload.data,
                error: null,
            };
        case LOAD_WEATHER_FAIL:
            if (action.payload && action.payload.data) {
                return {
                    ...state,
                    weather: null,
                    error: action.payload.data,
                };
            } else {
                return {
                    ...state,
                    weather: null,
                    error: {status: 404, message: "Cannot find weather"},
                };
            }
        default:
            return state;
    }
};