package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.exception.RegraDeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Contrato;
import br.ifsudeste.mrbellyapi.model.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
    
    @Transactional
    public Contrato salvar(Contrato contrato) {
        validar(contrato);
        return repository.save(contrato);
    }

    public void validar(Contrato contrato) {

        if (contrato.getLocatario() == null) {
            throw new RegraDeNegocioException("Locatário inválido");
        }
        
        if (contrato.getImovel() == null) {
            throw new RegraDeNegocioException("Imovél inválido");
        }
    }
}
