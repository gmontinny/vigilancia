package br.gov.mt.vigilancia.saude.mapper;

import br.gov.mt.vigilancia.saude.domain.Atividadevigilancia;
import br.gov.mt.vigilancia.saude.dto.AtividadevigilanciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AtividadevigilanciaMapper {

    AtividadevigilanciaMapper INSTANCE = Mappers.getMapper(AtividadevigilanciaMapper.class);

    AtividadevigilanciaDTO toDTO(Atividadevigilancia atividadevigilancia);
    Atividadevigilancia toEntity(AtividadevigilanciaDTO atividadevigilanciaDTO);
}
