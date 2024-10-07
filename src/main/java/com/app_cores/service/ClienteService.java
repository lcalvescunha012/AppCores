package com.app_cores.service;

import com.app_cores.dto.ClienteDTO;
import com.app_cores.entities.ClienteEntity;
import com.app_cores.exceptions.HttpNotFoundException;
import com.app_cores.mappers.ClienteMapper;
import com.app_cores.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;


    public ClienteDTO findById(long id) {
        return clienteMapper.toDto(clienteRepository.findById(id).orElseThrow(() -> new HttpNotFoundException("Cliente " + id + " não encontrada.")));
    }

    public ClienteDTO save(ClienteDTO cliente) {
        return clienteMapper.toDto(clienteRepository.save(clienteMapper.toEntity(cliente)));
    }

    public ClienteDTO update(long id, ClienteDTO cliente) {
        ClienteEntity clienteEntity;
        ClienteDTO clienteDTO;
        try {
            clienteEntity = clienteRepository.getReferenceById(id);

            clienteEntity.setNome(cliente.nome());
            clienteEntity.setEmail(cliente.email());
            clienteEntity.setTelefone(cliente.telefone());
            clienteEntity.setLogoUrl(cliente.logoUrl());
            clienteEntity.setTemaId(cliente.temaId());

            clienteDTO = clienteMapper.toDto(clienteEntity);
            save(clienteDTO);
        } catch (EntityNotFoundException e) {
            throw new HttpNotFoundException("Cliente " + id + " não encontrado.");
        }

        return clienteDTO;
    }

    public void delete(long id) {
        clienteRepository.deleteById(id);
    }


}
