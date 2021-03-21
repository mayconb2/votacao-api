package br.com.dataa.eleicao.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

    @Id
    public Long id;

    @Column(name = "nome_perfil", nullable = false)
    public String nomePerfil;
}
