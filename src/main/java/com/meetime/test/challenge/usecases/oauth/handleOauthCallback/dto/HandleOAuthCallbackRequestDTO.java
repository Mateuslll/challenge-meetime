package com.meetime.test.challenge.usecases.oauth.handleOauthCallback.dto;

import lombok.Builder;

@Builder
public record HandleOAuthCallbackRequestDTO(String code) {
  public static HandleOAuthCallbackRequestDTO of(String code) {
    return HandleOAuthCallbackRequestDTO.builder().code(code).build();
  }
}
