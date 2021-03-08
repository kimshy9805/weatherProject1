import React, { Component, useState, useEffect } from "react";
import axios from "axios";
import styled from "styled-components";
import BackGroundImg from "../../assets/background/background.png";
import { Logo } from "../../components/logo/index";
import { Marginer } from "../../components/marginer/index";
import { Button } from "../../components/button/index";
import { Navbar } from "../../components/navbar/index";
import { Link } from "react-router-dom";

const WEATHER_REST_API_URL = "http://localhost:8080/api/v1/weather/country";

const FrontSectionContainer = styled.div`
  width: 100%;
  height: 100vh;
  background-image: url(${BackGroundImg});
  padding: 0;
  position: relative;
  background-size: cover;
`;

const BackGroundFilter = styled.div`
  width: 100%;
  height: 100%;
  background-color: rgba(53, 53, 53, 0.5);
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const MotivationalText = styled.h1`
  color: #fff;
  margin: 0;
  font-size: 33px;
  font-weight: regular;
  line-height: 1.5;
`;

export function FrontSection(props) {
  const [countryInfo, setCountryInfo] = useState([]);
  const [selectedCountry, setSelectedCountry] = useState("empty");
  const [cityInfo, setCityInfo] = useState([]);
  const [selectedCity, setSelectedCity] = useState("empty");

  //cannot use object in jsx
  const fetchCountryData = () => {
    axios
      .get(WEATHER_REST_API_URL)
      .then((res) => setCountryInfo(res.data.country));
  };

  const fetchCityData = () => {
    axios
      .get(WEATHER_REST_API_URL + "/" + selectedCountry)
      .then((res) => setCityInfo(res.data));
  };

  useEffect(() => {
    fetchCountryData();
  }, []); // An empty array means the callback will only execute once

  useEffect(() => {
    // if (selectedCountry !== "empty") {
    //   console.log({ selectedCountry });
    //   fetchCityData();
    // }
    console.log({ selectedCountry });
    fetchCityData();
  }, [selectedCountry]);

  return (
    <FrontSectionContainer>
      <BackGroundFilter>
        <Navbar />
        <Marginer direction="vertical" margin="7em" />
        <Logo />
        <Marginer direction="vertical" margin="3em" />
        <MotivationalText>Find Weather Information</MotivationalText>
        <MotivationalText>Select your location right below</MotivationalText>
        <Marginer direction="vertical" margin="2em" />
        <select
          onChange={(e) => setSelectedCountry(e.target.value)}
          value={selectedCountry}
        >
          {countryInfo.map((country, index) => (
            <option key={index} value={country}>
              {country}
            </option>
          ))}
        </select>
        <select
          onChange={(e) => setSelectedCity(e.target.value)}
          value={selectedCity}
        >
          {cityInfo.map((city, index) => (
            <option key={index} value={city}>
              {city}
            </option>
          ))}
        </select>
        <div>{selectedCity}</div>
        <Marginer direction="vertical" margin="2em" />
        {/* find a way to pass params to link to retrieve */}
        <Link
          to={{
            pathname: "/weatherInfo",
            params: {
              city: { selectedCity },
            },
          }}
        >
          <Button>Find your Weather</Button>
        </Link>
      </BackGroundFilter>
    </FrontSectionContainer>
  );
}
