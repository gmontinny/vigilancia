package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Legislacao;
import br.gov.mt.vigilancia.saude.dto.LegislacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LegislacaoMapper {

    LegislacaoMapper INSTANCE = Mappers.getMapper(LegislacaoMapper.class);

    LegislacaoDTO toDTO(Legislacao legislacao);
    Legislacao toEntity(LegislacaoDTO legislacaoDTO);
}
