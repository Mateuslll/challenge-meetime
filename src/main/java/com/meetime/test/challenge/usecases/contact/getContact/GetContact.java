package com.meetime.test.challenge.usecases.contact.getContact;

import com.meetime.test.challenge.usecases.contact.getContact.dto.GetContactsRequestDTO;
import com.meetime.test.challenge.usecases.contact.getContact.dto.GetContactsResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetContact implements GetContactUseCase {

  private static final String URL = "https://api.hubapi.com/crm/v3/objects/contacts?limit=10";

  @Override
  public GetContactsResponseDTO execute(GetContactsRequestDTO input) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", input.authorization());
    headers.set("Content-Type", "application/json");

    HttpEntity<String> entity = new HttpEntity<>(headers);

    try {
      ResponseEntity<String> response =
          restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
      log.info("Contatos obtidos com sucesso : {}", response.getBody());
      return new GetContactsResponseDTO(response.getBody());
    } catch (Exception e) {
      log.error("Erro ao buscar contatos: {}", e.getMessage());
      return new GetContactsResponseDTO("Erro ao buscar contatos: " + e.getMessage());
    }
  }
}
