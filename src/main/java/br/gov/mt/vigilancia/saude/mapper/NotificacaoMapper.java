package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Notificacao;
import br.gov.mt.vigilancia.saude.dto.NotificacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacaoMapper {

    NotificacaoMapper INSTANCE = Mappers.getMapper(NotificacaoMapper.class);

    @Mapping(source = "usuario.id", target = "idusuario")
    NotificacaoDTO toDTO(Notificacao notificacao);

    @Mapping(source = "idusuario", target = "usuario.id")
    Notificacao toEntity(NotificacaoDTO notificacaoDTO);
}
