import React from 'react';
import { shallow, mount, dive } from 'enzyme';
import configureStore from 'redux-mock-store';
import Weather from '../components/Weather';

describe('Weather Component', () => {
    const mockStore = configureStore();
    let wrapper, store;

        it('should render component without table when weather doesn\'t exist', () => {
            const initialState = {
                weather: {
                    weather: null,
                    error: {status: 404, message: 'test error'}
                }
            };
            store = mockStore(initialState);
            wrapper = shallow(<Weather store={store}/>).dive();
            expect(wrapper).not.toBe(null);
        });

    it('should render component when weather doesn\'t exist', () => {
        const initialState = {
            weather: {
                weather: {
                    cities:[
                        {
                            name: 'Melbourne',
                            temperature: '24'
                        },
                        {
                            name: 'Sydney',
                            temperature: '10'
                        }
                    ]
                },
                error: null
            }
        };
        store = mockStore(initialState);
        wrapper = shallow(<Weather store={store}/>).dive();
        expect(wrapper).not.toBe(null);
    });
});
