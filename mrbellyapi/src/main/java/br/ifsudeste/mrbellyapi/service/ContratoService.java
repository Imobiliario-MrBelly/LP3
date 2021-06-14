package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.dto.ContratoDTO;
import br.ifsudeste.mrbellyapi.model.entity.Contrato;
import br.ifsudeste.mrbellyapi.model.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoService {
    private ContratoRepository repository;

    public ContratoService(ContratoRepository repository){
        this.repository = repository;
    }

    public List<ContratoDTO> getContratos(){
        List<ContratoDTO> list= repository.findAll().stream().map(ContratoDTO::create).collect(Collectors.toList());
        return list;
    }

    public ContratoDTO getContratoById(Long id){
        Optional<Contrato> contrato = repository.findById(id);
        return contrato.map(ContratoDTO::create).orElseThrow(()->new RuntimeException("contrato nao encontrado"));
    }
}
