package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.exception.RegradeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Contrato;
import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.model.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
    
    @Transactional
    public Imovel salvar(Imovel imovel) {
        validar(imovel);
        return repository.save(imovel);
    }

    public void validar(Imovel imovel) {

        if (imovel.getLocador() == null) {
            throw new RegradeNegocioException("Locador inválido");
        }
        
        if (imovel.getEndereco() == null) {
            throw new RegradeNegocioException("Endereço inválido");
        }
    }
}
