package com.meetime.test.challenge.usecases.oauth.getConnectHubspot.dto;

import lombok.Builder;

@Builder
public record ConnectHubspotResponseDTO(String authorizationUrl) {}
