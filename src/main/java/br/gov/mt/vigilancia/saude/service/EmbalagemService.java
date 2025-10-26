package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Embalagem;
import br.gov.mt.vigilancia.saude.dto.EmbalagemDTO;
import br.gov.mt.vigilancia.saude.mapper.EmbalagemMapper;
import br.gov.mt.vigilancia.saude.repository.EmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmbalagemService {

    @Autowired
    private EmbalagemRepository embalagemRepository;

    @Autowired
    private EmbalagemMapper embalagemMapper;

    public List<EmbalagemDTO> findAll() {
        return embalagemRepository.findAll().stream()
                .map(embalagemMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmbalagemDTO> findById(Integer id) {
        return embalagemRepository.findById(id)
                .map(embalagemMapper::toDTO);
    }

    public EmbalagemDTO save(EmbalagemDTO embalagemDTO) {
        Embalagem embalagem = embalagemMapper.toEntity(embalagemDTO);
        embalagem = embalagemRepository.save(embalagem);
        return embalagemMapper.toDTO(embalagem);
    }

    public void deleteById(Integer id) {
        embalagemRepository.deleteById(id);
    }
}
