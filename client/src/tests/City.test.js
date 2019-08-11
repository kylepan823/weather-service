import React from 'react';
import { shallow } from 'enzyme';
import City from '../components/City';

describe('City Component', () => {
    let wrapper;
    it('should render city component when city exist', () => {
        const city = {
            name: 'Melbourne',
            temperature: '24'
        };
        wrapper = shallow(<City city={city}/>);
        expect(wrapper.find('.city-row').length).toEqual(1);
        expect(wrapper.find('.city-name').length).toEqual(1);
        expect(wrapper.find('.city-temperature').length).toEqual(1);
    });

    it('should render empty component when city doesn\'t exist', () => {
        const city = null
        wrapper = shallow(<City city={city}/>);
        expect(wrapper.find('.city-row').length).toEqual(0);
    });
});
