package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Notificacaoprimeirainstancia;
import br.gov.mt.vigilancia.saude.dto.NotificacaoprimeirainstanciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacaoprimeirainstanciaMapper {

    NotificacaoprimeirainstanciaMapper INSTANCE = Mappers.getMapper(NotificacaoprimeirainstanciaMapper.class);

    NotificacaoprimeirainstanciaDTO toDTO(Notificacaoprimeirainstancia notificacaoprimeirainstancia);
    Notificacaoprimeirainstancia toEntity(NotificacaoprimeirainstanciaDTO notificacaoprimeirainstanciaDTO);
}
