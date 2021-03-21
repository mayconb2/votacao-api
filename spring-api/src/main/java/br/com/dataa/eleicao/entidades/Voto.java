package br.com.dataa.eleicao.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="voto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String protocoloVotacao;

    @Column(nullable = false)
    private LocalDateTime dataVotacao;


    @JoinColumn(name = "usuario_votante", nullable = false, referencedColumnName = "cpf")
    @OneToOne(targetEntity = Usuario.class, fetch=FetchType.LAZY)
    private Usuario usuarioVotante;


    @JoinColumn(nullable = false, referencedColumnName = "id")
    @ManyToOne(targetEntity = Eleicao.class, fetch=FetchType.LAZY)
    private Eleicao eleicao;


    @Column(nullable = false)
    private Long candidatoVotado;
}
