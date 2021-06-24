package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.model.entity.Contrato;
import br.ifsudeste.mrbellyapi.model.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {
    private ContratoRepository repository;

    public ContratoService(ContratoRepository repository){
        this.repository = repository;
    }

    public List<Contrato> getContratos(){
         return repository.findAll();
    }

    public Optional<Contrato> getContratoById(Long id){
        return repository.findById(id);
    }
}
