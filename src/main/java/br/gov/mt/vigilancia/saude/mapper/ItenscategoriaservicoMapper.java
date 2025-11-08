package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Itenscategoriaservico;
import br.gov.mt.vigilancia.saude.dto.ItenscategoriaservicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ItenscategoriaservicoMapper {

    ItenscategoriaservicoMapper INSTANCE = Mappers.getMapper(ItenscategoriaservicoMapper.class);

    ItenscategoriaservicoDTO toDTO(Itenscategoriaservico itenscategoriaservico);
    Itenscategoriaservico toEntity(ItenscategoriaservicoDTO itenscategoriaservicoDTO);
}
