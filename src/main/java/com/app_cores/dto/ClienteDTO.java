package com.app_cores.dto;

public record ClienteDTO(Long id,
                         String nome,
                         String email,
                         String telefone,
                         String logoUrl,
                         Long temaId
) {
}
