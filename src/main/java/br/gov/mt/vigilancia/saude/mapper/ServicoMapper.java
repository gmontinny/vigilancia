package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Servico;
import br.gov.mt.vigilancia.saude.dto.ServicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProcessoMapper.class})
public interface ServicoMapper {

    ServicoMapper INSTANCE = Mappers.getMapper(ServicoMapper.class);

    @Mapping(source = "processo.numeroProcesso", target = "numeroProcesso")
    ServicoDTO toDto(Servico servico);

    @Mapping(target = "processo", ignore = true)
    Servico toEntity(ServicoDTO servicoDTO);
}
