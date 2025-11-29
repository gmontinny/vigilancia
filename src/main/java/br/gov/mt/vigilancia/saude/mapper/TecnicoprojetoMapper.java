package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Conselho;
import br.gov.mt.vigilancia.saude.domain.Tecnicoprojeto;
import br.gov.mt.vigilancia.saude.dto.TecnicoprojetoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TecnicoprojetoMapper {

    TecnicoprojetoMapper INSTANCE = Mappers.getMapper(TecnicoprojetoMapper.class);

    // Map nested entity id -> flat id in DTO
    @Mapping(source = "conselho.id", target = "idconselho")
    TecnicoprojetoDTO toDTO(Tecnicoprojeto tecnicoprojeto);

    // Map flat id in DTO -> nested entity using helper
    @Mapping(source = "idconselho", target = "conselho")
    Tecnicoprojeto toEntity(TecnicoprojetoDTO tecnicoprojetoDTO);

    // Helper to instantiate Conselho from id
    default Conselho mapConselho(Integer id) {
        if (id == null) {
            return null;
        }
        Conselho c = new Conselho();
        c.setId(id);
        return c;
    }
}
