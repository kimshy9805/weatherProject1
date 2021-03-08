import React, { Component, useState, useEffect } from "react";
import styled from "styled-components";
import axios from "axios";
import { Forecast } from "../forecast";
import { Basic1 } from "../basic1/index";
import { Basic2 } from "../basic2/index";
import { Basic3 } from "../basic3/index";

import Sun from "../../assets/illustrations/forecasts/Sun_64px_3.png";
import Cloud from "../../assets/illustrations/forecasts/Cloud_64px.png";
import Rain from "../../assets/illustrations/forecasts/Rain_64px_1.png";
import Snow from "../../assets/illustrations/forecasts/Snow_64px.png";

import SunLarge from "../../assets/illustrations/forecasts/Sun_100px.png";
import CloudLarge from "../../assets/illustrations/forecasts/Cloud_100px.png";
import RainLarge from "../../assets/illustrations/forecasts/Rain_100px.png";
import SnowLarge from "../../assets/illustrations/forecasts/Snow_100px.png";

import Wind from "../../assets/illustrations/phwIcons/Wind Speed 98-102_44px.png";
import Humidity from "../../assets/illustrations/phwIcons/Humidity_44px.png";
import Pressure from "../../assets/illustrations/phwIcons/Atmospheric Pressure-44 (1).png";

import Thermomoter from "../../assets/illustrations/rest/Thermometer-64.png";

//로고 색상은 연파랑

const WEATHER_REST_API_URL = "http://localhost:8080/api/v1/owm/retrieve/";

const ServiceContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 100%;
`;

const UpperConatiner = styled.div`
  width: 100%;
  height: 60%;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
`;

const LowerContainer = styled.div`
  width: 100%;
  height: 40%;
  display: flex;
  flex-direction: row;
  align-items: center;
`;

const Basic1InfoContainer = styled.div`
  max-width: 33%;
  width: 450px;
  height: 350px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const Basic2InfoContainer = styled.div`
  max-width: 33%;
  width: 450px;
  height: 350px;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const Basic3InfoContainer = styled.div`
  max-width: 33%;
  width: 450px;
  height: 350px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
`;

const WeatherForecastContainer = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  width: 75%;
  height: 100%;
  align-items: center;
`;

const CurrentWeatherContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 25%;
  height: 100%;
  align-items: center;
`;

const TodayTemp = styled.h1`
  color: #fff;
  font-size: 50px;
  font-weight: regular;
`;

const TodayInfo = styled.p`
  color: #fff;
  font-size: 20px;
`;

export function OurService(props) {
  const [weatherInfo, setWeatherInfo] = useState([]);

  const fetchWeatherData = () => {
    console.log(props.city);
    console.log(props.city.city.selectedCity);
    axios
      .get(WEATHER_REST_API_URL + props.city.city.selectedCity)
      .then((res) => setWeatherInfo(res.data));
  };

  //can have multiple useEffect
  //버튼이 눌릴때마다 useEffect 호출하는방법은 []안에다가 뭐 넣으면됨.
  //refresh개념도 될듯. refresh button눌르면 [weatherInfo] 넣어서 useEffect
  //Context is React’s way of handling shared data between multiple components.
  //skipping effects (array dependency [])
  //the effect function will be called only on mount.
  useEffect(() => {
    fetchWeatherData();
    SelectMainImg();
  }, []);

  const [today, setToday] = useState(new Date());

  useEffect(() => {
    const timer = setInterval(() => {
      setToday(new Date());
    }, 1000);
    return () => {
      clearInterval(timer);
    };
  }, []);

  const [mainImg, setMainImg] = useState(SunLarge);

  //state update 안됨
  const SelectMainImg = () => {
    weatherInfo.map((weather) => {
      weather.map((item) => {
        switch (item.main) {
          case "Clear":
            setMainImg(SnowLarge);
            break;
          case "Rain":
            setMainImg(RainLarge);
            break;
          case "Snow":
            setMainImg(SnowLarge);
            break;
          case "Clouds":
            setMainImg(CloudLarge);
            break;
          default:
            setMainImg(SunLarge);
            break;
        }
      });
    });
  };

  return weatherInfo.map((weather, index) => {
    return (
      <div key={index}>
        <ServiceContainer>
          <UpperConatiner>
            <Basic1InfoContainer>
              <Basic1
                isPressure="isPressure"
                imgUrl={Pressure}
                type="Pressure"
                value={weather.main.pressure}
                unit="mbar"
              />
              <Basic1
                imgUrl={Humidity}
                type="Humidity"
                value={weather.main.humidity}
                unit="%"
              />
              <Basic1
                imgUrl={Wind}
                type="Wind"
                value={weather.wind.speed}
                unit="m/s"
              />
            </Basic1InfoContainer>
            <Basic2InfoContainer>
              {weather.weather.map((item, i) => {
                return (
                  <div key={i}>
                    <Basic2
                      imgUrl={mainImg}
                      weatherState={item.description}
                      city={weather.name}
                    />
                  </div>
                );
              })}
            </Basic2InfoContainer>
            <Basic3InfoContainer>
              <Basic3
                tempType="Min.Temp"
                temp={weather.main.temp_min}
                imgUrl={Thermomoter}
              />
              <Basic3
                tempType="Max.Temp"
                temp={weather.main.temp_max}
                imgUrl={Thermomoter}
              />
            </Basic3InfoContainer>
          </UpperConatiner>
          <LowerContainer>
            <CurrentWeatherContainer>
              <TodayTemp>{weather.main.temp}&deg;C</TodayTemp>
              <TodayInfo>{today.toLocaleTimeString()}</TodayInfo>
            </CurrentWeatherContainer>
            <WeatherForecastContainer>
              <Forecast temp="25" day="MON" imgUrl={Sun} />
              <Forecast temp="25" day="TUE" imgUrl={Sun} />
              <Forecast temp="25" day="WED" imgUrl={Sun} />
              <Forecast temp="25" day="THU" imgUrl={Sun} />
              <Forecast temp="25" day="FRI" imgUrl={Sun} />
              <Forecast temp="25" day="SAT" imgUrl={Snow} />
              <Forecast temp="25" day="SUN" imgUrl={Rain} />
            </WeatherForecastContainer>
          </LowerContainer>
        </ServiceContainer>
      </div>
    );
  });
}

//<div className="contents">
//           {/* Coordinate */}
//           <section className="coord">
//             <div className="coordInfo">
//               <h2>coordinate</h2>
//               <p>lat: {weather.coord.lat}</p>
//               <p>lon: {weather.coord.lon}</p>
//             </div>

// //state initialization인듯
//   //add local state into this component
//   //useState argument: initial state
//   const [weatherInfo, setWeatherInfo] = useState([]);

//   const fetchWeatherData = () => {
//     axios.get("http://localhost:8080/api/v1/owm/retrieve/Busan").then((res) => {
//       //setting state
//       //내감이 맞다면 res.data는 list라서 useState에서 []로 initial로 state해야함.
//       setWeatherInfo(res.data);
//     });
//   };
//   //component did mount 랑 비슷
//   //[] 리스트에 변화가 생기면 useEffect가 다시 trigger
//   useEffect(() => {
//     fetchWeatherData();
//   }, []);

//   return weatherInfo.map((weather, index) => {
//     return (
//       <ServiceContainer>
//         <SectionTitle name={weather.name}></SectionTitle>
//       </ServiceContainer>
//     );
//   });
