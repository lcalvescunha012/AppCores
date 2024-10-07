package com.app_cores.service;

import com.app_cores.dto.TermaDTO;
import com.app_cores.entities.TemaEntity;
import com.app_cores.exceptions.HttpNotFoundException;
import com.app_cores.mappers.TemaMapper;
import com.app_cores.repository.TemaRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.Collection;
import java.util.stream.Collectors;


public class TemaService {

    private TemaRepository temaRepository;

    private TemaMapper temaMapper;

    public Collection<TermaDTO> finaAll() {
        return temaRepository.findAll().stream().map(temaMapper::toDto).collect(Collectors.toList());
    }

    public TermaDTO findById(long id) {
        return temaMapper.toDto(temaRepository.findById(id).orElseThrow(() -> new HttpNotFoundException("Tema " + id + " não encontrada.")));
    }

    public TermaDTO save(TermaDTO tema) {
        return temaMapper.toDto(temaRepository.save(temaMapper.toEntity(tema)));
    }

    public TermaDTO update(long id, TermaDTO tema) {
        TemaEntity temaEntity;
        TermaDTO termaDTO;
        try {
            temaEntity = temaRepository.getReferenceById(id);
            temaEntity.setNomeTema(tema.nomeTema());
            temaEntity.setCorPrimaria(tema.corPrimaria());
            temaEntity.setCorSecundaria(tema.corSecundaria());
            temaEntity.setFontePrimaria(tema.fontePrimaria());

            termaDTO = temaMapper.toDto(temaEntity);
            save(termaDTO);
        } catch (EntityNotFoundException e) {
            throw new HttpNotFoundException("Tema " + id + " não encontrado.");
        }

        return termaDTO;
    }

    public void delete(long id) {
        temaRepository.deleteById(id);
    }

}
