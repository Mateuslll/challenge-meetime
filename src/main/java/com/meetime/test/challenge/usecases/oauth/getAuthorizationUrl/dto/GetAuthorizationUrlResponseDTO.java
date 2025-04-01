package com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl.dto;

import lombok.Builder;

@Builder
public record GetAuthorizationUrlResponseDTO(String authorizationUrl) {}
