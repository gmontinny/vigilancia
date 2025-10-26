package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Veiculo;
import br.gov.mt.vigilancia.saude.dto.VeiculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class, EstabelecimentoMapper.class})
public interface VeiculoMapper {

    VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);

    @Mapping(source = "categoria.id", target = "idCategoria")
    @Mapping(source = "estabelecimento.id", target = "idEstabelecimento")
    VeiculoDTO toDto(Veiculo veiculo);

    @Mapping(target = "categoria", ignore = true)
    @Mapping(target = "estabelecimento", ignore = true)
    Veiculo toEntity(VeiculoDTO veiculoDTO);
}
