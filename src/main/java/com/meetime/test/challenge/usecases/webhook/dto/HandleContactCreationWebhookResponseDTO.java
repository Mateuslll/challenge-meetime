package com.meetime.test.challenge.usecases.webhook.dto;

import lombok.Builder;

@Builder
public record HandleContactCreationWebhookResponseDTO(String message) {}
