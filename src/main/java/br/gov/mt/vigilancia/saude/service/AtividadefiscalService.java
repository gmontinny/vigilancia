package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Atividadefiscal;
import br.gov.mt.vigilancia.saude.dto.AtividadefiscalDTO;
import br.gov.mt.vigilancia.saude.mapper.AtividadefiscalMapper;
import br.gov.mt.vigilancia.saude.repository.AtividadefiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtividadefiscalService {

    @Autowired
    private AtividadefiscalRepository atividadefiscalRepository;

    @Autowired
    private AtividadefiscalMapper atividadefiscalMapper;

    public List<AtividadefiscalDTO> findAll() {
        return atividadefiscalRepository.findAll().stream()
                .map(atividadefiscalMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AtividadefiscalDTO> findById(Integer id) {
        return atividadefiscalRepository.findById(id)
                .map(atividadefiscalMapper::toDTO);
    }

    public AtividadefiscalDTO save(AtividadefiscalDTO atividadefiscalDTO) {
        Atividadefiscal atividadefiscal = atividadefiscalMapper.toEntity(atividadefiscalDTO);
        atividadefiscal = atividadefiscalRepository.save(atividadefiscal);
        return atividadefiscalMapper.toDTO(atividadefiscal);
    }

    public void deleteById(Integer id) {
        atividadefiscalRepository.deleteById(id);
    }
}
