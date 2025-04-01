package com.meetime.test.challenge.usecases.oauth.getConnectHubspot;

import com.meetime.test.challenge.usecases.oauth.getConnectHubspot.dto.ConnectHubspotRequestDTO;
import com.meetime.test.challenge.usecases.oauth.getConnectHubspot.dto.ConnectHubspotResponseDTO;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConnectHubspot implements ConnectHubspotUseCase {

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
  public ConnectHubspotResponseDTO execute(ConnectHubspotRequestDTO input) {
    String authUrl =
        authorizationUrl
            + PARAM_CLIENT_ID
            + clientId
            + PARAM_SCOPE
            + URLEncoder.encode(scope, StandardCharsets.UTF_8)
            + PARAM_REDIRECT_URI
            + URLEncoder.encode(redirectUri, StandardCharsets.UTF_8);

    log.info("Gerando URL de autorização do HubSpot");
    return ConnectHubspotResponseDTO.builder().authorizationUrl(authUrl).build();
  }
}
