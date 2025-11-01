package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Docnecessario;
import br.gov.mt.vigilancia.saude.dto.DocnecessarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UploadnecessarioMapper.class})
public interface DocnecessarioMapper {

    DocnecessarioMapper INSTANCE = Mappers.getMapper(DocnecessarioMapper.class);

    @Mapping(source = "agrupamento.idagrupamento", target = "idagrupamento")
    @Mapping(source = "itenssolicitacao.iditenssolicitacao", target = "iditenssolicitacao")
    @Mapping(source = "documento.id", target = "iddocumento")
    @Mapping(target = "uploadnecessarios", source = "uploadnecessarios")
    DocnecessarioDTO toDTO(Docnecessario docnecessario);

    @Mapping(source = "idagrupamento", target = "agrupamento.idagrupamento")
    @Mapping(source = "iditenssolicitacao", target = "itenssolicitacao.iditenssolicitacao")
    @Mapping(source = "iddocumento", target = "documento.id")
    @Mapping(target = "uploadnecessarios", source = "uploadnecessarios")
    Docnecessario toEntity(DocnecessarioDTO docnecessarioDTO);
}
