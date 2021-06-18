package br.ifsudeste.mrbellyapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Locador extends Pessoa{


    @OneToOne
    private Endereco endereco;

}
