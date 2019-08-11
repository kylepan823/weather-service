import axios from 'axios';
import { API_ENDPOINT } from '../../../env';
import * as WeatherTypes from "./weather.types";

export const loadWeather = () =>
    (dispatch) => axios.get(`${API_ENDPOINT}/temperature/city`).then((res) =>
        dispatch(asyncThunk(WeatherTypes.LOAD_WEATHER, res)))
        .catch((err) => {
            return dispatch(asyncThunk(WeatherTypes.LOAD_WEATHER_FAIL, err.response))});

const asyncThunk = (type, payload) => ({ type, payload });