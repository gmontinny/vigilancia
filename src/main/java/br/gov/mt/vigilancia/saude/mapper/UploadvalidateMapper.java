package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Uploadvalidate;
import br.gov.mt.vigilancia.saude.dto.UploadvalidateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UploadvalidateMapper {

    UploadvalidateMapper INSTANCE = Mappers.getMapper(UploadvalidateMapper.class);

    UploadvalidateDTO toDTO(Uploadvalidate uploadvalidate);
    Uploadvalidate toEntity(UploadvalidateDTO uploadvalidateDTO);
}
