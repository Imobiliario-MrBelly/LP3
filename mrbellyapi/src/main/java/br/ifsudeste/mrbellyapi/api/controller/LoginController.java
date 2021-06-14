package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.model.entity.Login;
import br.ifsudeste.mrbellyapi.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/logins")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService service = null;

    @GetMapping()
    public ResponseEntity get(){
        List<Login> logins = service.getLogins();
        return ResponseEntity.ok(logins);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Login> login = service.getLoginById(id);
        return ResponseEntity.ok(login);
    }
}
