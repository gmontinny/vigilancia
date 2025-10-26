package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Permissao;
import br.gov.mt.vigilancia.saude.dto.PermissaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {TabelaMapper.class, UsuarioMapper.class})
public interface PermissaoMapper {

    PermissaoMapper INSTANCE = Mappers.getMapper(PermissaoMapper.class);

    @Mapping(source = "tabela.id", target = "idTabela")
    @Mapping(source = "usuario.id", target = "idUsuario")
    PermissaoDTO toDto(Permissao permissao);

    @Mapping(target = "tabela", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Permissao toEntity(PermissaoDTO permissaoDTO);
}
