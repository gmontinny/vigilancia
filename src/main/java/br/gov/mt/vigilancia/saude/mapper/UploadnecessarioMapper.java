package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Uploadnecessario;
import br.gov.mt.vigilancia.saude.dto.UploadnecessarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UploadnecessarioMapper {

    UploadnecessarioMapper INSTANCE = Mappers.getMapper(UploadnecessarioMapper.class);

    @Mapping(source = "docnecessario.iddocnecessario", target = "iddocnecessario")
    UploadnecessarioDTO toDTO(Uploadnecessario uploadnecessario);

    @Mapping(source = "iddocnecessario", target = "docnecessario.iddocnecessario")
    Uploadnecessario toEntity(UploadnecessarioDTO uploadnecessarioDTO);
}
