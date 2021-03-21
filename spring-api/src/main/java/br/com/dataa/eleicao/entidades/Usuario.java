package br.com.dataa.eleicao.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @Column(length = 11)
    public String cpf;

    @Column(nullable = false)
    public String nome;

    @JoinColumn(nullable = false, referencedColumnName = "id")
    @OneToOne(targetEntity = Perfil.class, fetch=FetchType.LAZY)
    public Perfil perfil;
}
