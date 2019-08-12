import React, {Component} from 'react';
import {connect} from 'react-redux';
import { bindActionCreators } from "redux";
import { loadWeather } from '../redux/actions/weather/weather.actions';
import {Container, Row, Col, Table} from 'reactstrap';
import City from "./City";

export class Weather extends Component {

    componentDidMount() {
        this.props.loadWeather()
    }

    render() {
        if(!this.props.weatherError && this.props.weather) {
            return <Container className='weather-view'>
                <Row>
                    <Col md={2}></Col>
                    <Col xs={12} md={8}>
                        <Row className="my-2">
                            <Col className="d-flex justify-content-center align-items-center">
                                <h3>Australian City Weather Table</h3>
                            </Col>
                        </Row>
                        <Table striped bordered hover className='weather-table'>
                             <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Temperature</th>
                                </tr>
                            </thead>
                            <tbody>
                            {this.renderWeatherTable(this.props.weather)}
                            </tbody>
                        </Table>
                    </Col>
                    <Col md={2}></Col>
                </Row>
            </Container>
        } else {
            return <Container className='no-data'>
                <Row>
                    <Col md={2}></Col>
                    <Col xs={12} md={8}>
                        <Row className="my-2">
                            <Col className="d-flex justify-content-center align-items-center">
                                <h3>Cannot find any data</h3>
                            </Col>
                        </Row>
                    </Col>
                    <Col md={2}></Col>
                </Row>
            </Container>
        }
    }

    renderWeatherTable(weatherData) {
        if(weatherData && weatherData.cities && weatherData.cities.length) {
            return weatherData.cities.map((city, index) => {
                return <City city={city} key={index}/>
            });
        }
        return null
    }
}

const mapStateToProps = state => ({
    weather: state.weather.weather,
    weatherError: state.weather.error,
});


const mapDispatchToProps = dispatch => bindActionCreators({
    loadWeather,
}, dispatch);

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(Weather)