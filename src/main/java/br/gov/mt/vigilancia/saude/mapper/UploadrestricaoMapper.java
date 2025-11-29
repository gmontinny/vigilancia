package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Uploadrestricao;
import br.gov.mt.vigilancia.saude.dto.UploadrestricaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UploadrestricaoMapper {

    UploadrestricaoMapper INSTANCE = Mappers.getMapper(UploadrestricaoMapper.class);

    UploadrestricaoDTO toDTO(Uploadrestricao uploadrestricao);
    Uploadrestricao toEntity(UploadrestricaoDTO uploadrestricaoDTO);
}
