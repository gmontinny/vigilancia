package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Fiscal;
import br.gov.mt.vigilancia.saude.dto.FiscalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface FiscalMapper {

    FiscalMapper INSTANCE = Mappers.getMapper(FiscalMapper.class);

    @Mapping(source = "usuario.id", target = "idUsuario")
    FiscalDTO toDto(Fiscal fiscal);

    @Mapping(target = "usuario", ignore = true)
    Fiscal toEntity(FiscalDTO fiscalDTO);
}
