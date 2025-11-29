package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Resultadoprimeirainstancia;
import br.gov.mt.vigilancia.saude.dto.ResultadoprimeirainstanciaDTO;
import br.gov.mt.vigilancia.saude.mapper.ResultadoprimeirainstanciaMapper;
import br.gov.mt.vigilancia.saude.repository.ResultadoprimeirainstanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultadoprimeirainstanciaService {

    @Autowired
    private ResultadoprimeirainstanciaRepository resultadoprimeirainstanciaRepository;

    @Autowired
    private ResultadoprimeirainstanciaMapper resultadoprimeirainstanciaMapper;

    public List<ResultadoprimeirainstanciaDTO> findAll() {
        return resultadoprimeirainstanciaRepository.findAll().stream()
                .map(resultadoprimeirainstanciaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ResultadoprimeirainstanciaDTO> findById(Integer id) {
        return resultadoprimeirainstanciaRepository.findById(id)
                .map(resultadoprimeirainstanciaMapper::toDTO);
    }

    public ResultadoprimeirainstanciaDTO save(ResultadoprimeirainstanciaDTO resultadoprimeirainstanciaDTO) {
        Resultadoprimeirainstancia resultadoprimeirainstancia = resultadoprimeirainstanciaMapper.toEntity(resultadoprimeirainstanciaDTO);
        resultadoprimeirainstancia = resultadoprimeirainstanciaRepository.save(resultadoprimeirainstancia);
        return resultadoprimeirainstanciaMapper.toDTO(resultadoprimeirainstancia);
    }

    public void deleteById(Integer id) {
        resultadoprimeirainstanciaRepository.deleteById(id);
    }
}
