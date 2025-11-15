package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Notificacaorecurso;
import br.gov.mt.vigilancia.saude.dto.NotificacaorecursoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotificacaorecursoMapper {

    NotificacaorecursoMapper INSTANCE = Mappers.getMapper(NotificacaorecursoMapper.class);

    NotificacaorecursoDTO toDTO(Notificacaorecurso notificacaorecurso);
    Notificacaorecurso toEntity(NotificacaorecursoDTO notificacaorecursoDTO);
}
