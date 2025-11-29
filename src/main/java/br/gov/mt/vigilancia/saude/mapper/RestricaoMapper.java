package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Restricao;
import br.gov.mt.vigilancia.saude.dto.RestricaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RestricaoMapper {

    RestricaoMapper INSTANCE = Mappers.getMapper(RestricaoMapper.class);

    @Mapping(source = "estabelecimento.id", target = "idestabelecimento")
    @Mapping(source = "usuario.id", target = "idusuario")
    RestricaoDTO toDTO(Restricao restricao);

    @Mapping(source = "idestabelecimento", target = "estabelecimento.id")
    @Mapping(source = "idusuario", target = "usuario.id")
    Restricao toEntity(RestricaoDTO restricaoDTO);
}
