package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Resposta;
import br.gov.mt.vigilancia.saude.dto.RespostaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ForumMapper.class})
public interface RespostaMapper {

    RespostaMapper INSTANCE = Mappers.getMapper(RespostaMapper.class);

    @Mapping(source = "forum.id", target = "idForum")
    RespostaDTO toDto(Resposta resposta);

    @Mapping(target = "forum", ignore = true)
    Resposta toEntity(RespostaDTO respostaDTO);
}
