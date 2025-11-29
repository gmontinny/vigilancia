package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Uploadvalidate;
import br.gov.mt.vigilancia.saude.dto.UploadvalidateDTO;
import br.gov.mt.vigilancia.saude.mapper.UploadvalidateMapper;
import br.gov.mt.vigilancia.saude.repository.UploadvalidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UploadvalidateService {

    @Autowired
    private UploadvalidateRepository uploadvalidateRepository;

    @Autowired
    private UploadvalidateMapper uploadvalidateMapper;

    public List<UploadvalidateDTO> findAll() {
        return uploadvalidateRepository.findAll().stream()
                .map(uploadvalidateMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UploadvalidateDTO> findById(Integer id) {
        return uploadvalidateRepository.findById(id)
                .map(uploadvalidateMapper::toDTO);
    }

    public UploadvalidateDTO save(UploadvalidateDTO uploadvalidateDTO) {
        Uploadvalidate uploadvalidate = uploadvalidateMapper.toEntity(uploadvalidateDTO);
        uploadvalidate = uploadvalidateRepository.save(uploadvalidate);
        return uploadvalidateMapper.toDTO(uploadvalidate);
    }

    public void deleteById(Integer id) {
        uploadvalidateRepository.deleteById(id);
    }
}
