package com.meetime.test.challenge.usecases.contact.createContact.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.Map;
import lombok.Builder;

@Builder
public record CreateContactRequestDTO(
    @NotNull(message = "Os dados do contato são obrigatórios")
        @Schema(
            description = "Dados do contato",
            example = "{\"firstName\": \"John\", \"lastName\": \"Doe\"}")
        Map<String, Object> contactData,
    @NotNull(message = "O token de autorização é obrigatório")
        @Schema(description = "Token de autorização", example = "Bearer seu_token_de_acesso")
        String authorization) {

  public static CreateContactRequestDTO of(Map<String, Object> contactData, String authorization) {
    return CreateContactRequestDTO.builder()
        .contactData(contactData)
        .authorization(authorization)
        .build();
  }
}
