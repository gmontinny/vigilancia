package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Termocolheita;
import br.gov.mt.vigilancia.saude.dto.TermocolheitaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TermocolheitaMapper {

    TermocolheitaMapper INSTANCE = Mappers.getMapper(TermocolheitaMapper.class);

    @Mapping(source = "produtocategoria.idprodutocategoria", target = "idprodutocategoria")
    @Mapping(source = "motivo.id", target = "idmotivo")
    TermocolheitaDTO toDTO(Termocolheita termocolheita);

    @Mapping(source = "idprodutocategoria", target = "produtocategoria.idprodutocategoria")
    @Mapping(source = "idmotivo", target = "motivo.id")
    Termocolheita toEntity(TermocolheitaDTO termocolheitaDTO);
}
