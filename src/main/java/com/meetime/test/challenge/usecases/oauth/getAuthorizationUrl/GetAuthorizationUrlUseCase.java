package com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl;

import com.meetime.test.challenge.usecases.UseCase;
import com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl.dto.GetAuthorizationUrlRequestDTO;
import com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl.dto.GetAuthorizationUrlResponseDTO;

public interface GetAuthorizationUrlUseCase
    extends UseCase<GetAuthorizationUrlRequestDTO, GetAuthorizationUrlResponseDTO> {}
