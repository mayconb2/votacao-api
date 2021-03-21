package br.com.dataa.eleicao.entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="candidato")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {

    @Id
    private Long id;

    @Column(name = "nome_candidato",nullable = false)
    private String nomeCandidato;

    @JoinColumn(name = "cargo", nullable = false, referencedColumnName = "id")
    @OneToOne(targetEntity = Cargo.class, fetch=FetchType.LAZY)
    private Cargo cargo;

    @JoinColumn(name = "eleicao", nullable = false, referencedColumnName = "id")
    @ManyToOne(targetEntity = Eleicao.class, fetch=FetchType.LAZY)
    private Eleicao eleicao;

    @Column(name="foto")
    private byte[] foto;

}
