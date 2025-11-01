package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Exiberoteiro;
import br.gov.mt.vigilancia.saude.dto.ExiberoteiroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExiberoteiroMapper {

    ExiberoteiroMapper INSTANCE = Mappers.getMapper(ExiberoteiroMapper.class);

    @Mapping(source = "montarroteiro.idmontarroteiro", target = "idmontarroteiro")
    @Mapping(source = "processo.numeroProcesso", target = "numprocesso")
    ExiberoteiroDTO toDTO(Exiberoteiro exiberoteiro);

    @Mapping(source = "idmontarroteiro", target = "montarroteiro.idmontarroteiro")
    @Mapping(source = "numprocesso", target = "processo.numeroProcesso")
    Exiberoteiro toEntity(ExiberoteiroDTO exiberoteiroDTO);
}
