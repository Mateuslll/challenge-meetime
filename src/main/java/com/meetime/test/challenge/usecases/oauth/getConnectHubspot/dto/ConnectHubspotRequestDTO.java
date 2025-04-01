package com.meetime.test.challenge.usecases.oauth.getConnectHubspot.dto;

import lombok.Builder;

@Builder
public record ConnectHubspotRequestDTO() {
  public static ConnectHubspotRequestDTO of() {
    return ConnectHubspotRequestDTO.builder().build();
  }
}
