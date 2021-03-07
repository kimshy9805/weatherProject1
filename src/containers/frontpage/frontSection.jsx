import React, { Component } from "react";
import styled from "styled-components";
import BackGroundImg from "../../assets/background/background.png";
import { Logo } from "../../components/logo/index";
import { Marginer } from "../../components/marginer/index";
import { Button } from "../../components/button/index";
import { Navbar } from "../../components/navbar/index";
import { Link } from "react-router-dom";

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
        
        <Link to="/weatherInfo">
          <Button>Find your Weather</Button>
        </Link>
      </BackGroundFilter>
    </FrontSectionContainer>
  );
}
