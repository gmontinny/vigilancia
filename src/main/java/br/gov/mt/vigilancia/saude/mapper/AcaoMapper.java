package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Acao;
import br.gov.mt.vigilancia.saude.dto.AcaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AcaoMapper {

    AcaoMapper INSTANCE = Mappers.getMapper(AcaoMapper.class);

    AcaoDTO toDto(Acao acao);

    Acao toEntity(AcaoDTO acaoDTO);
}
