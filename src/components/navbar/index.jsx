import React, { Component } from "react";
import styled from "styled-components";
import { Logo } from "../logo/index";
import { Button } from "../button";
import { Marginer } from "../marginer";
const NavbarContainer = styled.div`
  width: 100%;
  height: 35px;
  padding: 0 2em;
  margin-top: 5px;
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content: space-between;
`;

const BrandContainer = styled.div``;

const AccessibilityContainer = styled.div`
  display: flex;
  flex-direction: row;
`;

const LoginButton = styled(Button)`
  background-color: transparent;
  border: none;
  outline: none;

  &:hover {
    background-color: transparent;
    border: none;
    color: rgb(212, 212, 212);
  }
`;

export function Navbar(props) {
  return (
    <NavbarContainer>
      <BrandContainer>
        <Logo inline />
      </BrandContainer>
      <AccessibilityContainer>
        <Button small>Get Started </Button>
        <Marginer direction="horizontal" margin="8px" />
        <LoginButton small>Login</LoginButton>
      </AccessibilityContainer>
    </NavbarContainer>
  );
}
