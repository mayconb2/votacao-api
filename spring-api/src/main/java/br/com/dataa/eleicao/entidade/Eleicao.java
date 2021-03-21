package br.com.dataa.eleicao.entidade;

import br.com.dataa.eleicao.dto.EleicaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="eleicao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Eleicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public EleicaoDTO paraDTO() {
        EleicaoDTO dto = new EleicaoDTO();
        dto.setId(this.getId());
        dto.setNomeEleicao(this.getNomeEleicao());
        dto.setDataIni(this.getDataInicio());
        dto.setDataFim(this.getDataFim());
        dto.setCargoVotado(this.getCargoVotado().getId());
        dto.setNomeCargoVotado(this.getCargoVotado().getNomeCargo());
        return dto;
    }

}
