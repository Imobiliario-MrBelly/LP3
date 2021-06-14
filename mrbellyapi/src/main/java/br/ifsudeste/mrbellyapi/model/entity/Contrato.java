package br.ifsudeste.mrbellyapi.model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Imovel imovel;
	@ManyToOne
	private Locatario locatario;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFim;
	private double valor;
}
