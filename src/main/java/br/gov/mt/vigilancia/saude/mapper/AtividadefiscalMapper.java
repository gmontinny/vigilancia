package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Atividadefiscal;
import br.gov.mt.vigilancia.saude.dto.AtividadefiscalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AtividadefiscalMapper {

    AtividadefiscalMapper INSTANCE = Mappers.getMapper(AtividadefiscalMapper.class);

    AtividadefiscalDTO toDTO(Atividadefiscal atividadefiscal);
    Atividadefiscal toEntity(AtividadefiscalDTO atividadefiscalDTO);
}
