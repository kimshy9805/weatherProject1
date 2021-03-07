import React, { Component } from "react";
import styled from "styled-components";

const SectionTitleContainer = styled.h1`
  font-size: 40px;
  font-weight: regular;
  color: #fff;
`;

export function SectionTitle(props) {
  const { name } = props;

  return (
    <SectionTitleContainer>
      Weather Information in {name}{" "}
    </SectionTitleContainer>
  );
}
