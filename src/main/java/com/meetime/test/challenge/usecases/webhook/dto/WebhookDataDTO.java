package com.meetime.test.challenge.usecases.webhook.dto;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebhookDataDTO {
  private Long appId;
  private String eventId;
  private String subscriptionId;
  private String portalId;
  private String objectId;
  private Long occurredAt;
  private String subscriptionType;
  private Integer attemptNumber;
  private String changeSource;
  private String changeFlag;
  private String eventType;
  private Map<String, Object> properties;
}
