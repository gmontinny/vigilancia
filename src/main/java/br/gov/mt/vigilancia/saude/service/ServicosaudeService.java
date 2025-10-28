package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Servicosaude;
import br.gov.mt.vigilancia.saude.dto.ServicosaudeDTO;
import br.gov.mt.vigilancia.saude.mapper.ServicosaudeMapper;
import br.gov.mt.vigilancia.saude.repository.ServicosaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicosaudeService {

    @Autowired
    private ServicosaudeRepository servicosaudeRepository;

    @Autowired
    private ServicosaudeMapper servicosaudeMapper;

    public List<ServicosaudeDTO> findAll() {
        return servicosaudeRepository.findAll().stream()
                .map(servicosaudeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ServicosaudeDTO> findById(Integer id) {
        return servicosaudeRepository.findById(id)
                .map(servicosaudeMapper::toDTO);
    }

    public ServicosaudeDTO save(ServicosaudeDTO servicosaudeDTO) {
        Servicosaude servicosaude = servicosaudeMapper.toEntity(servicosaudeDTO);
        servicosaude = servicosaudeRepository.save(servicosaude);
        return servicosaudeMapper.toDTO(servicosaude);
    }

    public void deleteById(Integer id) {
        servicosaudeRepository.deleteById(id);
    }
}
