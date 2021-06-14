package br.ifsudeste.mrbellyapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsudeste.mrbellyapi.model.entity.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long>{

}
