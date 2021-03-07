import React, { Component } from "react";
import styled, { css } from "styled-components";
import logo from "../../assets/logos/logo_croped.png";

const LogoContainer = styled.div`
  display: flex;
  flex-direction: ${({ inline }) => (inline ? "row" : "column")};
  align-items: center;
`;

const LogoImg = styled.img`
  width: 8em;
  height: 8em;

  ${({ inline }) =>
    inline &&
    css`
      width: 22px;
      height: 22px;
      margin-right: 6px;
    `};
`;

const LogoText = styled.div`
  color: #fff;
  font-size: ${({ inline }) => (inline ? "18px" : "30px")};
  font-weight: 500;
  margin-top: ${({ inline }) => (inline ? 0 : "6px")}; ;
`;

export function Logo(props) {
  const { inline } = props;
  return (
    <LogoContainer inline={inline}>
      <LogoImg src={logo} inline={inline} />
      <LogoText inline={inline}>Weather</LogoText>
    </LogoContainer>
  );
}
