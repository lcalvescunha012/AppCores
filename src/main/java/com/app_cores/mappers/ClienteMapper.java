package com.app_cores.mappers;

import com.app_cores.dto.ClienteDTO;
import com.app_cores.entities.ClienteEntity;

public class ClienteMapper {
    public ClienteDTO toDto(ClienteEntity clienteEntity) {
        return new ClienteDTO(clienteEntity.getId(),
                clienteEntity.getNome(),
                clienteEntity.getEmail(),
                clienteEntity.getTelefone(),
                clienteEntity.getLogoUrl(),
                clienteEntity.getTemaId());
    }

    public ClienteEntity toEntity(ClienteDTO clienteDTO) {
        return new ClienteEntity(
                clienteDTO.id(),
                clienteDTO.nome(),
                clienteDTO.email(),
                clienteDTO.telefone(),
                clienteDTO.logoUrl(),
                clienteDTO.temaId()
        );
    }
}
