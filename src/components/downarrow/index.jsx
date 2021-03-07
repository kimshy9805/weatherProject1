import React, { Component } from "react";
import styled from "styled-components";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faAngleDown } from "@fortawesome/free-solid-svg-icons";
import { theme } from "../../theme";

const ArrowContainer = styled.div`
  width: 46px;
  height: 46px;
  border-radius: 50%;
  background-color: rgba(113, 113, 113, 0.48);
  border: 2px solid #797979;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: all 250ms ease-in-out;
  cursor: pointer;

  &: hover {
    border: 2px solid ${theme.primary};
  } ;
`;

const ArrowIcon = styled.div`
  color: #fff;
  font-size: 30px;
  margin-top: 5px;
`;

export function DownArrow(props) {
  return (
    <ArrowContainer>
      <ArrowIcon>
        <FontAwesomeIcon icon={faAngleDown} />
      </ArrowIcon>
    </ArrowContainer>
  );
}
