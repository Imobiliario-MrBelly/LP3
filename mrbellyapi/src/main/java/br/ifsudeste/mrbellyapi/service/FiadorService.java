package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.exception.RegraDeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Fiador;
import br.ifsudeste.mrbellyapi.model.repository.FiadorRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FiadorService {
	private FiadorRepository repository;

	public FiadorService(FiadorRepository repository) {
		this.repository = repository;
	}

	public List<Fiador> getFiadores() {
		return repository.findAll();
	}

	public Optional<Fiador> getFiadorById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Fiador salvar(Fiador fiador) {
		validar(fiador);
		return repository.save(fiador);
	}

	private void validar(Fiador fiador) {
		if (fiador.getNome()==null||fiador.getNome().trim().equals("")){
			throw new RegraDeNegocioException("Nome inválido");
		}

		if (fiador.getCpf()==null||fiador.getCpf().trim().equals("")){
			throw new RegraDeNegocioException("CPF inválido");
		}

		if (fiador.getRg()==null||fiador.getRg().trim().equals("")){
			throw new RegraDeNegocioException("RG inválido");
		}
		if (fiador.getSexo()==null||fiador.getSexo().trim().equals("")){
			throw new RegraDeNegocioException("Sexo inválido");
		}
		if (fiador.getDataNascimento()==null){
			throw new RegraDeNegocioException("Data inválida");
		}
		if (fiador.getCpf()==null||fiador.getCpf().trim().equals("")){
			throw new RegraDeNegocioException("CPF inválido");
		}
		if (fiador.getEndereco()==null){
			throw new RegraDeNegocioException("Endereco inválido");
		}

	}

}
