package com.meetime.test.challenge.controller;

import com.meetime.test.challenge.usecases.webhook.HandleContactCreationWebhookUseCase;
import com.meetime.test.challenge.usecases.webhook.dto.HandleContactCreationWebhookRequestDTO;
import com.meetime.test.challenge.usecases.webhook.dto.WebhookDataDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WebhookController {

  private final HandleContactCreationWebhookUseCase handleContactCreationWebhookUseCase;

  @PostMapping("/webhook/contact-creation")
  public ResponseEntity<String> handleContactCreationWebhook(
      @RequestBody List<WebhookDataDTO> webhookData) {
    HandleContactCreationWebhookRequestDTO requestDTO =
        HandleContactCreationWebhookRequestDTO.of(webhookData);

    return ResponseEntity.ok(handleContactCreationWebhookUseCase.execute(requestDTO).message());
  }


  @PostMapping("/webhook/contact-creation-local")
  public ResponseEntity<String> handleContactCreationWebhook(
          @RequestBody WebhookDataDTO webhookData) {
    HandleContactCreationWebhookRequestDTO requestDTO =
            HandleContactCreationWebhookRequestDTO.of(webhookData);

    return ResponseEntity.ok(handleContactCreationWebhookUseCase.execute(requestDTO).message());
  }
}
