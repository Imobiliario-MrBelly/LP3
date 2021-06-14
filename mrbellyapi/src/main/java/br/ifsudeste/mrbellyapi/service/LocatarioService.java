package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.dto.LocatarioDTO;
import br.ifsudeste.mrbellyapi.model.entity.Locatario;
import br.ifsudeste.mrbellyapi.model.repository.LocatarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocatarioService {
    private LocatarioRepository repository;

    public LocatarioService(LocatarioRepository repository){
        this.repository = repository;
    }

    public List<LocatarioDTO> getLocatarios(){
        List<LocatarioDTO> list= repository.findAll().stream().map(LocatarioDTO::create).collect(Collectors.toList());
        return list;
    }

    public LocatarioDTO getLocatarioById(Long id){
        Optional<Locatario> locatario = repository.findById(id);
        return locatario.map(LocatarioDTO::create).orElseThrow(()->new RuntimeException("Locatario nao encontrado"));
    }
}
