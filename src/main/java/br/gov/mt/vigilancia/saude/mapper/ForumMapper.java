package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Forum;
import br.gov.mt.vigilancia.saude.dto.ForumDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {OrdemServicoMapper.class, UsuarioMapper.class})
public interface ForumMapper {

    ForumMapper INSTANCE = Mappers.getMapper(ForumMapper.class);

    @Mapping(source = "ordemServico.id", target = "idOrdemServico")
    @Mapping(source = "usuario.id", target = "idUsuario")
    ForumDTO toDto(Forum forum);

    @Mapping(target = "ordemServico", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Forum toEntity(ForumDTO forumDTO);
}
