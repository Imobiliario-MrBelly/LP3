package br.ifsudeste.mrbellyapi.api.controller;


import br.ifsudeste.mrbellyapi.api.dto.ContratoDTO;
import br.ifsudeste.mrbellyapi.service.ContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contratos")
@RequiredArgsConstructor
public class ContratoController {
    private final ContratoService service ;

    @GetMapping()
    public ResponseEntity get(){
        List<ContratoDTO> contratos = service.getContratos();
        return ResponseEntity.ok(contratos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        ContratoDTO contrato = service.getContratoById(id);
        return ResponseEntity.ok(contrato);
    }
}
