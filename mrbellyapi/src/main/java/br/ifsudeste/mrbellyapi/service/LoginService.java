package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.model.entity.Login;
import br.ifsudeste.mrbellyapi.model.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private LoginRepository repository;

    public LoginService(LoginRepository repository){
        this.repository = repository;
    }

    public List<Login> getLogins(){
        return repository.findAll();
    }

    public Optional<Login> getLoginById(Long id){
        return repository.findById(id);
    }
}
