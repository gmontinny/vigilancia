package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Notificacaorecursoadministrativo;
import br.gov.mt.vigilancia.saude.dto.NotificacaorecursoadministrativoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacaorecursoadministrativoMapper {

    NotificacaorecursoadministrativoMapper INSTANCE = Mappers.getMapper(NotificacaorecursoadministrativoMapper.class);

    NotificacaorecursoadministrativoDTO toDTO(Notificacaorecursoadministrativo notificacaorecursoadministrativo);
    Notificacaorecursoadministrativo toEntity(NotificacaorecursoadministrativoDTO notificacaorecursoadministrativoDTO);
}
