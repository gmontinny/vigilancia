package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Saude;
import br.gov.mt.vigilancia.saude.dto.SaudeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProcessoMapper.class})
public interface SaudeMapper {

    SaudeMapper INSTANCE = Mappers.getMapper(SaudeMapper.class);

    @Mapping(source = "processo.numeroProcesso", target = "numeroProcesso")
    SaudeDTO toDto(Saude saude);

    @Mapping(target = "processo", ignore = true)
    Saude toEntity(SaudeDTO saudeDTO);
}
