package com.meetime.test.challenge.usecases.contact.getContact.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record GetContactsRequestDTO(
    @NotNull(message = "O token de autorização é obrigatório")
        @Schema(description = "Token de autorização", example = "Bearer seu_token_de_acesso")
        String authorization) {

  public static GetContactsRequestDTO of(String authorization) {
    return GetContactsRequestDTO.builder().authorization(authorization).build();
  }
}
