package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.ContratoDTO;
import br.ifsudeste.mrbellyapi.model.entity.Contrato;
import br.ifsudeste.mrbellyapi.service.ContratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/contratos")
@RequiredArgsConstructor
public class ContratoController {
	
	private final ContratoService service;

	@GetMapping()
	public ResponseEntity get() {
		List<Contrato> contratos = service.getContratos();
		return ResponseEntity.ok(contratos.stream().map(ContratoDTO::create).collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		Optional<Contrato> contrato = service.getContratoById(id);
		if (!contrato.isPresent()){
			return new ResponseEntity("Contrato nao encontrado", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(contrato.map(ContratoDTO::create));
	}
}
