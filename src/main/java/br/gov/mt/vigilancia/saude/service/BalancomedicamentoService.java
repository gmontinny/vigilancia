package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Balancomedicamento;
import br.gov.mt.vigilancia.saude.dto.BalancomedicamentoDTO;
import br.gov.mt.vigilancia.saude.mapper.BalancomedicamentoMapper;
import br.gov.mt.vigilancia.saude.repository.BalancomedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BalancomedicamentoService {

    @Autowired
    private BalancomedicamentoRepository balancomedicamentoRepository;

    @Autowired
    private BalancomedicamentoMapper balancomedicamentoMapper;

    public List<BalancomedicamentoDTO> findAll() {
        return balancomedicamentoRepository.findAll().stream()
                .map(balancomedicamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<BalancomedicamentoDTO> findById(Integer id) {
        return balancomedicamentoRepository.findById(id)
                .map(balancomedicamentoMapper::toDTO);
    }

    public BalancomedicamentoDTO save(BalancomedicamentoDTO balancomedicamentoDTO) {
        Balancomedicamento balancomedicamento = balancomedicamentoMapper.toEntity(balancomedicamentoDTO);
        balancomedicamento = balancomedicamentoRepository.save(balancomedicamento);
        return balancomedicamentoMapper.toDTO(balancomedicamento);
    }

    public void deleteById(Integer id) {
        balancomedicamentoRepository.deleteById(id);
    }
}
