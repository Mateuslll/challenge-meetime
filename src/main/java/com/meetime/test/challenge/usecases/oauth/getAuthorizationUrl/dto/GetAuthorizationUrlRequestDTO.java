package com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl.dto;

import lombok.Builder;

@Builder
public record GetAuthorizationUrlRequestDTO() {
  public static GetAuthorizationUrlRequestDTO of() {
    return GetAuthorizationUrlRequestDTO.builder().build();
  }
}
