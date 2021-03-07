import React, { Component } from "react";
import styled from "styled-components";

const Basic3Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  color: #fff;
  font-size: 40px;
  font-weight: regular;
  margin: 0 1em;
`;

const ImageContainer = styled.img`
  width: 70px;
  height: 70px;
  margin-left: 10px;
`;

export function Basic3(props) {
  const { tempType, temp, imgUrl } = props;

  return (
    <Basic3Container>
      {tempType}
      <ImageContainer src={imgUrl} />
      {temp} &deg;C
    </Basic3Container>
  );
}
