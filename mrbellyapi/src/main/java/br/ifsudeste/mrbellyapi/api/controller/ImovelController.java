package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.ImovelDTO;
import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.service.ImovelService;
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
@RequestMapping("/api/v1/imoveis")
@RequiredArgsConstructor
public class ImovelController {
    private final ImovelService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Imovel> imoveis = service.getImoveis();
        return ResponseEntity.ok(imoveis.stream().map(ImovelDTO::create));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
       Optional<Imovel> imovel = service.getImovelById(id);
       if (!imovel.isPresent()){
           return new ResponseEntity("Imovel nao localizado", HttpStatus.NOT_FOUND);
       }
        return ResponseEntity.ok(imovel.map(ImovelDTO::create));
    }
}
