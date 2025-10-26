package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geraprodi;
import br.gov.mt.vigilancia.saude.dto.GeraprodiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeraprodiMapper {
    GeraprodiMapper INSTANCE = Mappers.getMapper(GeraprodiMapper.class);

    @Mapping(source = "idGeraprodi", target = "idGeraprodi")
    @Mapping(source = "dataProdi", target = "dataProdi")
    @Mapping(source = "horaProdi", target = "horaProdi")
    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "statusProdi", target = "statusProdi")
    GeraprodiDTO toDTO(Geraprodi geraprodi);

    @Mapping(source = "idGeraprodi", target = "idGeraprodi")
    @Mapping(source = "dataProdi", target = "dataProdi")
    @Mapping(source = "horaProdi", target = "horaProdi")
    @Mapping(source = "idUsuario", target = "idUsuario")
    @Mapping(source = "statusProdi", target = "statusProdi")
    Geraprodi toEntity(GeraprodiDTO geraprodiDTO);
}
