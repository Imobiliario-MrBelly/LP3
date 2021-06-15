package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.LocatarioDTO;
import br.ifsudeste.mrbellyapi.service.LocatarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locatarios")
@RequiredArgsConstructor
public class LocatarioController {
    private final LocatarioService service;

    @GetMapping()
    public ResponseEntity get(){
        List<LocatarioDTO> locatarios = service.getLocatarios();
        return ResponseEntity.ok(locatarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        LocatarioDTO locatario = service.getLocatarioById(id);
        return ResponseEntity.ok(locatario);
    }
}
