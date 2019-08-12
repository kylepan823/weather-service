import { combineReducers } from 'redux';
import * as weather from './weather';

const rootReducer = combineReducers({
    weather: weather.reducer,
});

export default rootReducer;
