package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Notificacaosegundainstancia;
import br.gov.mt.vigilancia.saude.dto.NotificacaosegundainstanciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacaosegundainstanciaMapper {

    NotificacaosegundainstanciaMapper INSTANCE = Mappers.getMapper(NotificacaosegundainstanciaMapper.class);

    NotificacaosegundainstanciaDTO toDTO(Notificacaosegundainstancia notificacaosegundainstancia);
    Notificacaosegundainstancia toEntity(NotificacaosegundainstanciaDTO notificacaosegundainstanciaDTO);
}
