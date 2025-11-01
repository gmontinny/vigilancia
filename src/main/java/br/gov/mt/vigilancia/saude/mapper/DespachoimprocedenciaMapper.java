package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Despachoimprocedencia;
import br.gov.mt.vigilancia.saude.dto.DespachoimprocedenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DespachoimprocedenciaMapper {

    DespachoimprocedenciaMapper INSTANCE = Mappers.getMapper(DespachoimprocedenciaMapper.class);

    DespachoimprocedenciaDTO toDTO(Despachoimprocedencia despachocontrarazao);
    Despachoimprocedencia toEntity(DespachoimprocedenciaDTO despachocontrarazaoDTO);
}
