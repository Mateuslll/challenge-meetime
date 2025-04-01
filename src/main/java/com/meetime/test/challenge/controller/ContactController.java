package com.meetime.test.challenge.controller;

import com.meetime.test.challenge.usecases.contact.createContact.CreateContact;
import com.meetime.test.challenge.usecases.contact.createContact.dto.CreateContactRequestDTO;
import com.meetime.test.challenge.usecases.contact.createContact.dto.CreateContactResponseDTO;
import com.meetime.test.challenge.usecases.contact.getContact.GetContact;
import com.meetime.test.challenge.usecases.contact.getContact.dto.GetContactsRequestDTO;
import com.meetime.test.challenge.usecases.contact.getContact.dto.GetContactsResponseDTO;
import jakarta.validation.Valid;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ContactController {

  private final CreateContact createContactUseCase;
  private final GetContact getContactsUseCase;

  @PostMapping("/create-contact")
  public ResponseEntity<CreateContactResponseDTO> createContact(
      @RequestHeader("Authorization") String authorizationHeader,
      @Valid @RequestBody Map<String, Object> contactData) {

    CreateContactRequestDTO requestDTO =
        CreateContactRequestDTO.of(contactData, authorizationHeader);

    return ResponseEntity.status(HttpStatus.CREATED).body(createContactUseCase.execute(requestDTO));
  }

  @GetMapping("/get-contacts")
  public ResponseEntity<GetContactsResponseDTO> getContacts(
      @RequestHeader("Authorization") String authorizationHeader) {

    GetContactsRequestDTO requestDTO = GetContactsRequestDTO.of(authorizationHeader);
    return ResponseEntity.ok(getContactsUseCase.execute(requestDTO));
  }
}
