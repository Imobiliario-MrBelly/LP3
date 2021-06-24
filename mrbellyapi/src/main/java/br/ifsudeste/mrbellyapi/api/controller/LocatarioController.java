package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.LocatarioDTO;
import br.ifsudeste.mrbellyapi.model.entity.Locatario;
import br.ifsudeste.mrbellyapi.service.LocatarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/locatarios")
@RequiredArgsConstructor
public class LocatarioController {
    private final LocatarioService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Locatario> locatarios = service.getLocatarios();
        return ResponseEntity.ok(locatarios.stream().map(LocatarioDTO::create));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Locatario> locatario = service.getLocatarioById(id);
        if (!locatario.isPresent()){
            return new ResponseEntity("locatario nao encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(locatario.map(LocatarioDTO::create));
    }
}
