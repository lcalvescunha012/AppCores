package com.app_cores.mappers;

import com.app_cores.dto.TermaDTO;
import com.app_cores.entities.TemaEntity;

public class TemaMapper {
    public TermaDTO toDto(TemaEntity temaEntity) {
        return new TermaDTO(temaEntity.getId(),
                temaEntity.getNomeTema(),
                temaEntity.getCorPrimaria(),
                temaEntity.getCorSecundaria(),
                temaEntity.getFontePrimaria());
    }

    public TemaEntity toEntity(TermaDTO termaDTO) {
        return new TemaEntity(
                termaDTO.id(),
                termaDTO.nomeTema(),
                termaDTO.corPrimaria(),
                termaDTO.corSecundaria(),
                termaDTO.fontePrimaria()
        );
    }
}
