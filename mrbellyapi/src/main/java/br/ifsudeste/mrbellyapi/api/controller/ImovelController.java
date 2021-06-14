package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.service.ImovelService;
import lombok.RequiredArgsConstructor;
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
    private final ImovelService service ;

    @GetMapping()
    public ResponseEntity get(){
        List<Imovel> imovels = service.getImoveis();
        return ResponseEntity.ok(imovels);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Imovel> imovel = service.getImovelById(id);
        return ResponseEntity.ok(imovel);
    }
}
