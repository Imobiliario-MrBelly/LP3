package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.exception.RegradeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Contrato;
import br.ifsudeste.mrbellyapi.model.entity.Endereco;
import br.ifsudeste.mrbellyapi.model.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class EnderecoService {
	private EnderecoRepository repository;

	public EnderecoService(EnderecoRepository repository) {
		this.repository = repository;
	}

	public List<Endereco> getEnderecos() {
		return repository.findAll();
	}

	public Optional<Endereco> getEnderecoById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Endereco salvar(Endereco endereco) {
		validar(endereco);
		return repository.save(endereco);
	}

	public void validar(Endereco endereco) {

		if (endereco.getRua() == null || endereco.getRua().trim().equals("")) {
			throw new RegradeNegocioException("Endereço inválido");
		}
		
		if (endereco.getNumero() == null || endereco.getNumero().trim().equals("")) {
			throw new RegradeNegocioException("Número inválido");
		}
		
		if (endereco.getCep() == null || endereco.getCep().trim().equals("")) {
			throw new RegradeNegocioException("CEP inválido");
		}
		
		if (endereco.getCidade() == null || endereco.getCidade().trim().equals("")) {
			throw new RegradeNegocioException("Cidade inválida");
		}
		
		if (endereco.getUf() == null || endereco.getUf().trim().equals("")) {
			throw new RegradeNegocioException("Unidade federativa (UF) inválida");
		}
	}
}
