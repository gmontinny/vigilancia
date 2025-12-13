package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.dto.FiscalDTO;
import br.gov.mt.vigilancia.saude.mapper.FiscalMapper;
import br.gov.mt.vigilancia.saude.repository.FiscalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FiscalService {

    private final FiscalRepository fiscalRepository;
    private final FiscalMapper fiscalMapper;

    public List<FiscalDTO> findAll() {
        return fiscalRepository.findAll()
                .stream()
                .map(fiscalMapper::toDto)
                .collect(Collectors.toList());
    }

    public FiscalDTO findById(Integer id) {
        return fiscalRepository.findById(id)
                .map(fiscalMapper::toDto)
                .orElse(null);
    }

    public FiscalDTO save(FiscalDTO fiscalDTO) {
        var entity = fiscalMapper.toEntity(fiscalDTO);
        var saved = fiscalRepository.save(entity);
        return fiscalMapper.toDto(saved);
    }

    public FiscalDTO update(Integer id, FiscalDTO fiscalDTO) {
        return fiscalRepository.findById(id)
                .map(existing -> {
                    var entity = fiscalMapper.toEntity(fiscalDTO);

                    return fiscalMapper.toDto(fiscalRepository.save(entity));
                })
                .orElse(null);
    }

    public void delete(Integer id) {
        fiscalRepository.deleteById(id);
    }
}
