package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geracodigocertificacao;
import br.gov.mt.vigilancia.saude.dto.GeracodigocertificacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeracodigocertificacaoMapper {

    GeracodigocertificacaoMapper INSTANCE = Mappers.getMapper(GeracodigocertificacaoMapper.class);

    GeracodigocertificacaoDTO toDTO(Geracodigocertificacao geracodigocertificacao);
    Geracodigocertificacao toEntity(GeracodigocertificacaoDTO geracodigocertificacaoDTO);
}
