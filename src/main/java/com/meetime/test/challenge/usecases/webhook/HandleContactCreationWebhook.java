package com.meetime.test.challenge.usecases.webhook;

import com.meetime.test.challenge.usecases.webhook.dto.HandleContactCreationWebhookRequestDTO;
import com.meetime.test.challenge.usecases.webhook.dto.HandleContactCreationWebhookResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HandleContactCreationWebhook implements HandleContactCreationWebhookUseCase {

  @Override
  public HandleContactCreationWebhookResponseDTO execute(
      HandleContactCreationWebhookRequestDTO input) {
    log.info("Webhook recebido: {}", input.webhookData().getFirst());

    return HandleContactCreationWebhookResponseDTO.builder()
        .message("Webhook processado com sucesso")
        .build();
  }
}
