import React, { useState, useEffect } from "react";
import styled from "styled-components";
// import BackGroundImg from "../../assets/background/spots_background_light_blur_68629_1920x1080.jpg";
import BackGroundImg from "../../assets/background/background2.png";
import { Element } from "react-scroll";
import { Marginer } from "../../components/marginer/index";
import { SectionTitle } from "../../components/sectionTitle";
import { OurService } from "../../components/ourService/index";

const ServiceContainer = styled(Element)`
  width: 100%;
  height: 100%;
  padding: 0;
  background-image: url(${BackGroundImg});
  background-size: cover;
  position: relatvie;
`;

const BackGroundFilter = styled.div`
  width: 100%;
  height: 100vh;
  background-color: rgba(53, 53, 53, 0.1);
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export function ServiceSection(props) {
  return (
    <ServiceContainer name="serviceContainer">
      <BackGroundFilter>
        <Marginer direction="vertical" margin="1em" />
        <SectionTitle name="South Korea"></SectionTitle>
        <Marginer direction="vertical" margin="4em" />
        <OurService city={props.city} />
      </BackGroundFilter>
    </ServiceContainer>
  );
}
