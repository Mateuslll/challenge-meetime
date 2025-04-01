package com.meetime.test.challenge.usecases.contact.createContact;

import com.meetime.test.challenge.usecases.contact.createContact.dto.CreateContactRequestDTO;
import com.meetime.test.challenge.usecases.contact.createContact.dto.CreateContactResponseDTO;
import java.util.Map;
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
public class CreateContact implements CreateContactUseCase {

  @Override
  public CreateContactResponseDTO execute(CreateContactRequestDTO input) {
    String url = "https://api.hubapi.com/crm/v3/objects/contacts";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", input.authorization());
    headers.set("Content-Type", "application/json");

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(input.contactData(), headers);

    try {
      ResponseEntity<String> response =
          restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
      log.info("Contato criado: {}", response.getBody());
      return new CreateContactResponseDTO(response.getBody());

    } catch (Exception e) {
      log.error("Erro ao criar contato: {}", e.getMessage());
      return new CreateContactResponseDTO("Erro ao criar contato: " + e.getMessage());
    }
  }
}
