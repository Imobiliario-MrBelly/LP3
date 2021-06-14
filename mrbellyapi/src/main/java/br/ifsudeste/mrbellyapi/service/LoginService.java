package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.dto.LoginDTO;
import br.ifsudeste.mrbellyapi.model.entity.Login;
import br.ifsudeste.mrbellyapi.model.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginService {
    private LoginRepository repository;

    public LoginService(LoginRepository repository){
        this.repository = repository;
    }

    public List<LoginDTO> getLogins(){
        List<LoginDTO> list= repository.findAll().stream().map(LoginDTO::create).collect(Collectors.toList());
        return list;
    }

    public LoginDTO getLoginById(Long id){
        Optional<Login> login = repository.findById(id);
        return login.map(LoginDTO::create).orElseThrow(()->new RuntimeException("Login nao encontrado"));
    }
}
