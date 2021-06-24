package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.LocadorDTO;
import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.service.LocadorService;
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
@RequestMapping("/api/v1/locadores")
@RequiredArgsConstructor
public class LocadorController {
    private final LocadorService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Locador> locadores = service.getLocadores();
        return ResponseEntity.ok(locadores.stream().map(LocadorDTO::create));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Locador> locador = service.getLocadorById(id);
        if (!locador.isPresent()){
            return new ResponseEntity("Locador nao encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(locador.map(LocadorDTO::create));
    }
}
