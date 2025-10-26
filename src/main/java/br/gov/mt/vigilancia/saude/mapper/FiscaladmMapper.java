package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Fiscaladm;

import br.gov.mt.vigilancia.saude.domain.Usuario;
import br.gov.mt.vigilancia.saude.dto.FiscaladmDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FiscaladmMapper {
    FiscaladmMapper INSTANCE = Mappers.getMapper(FiscaladmMapper.class);

    @Mapping(source = "usuario.id", target = "idUsuario")
    FiscaladmDTO toDTO(Fiscaladm fiscaladm);

    @Mapping(source = "idUsuario", target = "usuario")
    Fiscaladm toEntity(FiscaladmDTO fiscaladmDTO);

    default Usuario usuarioFromId(Integer idUsuario) {
        if (idUsuario == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        return usuario;
    }
}
