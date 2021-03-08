import React, { Component } from "react";
import styled from "styled-components";
import { TopSection } from "../homepage/topSection";
import { ServiceSection } from "../homepage/serviceSection";

const PageContainer = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
`;

export function Homepage(props) {
  return (
    <PageContainer>
      <TopSection />
      <ServiceSection city={props.location.params} />
    </PageContainer>
  );
}
