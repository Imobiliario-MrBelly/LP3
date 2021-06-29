package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.exception.RegradeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.model.repository.LocadorRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LocadorService {
    private LocadorRepository repository;

    public LocadorService(LocadorRepository repository){
        this.repository = repository;
    }

    public List<Locador> getLocadores(){

        return repository.findAll();
    }

    public Optional<Locador> getLocadorById(Long id){
       return repository.findById(id);}
    @Transactional
    public Locador salvar(Locador locador) {
        validar(locador);
        return  repository.save(locador);
    }


    private void validar(Locador locador)  {
        if (locador.getNome()==null||locador.getNome().trim().equals("")){
            throw new RegradeNegocioException("nome invalido");
        }
    }

}
