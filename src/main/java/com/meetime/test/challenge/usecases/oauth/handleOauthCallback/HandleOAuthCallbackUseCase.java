package com.meetime.test.challenge.usecases.oauth.handleOauthCallback;

import com.meetime.test.challenge.usecases.UseCase;
import com.meetime.test.challenge.usecases.oauth.handleOauthCallback.dto.HandleOAuthCallbackRequestDTO;
import com.meetime.test.challenge.usecases.oauth.handleOauthCallback.dto.HandleOAuthCallbackResponseDTO;

public interface HandleOAuthCallbackUseCase
    extends UseCase<HandleOAuthCallbackRequestDTO, HandleOAuthCallbackResponseDTO> {}
