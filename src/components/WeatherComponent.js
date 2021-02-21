import React from 'react';
import WeatherService from '../service/WeatherService';


class WeatherComponent extends React.Component {


    constructor(props) {
        super(props)
        this.state = {
            weathers:[]
        }
    }

    componentDidMount() {
        WeatherService.retrieveWeatherData().then((response) => {
            this.setState({weathers: response.data})
        });
    }

    render () {
        return  (
            <div>
                <h1 className = "text-center">Weather Lists</h1>                
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> WeatherInfo base</td>
                            <td> WeatherInfo visibility</td>
                            <td> WeatherInfo name</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.weathers.map(
                                weathers => 
                                <tr key = {weathers.id}>
                                    <td> {weathers.base}</td>
                                    <td> {weathers.visibility}</td>
                                    <td> {weathers.name}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>



            </div>
        )
    }


}


export default WeatherComponent



