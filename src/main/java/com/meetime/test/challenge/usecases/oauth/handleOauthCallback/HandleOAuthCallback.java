package com.meetime.test.challenge.usecases.oauth.handleOauthCallback;

import com.meetime.test.challenge.usecases.oauth.handleOauthCallback.dto.HandleOAuthCallbackRequestDTO;
import com.meetime.test.challenge.usecases.oauth.handleOauthCallback.dto.HandleOAuthCallbackResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class HandleOAuthCallback implements HandleOAuthCallbackUseCase {

  @Value("${meetime.hubspot.clientId}")
  private String clientId;

  @Value("${meetime.hubspot.redirectUri}")
  private String redirectUri;

  @Value("${meetime.hubspot.clientSecret}")
  private String clientSecret;

  @Value("${meetime.hubspot.tokenUrl}")
  private String tokenUrl;

  private static final String PARAM_GRANT_TYPE = "grant_type=authorization_code";
  private static final String PARAM_AND_CLIENT_ID = "&client_id=";
  private static final String PARAM_CLIENT_SECRET = "&client_secret=";
  private static final String PARAM_REDIRECT_URI = "&redirect_uri=";
  private static final String PARAM_CODE = "&code=";

  @Override
  public HandleOAuthCallbackResponseDTO execute(HandleOAuthCallbackRequestDTO input) {
    String formData =
        PARAM_GRANT_TYPE
            + PARAM_AND_CLIENT_ID
            + clientId
            + PARAM_CLIENT_SECRET
            + clientSecret
            + PARAM_REDIRECT_URI
            + redirectUri
            + PARAM_CODE
            + input.code();

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "application/x-www-form-urlencoded");
    headers.set("Accept", "application/json");

    HttpEntity<String> entity = new HttpEntity<>(formData, headers);

    try {
      ResponseEntity<String> response =
          restTemplate.exchange(tokenUrl, HttpMethod.POST, entity, String.class);
      String responseBody = response.getBody();
      log.info("Token obtido com sucesso do HubSpot");
      return new HandleOAuthCallbackResponseDTO("Tokens: " + responseBody);
    } catch (Exception e) {
      log.error("Erro ao obter token: {}", e.getMessage());
      return new HandleOAuthCallbackResponseDTO("Error occurred: " + e.getMessage());
    }
  }
}
