package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Processo;
import br.gov.mt.vigilancia.saude.dto.ProcessoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProcessoMapper {

    ProcessoMapper INSTANCE = Mappers.getMapper(ProcessoMapper.class);

    @Mapping(source = "usuario.id", target = "idUsuario")
    ProcessoDTO toDto(Processo processo);

    @Mapping(target = "usuario", ignore = true)
    Processo toEntity(ProcessoDTO processoDTO);
}
