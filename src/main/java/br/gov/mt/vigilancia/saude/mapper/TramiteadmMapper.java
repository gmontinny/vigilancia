package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Tramiteadm;
import br.gov.mt.vigilancia.saude.dto.TramiteadmDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TramiteadmMapper {

    TramiteadmMapper INSTANCE = Mappers.getMapper(TramiteadmMapper.class);

    TramiteadmDTO toDTO(Tramiteadm tramiteadm);
    Tramiteadm toEntity(TramiteadmDTO tramiteadmDTO);
}
