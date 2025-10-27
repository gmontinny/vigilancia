package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Atividades;
import br.gov.mt.vigilancia.saude.dto.AtividadesDTO;
import br.gov.mt.vigilancia.saude.mapper.AtividadesMapper;
import br.gov.mt.vigilancia.saude.repository.AtividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtividadesService {

    @Autowired
    private AtividadesRepository atividadesRepository;

    @Autowired
    private AtividadesMapper atividadesMapper;

    public List<AtividadesDTO> findAll() {
        return atividadesRepository.findAll().stream()
                .map(atividadesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<AtividadesDTO> findById(Integer id) {
        return atividadesRepository.findById(id)
                .map(atividadesMapper::toDTO);
    }

    public AtividadesDTO save(AtividadesDTO atividadesDTO) {
        Atividades atividades = atividadesMapper.toEntity(atividadesDTO);
        atividades = atividadesRepository.save(atividades);
        return atividadesMapper.toDTO(atividades);
    }

    public void deleteById(Integer id) {
        atividadesRepository.deleteById(id);
    }
}
