package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Retinoico;
import br.gov.mt.vigilancia.saude.dto.RetinoicoDTO;
import br.gov.mt.vigilancia.saude.mapper.RetinoicoMapper;
import br.gov.mt.vigilancia.saude.repository.RetinoicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RetinoicoService {

    @Autowired
    private RetinoicoRepository retinoicoRepository;

    @Autowired
    private RetinoicoMapper retinoicoMapper;

    public List<RetinoicoDTO> findAll() {
        return retinoicoRepository.findAll().stream()
                .map(retinoicoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RetinoicoDTO> findById(Integer id) {
        return retinoicoRepository.findById(id)
                .map(retinoicoMapper::toDTO);
    }

    public RetinoicoDTO save(RetinoicoDTO retinoicoDTO) {
        Retinoico retinoico = retinoicoMapper.toEntity(retinoicoDTO);
        retinoico = retinoicoRepository.save(retinoico);
        return retinoicoMapper.toDTO(retinoico);
    }

    public void deleteById(Integer id) {
        retinoicoRepository.deleteById(id);
    }
}
