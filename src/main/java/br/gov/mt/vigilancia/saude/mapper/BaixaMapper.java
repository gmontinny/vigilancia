package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Baixa;
import br.gov.mt.vigilancia.saude.dto.BaixaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {EstabelecimentoMapper.class, ResponsavelTecnicoMapper.class})
public interface BaixaMapper {

    BaixaMapper INSTANCE = Mappers.getMapper(BaixaMapper.class);

    @Mapping(source = "estabelecimento.id", target = "idEstabelecimento")
    @Mapping(source = "responsavelTecnico.id", target = "idResponsavelTecnico")
    BaixaDTO toDto(Baixa baixa);

    @Mapping(target = "estabelecimento", ignore = true)
    @Mapping(target = "responsavelTecnico", ignore = true)
    Baixa toEntity(BaixaDTO baixaDTO);
}
