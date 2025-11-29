package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Uploadrestricao;
import br.gov.mt.vigilancia.saude.dto.UploadrestricaoDTO;
import br.gov.mt.vigilancia.saude.mapper.UploadrestricaoMapper;
import br.gov.mt.vigilancia.saude.repository.UploadrestricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UploadrestricaoService {

    @Autowired
    private UploadrestricaoRepository uploadrestricaoRepository;

    @Autowired
    private UploadrestricaoMapper uploadrestricaoMapper;

    public List<UploadrestricaoDTO> findAll() {
        return uploadrestricaoRepository.findAll().stream()
                .map(uploadrestricaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UploadrestricaoDTO> findById(Integer id) {
        return uploadrestricaoRepository.findById(id)
                .map(uploadrestricaoMapper::toDTO);
    }

    public UploadrestricaoDTO save(UploadrestricaoDTO uploadrestricaoDTO) {
        Uploadrestricao uploadrestricao = uploadrestricaoMapper.toEntity(uploadrestricaoDTO);
        uploadrestricao = uploadrestricaoRepository.save(uploadrestricao);
        return uploadrestricaoMapper.toDTO(uploadrestricao);
    }

    public void deleteById(Integer id) {
        uploadrestricaoRepository.deleteById(id);
    }
}
