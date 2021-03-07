import React, { Component } from "react";
import styled from "styled-components";

const Basic2Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const CityContainer = styled.div`
  color: #fff;
  font-size: 50px;
  font-weight: regular;
  margin-bottom: 20px;
`;

const ImageContainer = styled.img`
  width: 110px;
  height: 110px;
  margin-bottom: 20px;
`;

const WeatherStateContainer = styled.div`
  color: #fff;
  font-size: 20px;
`;

export function Basic2(props) {
  const { imgUrl, weatherState, city } = props;

  return (
    <Basic2Container>
      <CityContainer>{city}</CityContainer>
      <ImageContainer src={imgUrl} />
      <WeatherStateContainer>{weatherState}</WeatherStateContainer>
    </Basic2Container>
  );
}
