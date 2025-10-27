package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Atividades;
import br.gov.mt.vigilancia.saude.dto.AtividadesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AtividadesMapper {

    AtividadesMapper INSTANCE = Mappers.getMapper(AtividadesMapper.class);

    AtividadesDTO toDTO(Atividades atividades);
    Atividades toEntity(AtividadesDTO atividadesDTO);
}
