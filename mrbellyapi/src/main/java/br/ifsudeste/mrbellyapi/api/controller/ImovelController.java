package br.ifsudeste.mrbellyapi.api.controller;

import br.ifsudeste.mrbellyapi.api.dto.ImovelDTO;
import br.ifsudeste.mrbellyapi.api.exception.RegraDeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Endereco;
import br.ifsudeste.mrbellyapi.model.entity.Imovel;
import br.ifsudeste.mrbellyapi.model.entity.Locador;
import br.ifsudeste.mrbellyapi.service.EnderecoService;
import br.ifsudeste.mrbellyapi.service.ImovelService;
import br.ifsudeste.mrbellyapi.service.LocadorService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/imoveis")
@RequiredArgsConstructor
public class ImovelController {
	private final ImovelService service;
	private final EnderecoService enderecoService;
	private final LocadorService locadorService;

	@GetMapping()
	public ResponseEntity get() {
		List<Imovel> imoveis = service.getImoveis();
		return ResponseEntity.ok(imoveis.stream().map(ImovelDTO::create));
	}

	@GetMapping("/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		Optional<Imovel> imovel = service.getImovelById(id);
		if (!imovel.isPresent()) {
			return new ResponseEntity("Imovel nao localizado", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(imovel.map(ImovelDTO::create));
	}

	@PostMapping()
	public ResponseEntity post(ImovelDTO dto) {
		try {
			Imovel imovel = converter(dto);
			imovel = service.salvar(imovel);
			return new ResponseEntity(imovel, HttpStatus.CREATED);
		} catch (RegraDeNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	public Imovel converter(ImovelDTO dto) {

		ModelMapper modelMapper = new ModelMapper();
		Imovel imovel = modelMapper.map(dto, Imovel.class);

		if (dto.getIdEndereco() != null) {
			Optional<Endereco> endereco = enderecoService.getEnderecoById(dto.getIdEndereco());
			if (!endereco.isPresent()) {
				imovel.setEndereco(null);
			} else {
				imovel.setEndereco(endereco.get());
			}
		}
		if (dto.getIdLocador() != null) {
			Optional<Locador> locador = locadorService.getLocadorById(dto.getIdLocador());
			if (!locador.isPresent()) {
				imovel.setLocador(null);
			} else {
				imovel.setLocador(locador.get());
			}
		}
		return imovel;
	}
}
