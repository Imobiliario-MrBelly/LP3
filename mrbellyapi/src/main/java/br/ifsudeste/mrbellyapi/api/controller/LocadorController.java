package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.ImovelDTO;
import br.ifsudeste.mrbellyapi.api.dto.LocadorDTO;
import br.ifsudeste.mrbellyapi.api.exception.RegradeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Endereco;
import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.service.EnderecoService;
import br.ifsudeste.mrbellyapi.service.LocadorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @GetMapping("/{id}/imoveis")
    public ResponseEntity getImoveis(@PathVariable("id") Long id){
        Optional<Locador> locador = service.getLocadorById(id);
        if (!locador.isPresent()){
            return new ResponseEntity("Locador nao encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(locador.get().getImoveis().stream().map(ImovelDTO::create).collect(Collectors.toList()));
    }
    @PostMapping()
        public ResponseEntity post(LocadorDTO dto ){
            try {
                Locador locador = converter(dto);
                locador=service.salvar(locador);
                return new ResponseEntity(locador, HttpStatus.CREATED);
            }catch(RegradeNegocioException e ){
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

    private Locador converter(LocadorDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Locador locador = modelMapper.map(dto, Locador.class);
        if (dto.getIdEndereco() != null||dto.getIdLogin() != null) {
            Optional<Endereco> endereco = EnderecoService.getCursoById(dto.getIdCurso());
            if (!curso.isPresent()) {
                aluno.setCurso(null);
            } else {
                aluno.setCurso(curso.get());
            }
        }
        return aluno;
    }
    }

}
