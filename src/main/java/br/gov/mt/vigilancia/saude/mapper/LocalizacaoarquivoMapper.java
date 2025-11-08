package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Localizacaoarquivo;
import br.gov.mt.vigilancia.saude.dto.LocalizacaoarquivoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LocalizacaoarquivoMapper {

    LocalizacaoarquivoMapper INSTANCE = Mappers.getMapper(LocalizacaoarquivoMapper.class);

    @Mapping(source = "processo.numeroProcesso", target = "numprocesso")
    LocalizacaoarquivoDTO toDTO(Localizacaoarquivo localizacaoarquivo);

    @Mapping(source = "numprocesso", target = "processo.numeroProcesso")
    Localizacaoarquivo toEntity(LocalizacaoarquivoDTO localizacaoarquivoDTO);
}
