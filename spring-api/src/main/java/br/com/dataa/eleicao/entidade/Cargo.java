package br.com.dataa.eleicao.entidade;

import br.com.dataa.eleicao.dto.CargoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="cargo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cargo", nullable = false)
    private String nomeCargo;

    public CargoDTO paraDTO() {
        CargoDTO dto = new CargoDTO(this.getId(), this.nomeCargo);
        return dto;
    }
}
