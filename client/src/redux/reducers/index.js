import { combineReducers } from 'redux';
import * as weather from '../modules/weather';

const rootReducer = combineReducers({
    weather: weather.reducer,
});

export default rootReducer;
