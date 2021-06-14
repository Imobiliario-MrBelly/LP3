package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.dto.ImovelDTO;
import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.model.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImovelService {
    private ImovelRepository repository;

    public ImovelService(ImovelRepository repository){
        this.repository = repository;
    }

    public List<ImovelDTO> getImoveis(){
        List<ImovelDTO> list= repository.findAll().stream().map(ImovelDTO::create).collect(Collectors.toList());
        return list;
    }

    public ImovelDTO getImovelById(Long id){
        Optional<Imovel> imovel = repository.findById(id);
        return imovel.map(ImovelDTO::create).orElseThrow(()->new RuntimeException("Imovel nao encontrado"));
    }
}
