package br.com.dataa.eleicao.dto;

import br.com.dataa.eleicao.entidade.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {

    private Long id;
    private String nomeCargo;

    public Cargo paraEntidade() {
        Cargo entidade = new Cargo(this.getId(), this.getNomeCargo());
        return entidade;
    }
}
