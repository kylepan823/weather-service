import React from 'react';
import { shallow, dive } from 'enzyme';
import { Weather } from '../components/Weather';
import sinon from 'sinon'

describe('Weather Component', () => {
    let wrapper, loadWeather;

    it('should render component without table when weatherError exists', () => {
        const props = {
            loadWeather: () => {},
            weather: null,
            weatherError: {status: 404, message: 'test error'}
        };
        loadWeather = sinon.stub(props, 'loadWeather');
        wrapper = shallow(<Weather {...props}/>).dive();
        expect(loadWeather.calledOnce).toBe(true);
        expect(wrapper).not.toBe(null);
        expect(wrapper.find('.no-data').length).toEqual(1);
    });

    it('should render component with weather table when weather exists', () => {
        const mockWeather = {
            cities: [
                {
                    name: 'Melbourne',
                    temperature: '24'
                },
                {
                    name: 'Sydney',
                    temperature: '10'
                }
            ]
        };
        const props = {
            loadWeather: () => {},
            weather: mockWeather,
            weatherError: null,
        };
        loadWeather = sinon.stub(props, 'loadWeather');
        wrapper = shallow(<Weather {...props}/>).dive();
        expect(loadWeather.calledOnce).toBe(true);
        expect(wrapper).not.toBe(null);
        expect(wrapper.find('.weather-view').length).toEqual(1);
        expect(wrapper.find('City').length).toEqual(2);
    });
});
