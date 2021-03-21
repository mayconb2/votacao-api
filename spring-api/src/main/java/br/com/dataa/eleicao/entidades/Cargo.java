package br.com.dataa.eleicao.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidato")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    private Long id;

    @Column(name = "nome_cargo", nullable = false)
    private String nomeCargo;
}
