package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Geraprocesso;
import br.gov.mt.vigilancia.saude.dto.GeraprocessoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeraprocessoMapper {

    GeraprocessoMapper INSTANCE = Mappers.getMapper(GeraprocessoMapper.class);

    GeraprocessoDTO toDTO(Geraprocesso geraprocesso);
    Geraprocesso toEntity(GeraprocessoDTO geraprocessoDTO);
}
