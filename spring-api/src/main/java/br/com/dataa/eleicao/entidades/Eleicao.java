package br.com.dataa.eleicao.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="eleicao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Eleicao {

    @Id
    private Long id;

    @Column(name = "nome_eleicao", nullable = false)
    private String nomeEleicao;

    @Column(name = "data_ini", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @JoinColumn(name = "cargo_votado", nullable = false, referencedColumnName = "id")
    @OneToOne(targetEntity = Cargo.class, fetch=FetchType.LAZY)
    private Cargo cargoVotado;

}
