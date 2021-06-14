package br.ifsudeste.mrbellyapi.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//private Imovel imovel;
	//private Locatario locatario;
	private Date dataInicio;
	private Date dataFim;
	private double valor;
}
