package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Notificacaousuario;
import br.gov.mt.vigilancia.saude.dto.NotificacaousuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacaousuarioMapper {

    NotificacaousuarioMapper INSTANCE = Mappers.getMapper(NotificacaousuarioMapper.class);

    NotificacaousuarioDTO toDTO(Notificacaousuario notificacaousuario);
    Notificacaousuario toEntity(NotificacaousuarioDTO notificacaousuarioDTO);
}
