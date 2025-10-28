package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Carteirinha;
import br.gov.mt.vigilancia.saude.dto.CarteirinhaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarteirinhaMapper {

    CarteirinhaMapper INSTANCE = Mappers.getMapper(CarteirinhaMapper.class);

    CarteirinhaDTO toDTO(Carteirinha carteirinha);
    Carteirinha toEntity(CarteirinhaDTO carteirinhaDTO);
}
