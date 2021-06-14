package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.service.LocadorService;
import lombok.RequiredArgsConstructor;
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
    private final LocadorService service = null;

    @GetMapping()
    public ResponseEntity get(){
        List<Locador> locadors = service.getLocadores();
        return ResponseEntity.ok(locadors);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Locador> locador = service.getLocadorById(id);
        return ResponseEntity.ok(locador);
    }
}
