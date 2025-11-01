package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Montarroteiro;
import br.gov.mt.vigilancia.saude.dto.MontarroteiroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MontarroteiroMapper {

    MontarroteiroMapper INSTANCE = Mappers.getMapper(MontarroteiroMapper.class);

    @Mapping(source = "roteiro.id", target = "idroteiro")
    MontarroteiroDTO toDTO(Montarroteiro montarroteiro);

    @Mapping(source = "idroteiro", target = "roteiro.id")
    Montarroteiro toEntity(MontarroteiroDTO montarroteiroDTO);
}
