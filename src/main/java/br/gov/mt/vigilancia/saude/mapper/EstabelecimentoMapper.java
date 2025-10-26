package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Estabelecimento;
import br.gov.mt.vigilancia.saude.dto.EstabelecimentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstabelecimentoMapper {

    EstabelecimentoMapper INSTANCE = Mappers.getMapper(EstabelecimentoMapper.class);

    @Mapping(source = "usuario.id", target = "idUsuario")
    @Mapping(source = "responsavelTecnico.id", target = "idResponsavelTecnico")
    @Mapping(source = "tipoEmpresa.id", target = "idTipoEmpresa")
    EstabelecimentoDTO toDto(Estabelecimento estabelecimento);

    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "responsavelTecnico", ignore = true)
    @Mapping(target = "tipoEmpresa", ignore = true)
    Estabelecimento toEntity(EstabelecimentoDTO estabelecimentoDTO);
}
