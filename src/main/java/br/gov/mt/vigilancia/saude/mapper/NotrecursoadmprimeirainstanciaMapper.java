package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Notrecursoadmprimeirainstancia;
import br.gov.mt.vigilancia.saude.dto.NotrecursoadmprimeirainstanciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotrecursoadmprimeirainstanciaMapper {

    NotrecursoadmprimeirainstanciaMapper INSTANCE = Mappers.getMapper(NotrecursoadmprimeirainstanciaMapper.class);

    NotrecursoadmprimeirainstanciaDTO toDTO(Notrecursoadmprimeirainstancia notrecursoadmprimeirainstancia);
    Notrecursoadmprimeirainstancia toEntity(NotrecursoadmprimeirainstanciaDTO notrecursoadmprimeirainstanciaDTO);
}
