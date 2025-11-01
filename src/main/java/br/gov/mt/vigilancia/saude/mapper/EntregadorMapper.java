package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Entregador;
import br.gov.mt.vigilancia.saude.dto.EntregadorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EntregadorMapper {

    EntregadorMapper INSTANCE = Mappers.getMapper(EntregadorMapper.class);

    EntregadorDTO toDTO(Entregador entregador);
    Entregador toEntity(EntregadorDTO entregadorDTO);
}
