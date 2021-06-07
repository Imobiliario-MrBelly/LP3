package br.ifsudeste.mrbellyapi.model.repository;

import br.ifsudeste.mrbellyapi.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
