package com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl;

import com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl.dto.GetAuthorizationUrlRequestDTO;
import com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl.dto.GetAuthorizationUrlResponseDTO;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAuthorizationUrl implements GetAuthorizationUrlUseCase {

  @Value("${meetime.hubspot.clientId}")
  private String clientId;

  @Value("${meetime.hubspot.redirectUri}")
  private String redirectUri;

  @Value("${meetime.hubspot.authorizationUrl}")
  private String authorizationUrl;

  @Value("${meetime.hubspot.scope}")
  private String scope;

  private static final String PARAM_CLIENT_ID = "?client_id=";
  private static final String PARAM_SCOPE = "&scope=";
  private static final String PARAM_REDIRECT_URI = "&redirect_uri=";

  @Override
  public GetAuthorizationUrlResponseDTO execute(GetAuthorizationUrlRequestDTO input) {
    String encodedClientId = URLEncoder.encode(clientId, StandardCharsets.UTF_8);
    String encodedRedirectUri = URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);
    String encodedScope = URLEncoder.encode(scope, StandardCharsets.UTF_8);

    String url =
        authorizationUrl
            + PARAM_CLIENT_ID
            + encodedClientId
            + PARAM_SCOPE
            + encodedScope
            + PARAM_REDIRECT_URI
            + encodedRedirectUri;

    log.info("URL de autorização do HubSpot gerada");
    return new GetAuthorizationUrlResponseDTO(url);
  }
}
