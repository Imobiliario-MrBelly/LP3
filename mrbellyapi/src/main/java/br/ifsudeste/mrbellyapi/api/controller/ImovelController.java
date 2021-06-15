package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.ImovelDTO;
import br.ifsudeste.mrbellyapi.service.ImovelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/imoveis")
@RequiredArgsConstructor
public class ImovelController {
    private final ImovelService service;

    @GetMapping()
    public ResponseEntity get(){
        List<ImovelDTO> imoveis = service.getImoveis();
        return ResponseEntity.ok(imoveis);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        ImovelDTO imovel = service.getImovelById(id);
        return ResponseEntity.ok(imovel);
    }
}
