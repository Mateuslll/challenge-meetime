package com.meetime.test.challenge.controller;

import com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl.GetAuthorizationUrlUseCase;
import com.meetime.test.challenge.usecases.oauth.getAuthorizationUrl.dto.GetAuthorizationUrlRequestDTO;
import com.meetime.test.challenge.usecases.oauth.getConnectHubspot.ConnectHubspotUseCase;
import com.meetime.test.challenge.usecases.oauth.getConnectHubspot.dto.ConnectHubspotRequestDTO;
import com.meetime.test.challenge.usecases.oauth.handleOauthCallback.HandleOAuthCallbackUseCase;
import com.meetime.test.challenge.usecases.oauth.handleOauthCallback.dto.HandleOAuthCallbackRequestDTO;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
// Ensure the correct import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OAuthController {

  private final ConnectHubspotUseCase connectHubspotUseCase;
  private final GetAuthorizationUrlUseCase getAuthorizationUrlUseCase;
  private final HandleOAuthCallbackUseCase handleOAuthCallbackUseCase;

  @GetMapping("/connect-hubspot")
  public void getConnectHubspot(HttpServletResponse response) throws IOException {
    ConnectHubspotRequestDTO requestDTO = ConnectHubspotRequestDTO.of();
    String authUrl = connectHubspotUseCase.execute(requestDTO).authorizationUrl();
    response.sendRedirect(authUrl);
  }

  @GetMapping("/oauth/authorization-url")
  public String getAuthorizationUrl() {
    GetAuthorizationUrlRequestDTO requestDTO = GetAuthorizationUrlRequestDTO.of();
    return getAuthorizationUrlUseCase.execute(requestDTO).authorizationUrl();
  }

  @GetMapping("/oauth/callback")
  public String handleOAuthCallback(@RequestParam("code") String code) {
    HandleOAuthCallbackRequestDTO requestDTO = HandleOAuthCallbackRequestDTO.of(code);
    return handleOAuthCallbackUseCase.execute(requestDTO).responseBody();
  }
}
