package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.model.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {
    private ImovelRepository repository;

    public ImovelService(ImovelRepository repository){
        this.repository = repository;
    }

    public List<Imovel> getImoveis(){
        return repository.findAll();
    }

    public Optional<Imovel> getImovelById(Long id){
       return repository.findById(id);
    }
}
