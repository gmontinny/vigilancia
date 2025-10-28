package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Servicosaude;
import br.gov.mt.vigilancia.saude.dto.ServicosaudeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServicosaudeMapper {

    ServicosaudeMapper INSTANCE = Mappers.getMapper(ServicosaudeMapper.class);

    @Mapping(source = "agrupamento.idagrupamento", target = "idagrupamento")
    @Mapping(source = "categoriaservico.idcategoriaservico", target = "idcategoriaservico")
    ServicosaudeDTO toDTO(Servicosaude servicosaude);

    @Mapping(source = "idagrupamento", target = "agrupamento.idagrupamento")
    @Mapping(source = "idcategoriaservico", target = "categoriaservico.idcategoriaservico")
    Servicosaude toEntity(ServicosaudeDTO servicosaudeDTO);
}
