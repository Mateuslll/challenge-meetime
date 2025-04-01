package com.meetime.test.challenge.usecases.webhook;

import com.meetime.test.challenge.usecases.UseCase;
import com.meetime.test.challenge.usecases.webhook.dto.HandleContactCreationWebhookRequestDTO;
import com.meetime.test.challenge.usecases.webhook.dto.HandleContactCreationWebhookResponseDTO;

public interface HandleContactCreationWebhookUseCase
    extends UseCase<
        HandleContactCreationWebhookRequestDTO, HandleContactCreationWebhookResponseDTO> {}
