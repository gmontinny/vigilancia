package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Usuario;
import br.gov.mt.vigilancia.saude.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {EnderecoMapper.class, FiscalMapper.class, PermissaoMapper.class})
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "enderecos", target = "enderecos")
    @Mapping(source = "fiscais", target = "fiscais")
    @Mapping(source = "permissoes", target = "permissoes")
    UsuarioDTO toDto(Usuario usuario);

    @Mapping(target = "enderecos", ignore = true)
    @Mapping(target = "fiscais", ignore = true)
    @Mapping(target = "permissoes", ignore = true)
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
