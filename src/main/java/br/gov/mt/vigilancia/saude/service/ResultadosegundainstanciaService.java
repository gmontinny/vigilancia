package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Resultadosegundainstancia;
import br.gov.mt.vigilancia.saude.dto.ResultadosegundainstanciaDTO;
import br.gov.mt.vigilancia.saude.mapper.ResultadosegundainstanciaMapper;
import br.gov.mt.vigilancia.saude.repository.ResultadosegundainstanciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResultadosegundainstanciaService {

    @Autowired
    private ResultadosegundainstanciaRepository resultadosegundainstanciaRepository;

    @Autowired
    private ResultadosegundainstanciaMapper resultadosegundainstanciaMapper;

    public List<ResultadosegundainstanciaDTO> findAll() {
        return resultadosegundainstanciaRepository.findAll().stream()
                .map(resultadosegundainstanciaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ResultadosegundainstanciaDTO> findById(Integer id) {
        return resultadosegundainstanciaRepository.findById(id)
                .map(resultadosegundainstanciaMapper::toDTO);
    }

    public ResultadosegundainstanciaDTO save(ResultadosegundainstanciaDTO resultadosegundainstanciaDTO) {
        Resultadosegundainstancia resultadosegundainstancia = resultadosegundainstanciaMapper.toEntity(resultadosegundainstanciaDTO);
        resultadosegundainstancia = resultadosegundainstanciaRepository.save(resultadosegundainstancia);
        return resultadosegundainstanciaMapper.toDTO(resultadosegundainstancia);
    }

    public void deleteById(Integer id) {
        resultadosegundainstanciaRepository.deleteById(id);
    }
}
