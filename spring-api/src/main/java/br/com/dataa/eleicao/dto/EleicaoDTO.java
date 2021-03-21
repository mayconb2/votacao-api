package br.com.dataa.eleicao.dto;

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
    private String cargoVotado;

}
