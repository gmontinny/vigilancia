package br.gov.mt.vigilancia.saude.service;

import br.gov.mt.vigilancia.saude.domain.Carteirinha;
import br.gov.mt.vigilancia.saude.dto.CarteirinhaDTO;
import br.gov.mt.vigilancia.saude.mapper.CarteirinhaMapper;
import br.gov.mt.vigilancia.saude.repository.CarteirinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarteirinhaService {

    @Autowired
    private CarteirinhaRepository carteirinhaRepository;

    @Autowired
    private CarteirinhaMapper carteirinhaMapper;

    public List<CarteirinhaDTO> findAll() {
        return carteirinhaRepository.findAll().stream()
                .map(carteirinhaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<CarteirinhaDTO> findById(Integer id) {
        return carteirinhaRepository.findById(id)
                .map(carteirinhaMapper::toDTO);
    }

    public CarteirinhaDTO save(CarteirinhaDTO carteirinhaDTO) {
        Carteirinha carteirinha = carteirinhaMapper.toEntity(carteirinhaDTO);
        carteirinha = carteirinhaRepository.save(carteirinha);
        return carteirinhaMapper.toDTO(carteirinha);
    }

    public void deleteById(Integer id) {
        carteirinhaRepository.deleteById(id);
    }
}
