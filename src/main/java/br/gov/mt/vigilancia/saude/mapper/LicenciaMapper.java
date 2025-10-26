package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Licencia;
import br.gov.mt.vigilancia.saude.dto.LicenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VeiculoMapper.class})
public interface LicenciaMapper {

    LicenciaMapper INSTANCE = Mappers.getMapper(LicenciaMapper.class);

    @Mapping(source = "veiculo.id", target = "idVeiculo")
    LicenciaDTO toDto(Licencia licencia);

    @Mapping(target = "veiculo", ignore = true)
    Licencia toEntity(LicenciaDTO licenciaDTO);
}
