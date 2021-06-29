package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.exception.RegradeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.model.entity.Locatario;
import br.ifsudeste.mrbellyapi.model.repository.LocatarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class LocatarioService {
    private LocatarioRepository repository;

    public LocatarioService(LocatarioRepository repository){
        this.repository = repository;
    }

    public List<Locatario> getLocatarios(){
        return repository.findAll();
    }

    public Optional<Locatario> getLocatarioById(Long id){
       return repository.findById(id);
    }
    
    @Transactional
    public Locatario salvar(Locatario locatario) {
        validar(locatario);
        return repository.save(locatario);
    }

    public void validar(Locatario locatario) {

    	if (locatario.getNome()==null||locatario.getNome().trim().equals("")){
            throw new RegradeNegocioException("Nome inválido");
        }
    	
        if (locatario.getLogin() == null) {
            throw new RegradeNegocioException("Login inválido");
        }
        
        
    }
}
