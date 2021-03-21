package br.com.dataa.eleicao.dto;

import br.com.dataa.eleicao.entidade.Cargo;
import br.com.dataa.eleicao.entidade.Eleicao;
import br.com.dataa.eleicao.repositorio.CargoRepositorio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EleicaoDTO {

    private Long id;
    private String nomeEleicao;
    private LocalDate dataIni;
    private LocalDate dataFim;
    private Long cargoVotado;
    private String nomeCargoVotado;

    public Eleicao paraEntidade(CargoRepositorio cargoRepositorio) {
        Eleicao eleicaoEntidade = new Eleicao();

        Cargo cargoEntidade = cargoRepositorio.findById(this.getCargoVotado()).orElseThrow(
                () -> new RuntimeException("Não foi encontrada nenhum cargo com Id" + id)
        );

        eleicaoEntidade.setId(this.getId());
        eleicaoEntidade.setNomeEleicao(this.getNomeEleicao());
        eleicaoEntidade.setDataInicio(this.getDataIni());
        eleicaoEntidade.setDataFim(this.getDataFim());
        eleicaoEntidade.setCargoVotado(cargoEntidade);

        return eleicaoEntidade;
    }

}
