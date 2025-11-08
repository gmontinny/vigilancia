package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Notificacaoadministrativa;
import br.gov.mt.vigilancia.saude.dto.NotificacaoadministrativaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacaoadministrativaMapper {

    NotificacaoadministrativaMapper INSTANCE = Mappers.getMapper(NotificacaoadministrativaMapper.class);

    NotificacaoadministrativaDTO toDTO(Notificacaoadministrativa notificacaoadministrativa);
    Notificacaoadministrativa toEntity(NotificacaoadministrativaDTO notificacaoadministrativaDTO);
}
