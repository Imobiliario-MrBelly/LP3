package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.ImovelDTO;
import br.ifsudeste.mrbellyapi.api.dto.LocadorDTO;
import br.ifsudeste.mrbellyapi.api.exception.RegraDeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Endereco;
import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.model.entity.Login;
import br.ifsudeste.mrbellyapi.service.EnderecoService;
import br.ifsudeste.mrbellyapi.service.ImovelService;
import br.ifsudeste.mrbellyapi.service.LocadorService;
import br.ifsudeste.mrbellyapi.service.LoginService;
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
	private final EnderecoService enderecoService;
	private final LoginService loginService;
	private final ImovelService imovelService;

	@GetMapping()
	public ResponseEntity get() {
		List<Locador> locadores = service.getLocadores();
		return ResponseEntity.ok(locadores.stream().map(LocadorDTO::create));
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		Optional<Locador> locador = service.getLocadorById(id);
		if (!locador.isPresent()) {
			return new ResponseEntity("Locador não encontrado", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(locador.map(LocadorDTO::create));
	}

	@GetMapping("/{id}/imoveis")
	public ResponseEntity getImoveis(@PathVariable("id") Long id) {
		Optional<Locador> locador = service.getLocadorById(id);
		if (!locador.isPresent()) {
			return new ResponseEntity("Locador não encontrado", HttpStatus.NOT_FOUND);
		}
		List<Imovel> imoveis = imovelService.getImovelByLocador(locador);
		return ResponseEntity
				.ok(imoveis.stream().map(ImovelDTO::create).collect(Collectors.toList()));
	}

	@PostMapping()
	public ResponseEntity post(LocadorDTO dto) {
		try {
			Locador locador = converter(dto);
			locador = service.salvar(locador);
			return new ResponseEntity(locador, HttpStatus.CREATED);
		} catch (RegraDeNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	public Locador converter(LocadorDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		Locador locador =  modelMapper.map(dto, Locador.class);
		
		if(dto.getIdEndereco() != null) {
			Optional<Endereco> endereco = enderecoService.getEnderecoById(dto.getIdEndereco());
			if(!endereco.isPresent()) {
				locador.setEndereco(null);
			}else {
				locador.setEndereco(endereco.get());
			}
		}
		
		if(dto.getIdLogin() != null) {
			Optional<Login> login = loginService.getLoginById(dto.getIdLogin());
			if(!login.isPresent()) {
				locador.setLogin(null);
			}else {
				locador.setLogin(login.get());
			}
		}
        return locador;
	}

}
