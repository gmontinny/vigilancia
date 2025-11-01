package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Uploadnecessario;
import br.gov.mt.vigilancia.saude.dto.UploadnecessarioDTO;
import br.gov.mt.vigilancia.saude.mapper.UploadnecessarioMapper;
import br.gov.mt.vigilancia.saude.repository.UploadnecessarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UploadnecessarioService {

    @Autowired
    private UploadnecessarioRepository uploadnecessarioRepository;

    @Autowired
    private UploadnecessarioMapper uploadnecessarioMapper;

    public List<UploadnecessarioDTO> findAll() {
        return uploadnecessarioRepository.findAll().stream()
                .map(uploadnecessarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UploadnecessarioDTO> findById(Integer id) {
        return uploadnecessarioRepository.findById(id)
                .map(uploadnecessarioMapper::toDTO);
    }

    public UploadnecessarioDTO save(UploadnecessarioDTO uploadnecessarioDTO) {
        Uploadnecessario uploadnecessario = uploadnecessarioMapper.toEntity(uploadnecessarioDTO);
        uploadnecessario = uploadnecessarioRepository.save(uploadnecessario);
        return uploadnecessarioMapper.toDTO(uploadnecessario);
    }

    public void deleteById(Integer id) {
        uploadnecessarioRepository.deleteById(id);
    }
}
