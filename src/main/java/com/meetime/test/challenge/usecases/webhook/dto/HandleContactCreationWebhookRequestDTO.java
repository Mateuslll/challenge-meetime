package com.meetime.test.challenge.usecases.webhook.dto;

import java.util.Collections;
import java.util.List;
import lombok.Builder;

@Builder
public record HandleContactCreationWebhookRequestDTO(List<WebhookDataDTO> webhookData) {

  public static HandleContactCreationWebhookRequestDTO of(List<WebhookDataDTO> webhookData) {
    return HandleContactCreationWebhookRequestDTO.builder().webhookData(webhookData).build();
  }

  public static HandleContactCreationWebhookRequestDTO of(WebhookDataDTO webhookData) {
    return HandleContactCreationWebhookRequestDTO.builder()
        .webhookData(Collections.singletonList(webhookData))
        .build();
  }
}
