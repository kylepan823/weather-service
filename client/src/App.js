import React, { Component } from 'react'
import { Provider } from 'react-redux'
import { createStore, applyMiddleware } from 'redux';
import reducers from './redux/reducers';
import thunk from 'redux-thunk';
import Weather from './components/Weather';
import { Route, Switch, BrowserRouter } from 'react-router-dom';

let store = createStore(
    reducers,
    applyMiddleware(thunk));

class App extends Component {
    render() {
        return (
            <Provider store={store}>
                <BrowserRouter basename="/" onUpdate={() => window.scrollTo(0, 0)}>
                    <Switch>
                        <Route path="/" name="Weather" component={ Weather }/>
                    </Switch>
                </BrowserRouter>
            </Provider>
        )
    }
}

export default App;
