package br.ifsudeste.mrbellyapi.service;

import br.ifsudeste.mrbellyapi.api.exception.RegraDeNegocioException;
import br.ifsudeste.mrbellyapi.model.entity.Login;
import br.ifsudeste.mrbellyapi.model.repository.LoginRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
	private LoginRepository repository;

	public LoginService(LoginRepository repository) {
		this.repository = repository;
	}

	public List<Login> getLogins() {
		return repository.findAll();
	}

	public Optional<Login> getLoginById(Long id) {
		return repository.findById(id);
	}

	@Transactional
	public Login salvar(Login login) {
		validar(login);
		return repository.save(login);
	}

	private void validar(Login login) {
		if (login.getEmail() == null || login.getEmail().trim().equals("")) {
			throw new RegraDeNegocioException("E-mail inválido");
		}
		if (login.getSenha() == null || login.getSenha().trim().equals("")) {
			throw new RegraDeNegocioException("Senha inválido");
		}
	}

}
