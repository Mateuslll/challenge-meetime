package com.meetime.test.challenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;
import org.springframework.http.HttpHeaders;  // Ensure the correct import
import java.nio.charset.StandardCharsets;
@RestController
public class OAuthController {

	private static final String CLIENT_ID = "b21f0047-6928-459b-95ae-0d6373b9f488";
	private static final String REDIRECT_URI = "http://localhost:8080/oauth/callback";
	private static final String CLIENT_SECRET = "224c87e2-f652-4b2b-af4e-a1041ed2ac4a";
	private static final String AUTHORIZATION_URL = "https://app.hubspot.com/oauth/authorize";
	private static final String TOKEN_URL = "https://api.hubapi.com/oauth/v1/token";
	private static final String SCOPE = "crm.objects.contacts.read crm.objects.contacts.write";

	// Constantes para parâmetros de URL
	private static final String PARAM_CLIENT_ID = "?client_id=";
	private static final String PARAM_AND_CLIENT_ID = "&client_id=";
	private static final String PARAM_SCOPE = "&scope=";
	private static final String PARAM_REDIRECT_URI = "&redirect_uri=";
	private static final String PARAM_CLIENT_SECRET = "&client_secret=";
	private static final String PARAM_CODE = "&code=";
	private static final String PARAM_GRANT_TYPE = "grant_type=authorization_code";

	@GetMapping("/connect-hubspot")
	public void getConnectHubspot(HttpServletResponse response) throws IOException {
		// Redirecionamento automático para o HubSpot
		String authUrl = AUTHORIZATION_URL +
				PARAM_CLIENT_ID + CLIENT_ID +
				PARAM_SCOPE + URLEncoder.encode(SCOPE, StandardCharsets.UTF_8) +
				PARAM_REDIRECT_URI + URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8);

		response.sendRedirect(authUrl);
	}

	@GetMapping("/oauth/authorization-url")
	public String getAuthorizationUrl() {
		// Codificando os parâmetros
		String encodedClientId = URLEncoder.encode(CLIENT_ID, StandardCharsets.UTF_8);
		String encodedRedirectUri = URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8);
		String encodedScope = URLEncoder.encode(SCOPE, StandardCharsets.UTF_8);

		return AUTHORIZATION_URL +
				PARAM_CLIENT_ID + encodedClientId +
				PARAM_SCOPE + encodedScope +
				PARAM_REDIRECT_URI + encodedRedirectUri;
	}

	@GetMapping("/oauth/callback")
	public String handleOAuthCallback(@RequestParam("code") String code){


		String formData = PARAM_GRANT_TYPE +
				PARAM_AND_CLIENT_ID + CLIENT_ID +
				PARAM_CLIENT_SECRET + CLIENT_SECRET +
				PARAM_REDIRECT_URI + REDIRECT_URI +
				PARAM_CODE + code;

		// Realiza a requisicao Post para obter o token
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/x-www-form-urlencoded");
		headers.set("Accept", "application/json");

		HttpEntity<String> entity = new HttpEntity<>(formData, headers);

		try {
			ResponseEntity<String> response = restTemplate.exchange(TOKEN_URL, HttpMethod.POST, entity, String.class);
			String responseBody = response.getBody();
			return "Tokens: " + responseBody;
		} catch (Exception e) {
			return "Error occurred: " + e.getMessage();
		}

	}

	@GetMapping("/get-contacts")
	public String getContacts(@RequestParam String accessToken) {

		String url = "https://api.hubapi.com/crm/v3/objects/contacts?limit=10";

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + accessToken);
		headers.set("Content-Type", "application/json");

		HttpEntity<String> entity = new HttpEntity<>(headers);

		try {
			ResponseEntity<String> response = restTemplate.exchange(
					url,
					HttpMethod.GET,
					entity,
					String.class
			);
			return "Contatos: " + response.getBody();
		} catch (Exception e) {
			return "Erro ao buscar contatos: " + e.getMessage();
		}
	}
}