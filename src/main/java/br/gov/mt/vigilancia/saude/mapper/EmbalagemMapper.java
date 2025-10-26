package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Embalagem;
import br.gov.mt.vigilancia.saude.dto.EmbalagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmbalagemMapper {
    EmbalagemMapper INSTANCE = Mappers.getMapper(EmbalagemMapper.class);

    @Mapping(source = "idEmbalagem", target = "idEmbalagem")
    @Mapping(source = "descricaoEmbalagem", target = "descricaoEmbalagem")
    EmbalagemDTO toDTO(Embalagem embalagem);

    @Mapping(source = "idEmbalagem", target = "idEmbalagem")
    @Mapping(source = "descricaoEmbalagem", target = "descricaoEmbalagem")
    Embalagem toEntity(EmbalagemDTO embalagemDTO);
}
