package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itensembalagem;
import br.gov.mt.vigilancia.saude.dto.ItensembalagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItensembalagemMapper {

    ItensembalagemMapper INSTANCE = Mappers.getMapper(ItensembalagemMapper.class);

    @Mapping(source = "embalagem.idembalagem", target = "idembalagem")
    @Mapping(source = "estabelecimento.id", target = "idestabelecimento")
    ItensembalagemDTO toDTO(Itensembalagem itensembalagem);

    @Mapping(source = "idembalagem", target = "embalagem.idembalagem")
    @Mapping(source = "idestabelecimento", target = "estabelecimento.id")
    Itensembalagem toEntity(ItensembalagemDTO itensembalagemDTO);
}
