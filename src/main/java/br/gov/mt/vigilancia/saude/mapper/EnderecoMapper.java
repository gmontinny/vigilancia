package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Endereco;
import br.gov.mt.vigilancia.saude.dto.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    @Mapping(target = "idUsuario", expression = "java(endereco.getUsuario() != null ? endereco.getUsuario().getId() : null)")
    EnderecoDTO toDto(Endereco endereco);

    Endereco toEntity(EnderecoDTO enderecoDTO);
}
