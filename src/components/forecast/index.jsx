import React, { Component } from "react";
import styled from "styled-components";

const ForecastContainer = styled.div`
  display: flex;
  flex-direction: column;
  padding: 0;
  margin: 0;
`;

const ForecastImg = styled.img`
  width: 5em;
  height: 5em;
  padding: 0;
`;

const ForecastTemp = styled.p`
  color: #fff;
  font-size: 25px;
  text-align: center;
  margin-top: 10px;
`;

const ForecastDay = styled.h2`
  color: #fff;
  font-size: 25px;
  text-align: center;
  margin-bottom: 10px;
`;

export function Forecast(props) {
  const { imgUrl, temp, day } = props;

  return (
    <ForecastContainer>
      <ForecastDay>{day}</ForecastDay>
      <ForecastImg src={imgUrl} />
      <ForecastTemp>{temp}</ForecastTemp>
    </ForecastContainer>
  );
}
