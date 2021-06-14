package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.LoginDTO;
import br.ifsudeste.mrbellyapi.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logins")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService service ;

    @GetMapping()
    public ResponseEntity get(){
        List<LoginDTO> logins = service.getLogins();
        return ResponseEntity.ok(logins);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        LoginDTO login = service.getLoginById(id);
        return ResponseEntity.ok(login);
    }
}
