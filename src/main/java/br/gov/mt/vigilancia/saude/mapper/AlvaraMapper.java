package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Alvara;
import br.gov.mt.vigilancia.saude.dto.AlvaraDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {EstabelecimentoMapper.class})
public interface AlvaraMapper {

    AlvaraMapper INSTANCE = Mappers.getMapper(AlvaraMapper.class);

    @Mapping(source = "estabelecimento.id", target = "idEstabelecimento")
    AlvaraDTO toDto(Alvara alvara);

    @Mapping(target = "estabelecimento", ignore = true)
    Alvara toEntity(AlvaraDTO alvaraDTO);
}
