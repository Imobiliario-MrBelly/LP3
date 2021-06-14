package br.ifsudeste.mrbellyapi.model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Locador {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@OneToOne
    private Pessoa pessoa;
    @OneToOne
    private Endereco endereco;
    @OneToOne
    private Login login;
}
