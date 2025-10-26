package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Log;
import br.gov.mt.vigilancia.saude.dto.LogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface LogMapper {

    LogMapper INSTANCE = Mappers.getMapper(LogMapper.class);

    @Mapping(source = "usuario.id", target = "idUsuario")
    LogDTO toDto(Log log);

    @Mapping(target = "usuario", ignore = true)
    Log toEntity(LogDTO logDTO);
}
