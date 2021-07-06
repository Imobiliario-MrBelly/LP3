package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.exception.RegraDeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.model.repository.ImovelRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<Imovel> getImovelByLocador(Optional<Locador> locador){
        return  repository.findByLocador(locador);
    }

    @Transactional
    public Imovel salvar(Imovel imovel) {
        validar(imovel);
        return repository.save(imovel);
    }

    public void validar(Imovel imovel) {

        if (imovel.getLocador() == null) {
            throw new RegraDeNegocioException("Locador inválido");
        }
        
        if (imovel.getEndereco() == null) {
            throw new RegraDeNegocioException("Endereço inválido");
        }
        if (imovel.getDescricao() == null) {
            throw new RegraDeNegocioException("Descricao inválido");
        }
    }
}
