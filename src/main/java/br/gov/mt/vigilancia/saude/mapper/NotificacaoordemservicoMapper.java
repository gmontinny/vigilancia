package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Notificacaoordemservico;
import br.gov.mt.vigilancia.saude.dto.NotificacaoordemservicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacaoordemservicoMapper {

    NotificacaoordemservicoMapper INSTANCE = Mappers.getMapper(NotificacaoordemservicoMapper.class);

    @Mapping(source = "ordemservico.idordemservico", target = "idordemservico")
    @Mapping(source = "usuario.id", target = "idusuario")
    NotificacaoordemservicoDTO toDTO(Notificacaoordemservico notificacaoordemservico);

    @Mapping(source = "idordemservico", target = "ordemservico.idordemservico")
    @Mapping(source = "idusuario", target = "usuario.id")
    Notificacaoordemservico toEntity(NotificacaoordemservicoDTO notificacaoordemservicoDTO);
}
