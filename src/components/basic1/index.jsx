import React, { Component } from "react";
import styled from "styled-components";

const Basic1Container = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  color: #fff;
  font-size: 30px;
  font-weight: regular;
  margin-left: ${({ isPressure }) => isPressure && "70px"};
`;

const ImageContainer = styled.img`
  width: 60px;
  height: 60px;
  margin-right: 20px;
`;

export function Basic1(props) {
  const { imgUrl, type, value, unit, isPressure } = props;

  return (
    <Basic1Container isPressure={isPressure}>
      <ImageContainer src={imgUrl} />
      {type}: {value} {unit}
    </Basic1Container>
  );
}
