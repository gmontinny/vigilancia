package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Mensagem;
import br.gov.mt.vigilancia.saude.dto.MensagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {OrdemServicoMapper.class})
public interface MensagemMapper {

    MensagemMapper INSTANCE = Mappers.getMapper(MensagemMapper.class);

    @Mapping(source = "ordemServico.idordemservico", target = "idOrdemServico")
    MensagemDTO toDto(Mensagem mensagem);

    @Mapping(target = "ordemServico", ignore = true)
    Mensagem toEntity(MensagemDTO mensagemDTO);
}
