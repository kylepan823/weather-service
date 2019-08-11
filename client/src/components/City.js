import React, {Component} from 'react';

class City extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        if (this.props.city) {
            return <tr className="city-row small">
                <td className="city-name">
                    {this.props.city.name}
                </td>
                <td className="city-temperature">
                    {this.props.city.temperature}
                </td>
            </tr>
        }
        return null;
    }
}

export default City;