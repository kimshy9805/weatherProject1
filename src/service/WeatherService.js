import axios from 'axios';

const WEATHER_REST_API_URL = 'http://localhost:8080/api/v1/owm/retrieve/1838524';

class WeatherService {

    retrieveWeatherData() {
        return axios.get(WEATHER_REST_API_URL);
    }

}

export default new WeatherService();

