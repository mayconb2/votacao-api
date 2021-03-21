package br.com.dataa.eleicao.servico;

import br.com.dataa.eleicao.dto.CargoDTO;
import br.com.dataa.eleicao.entidade.Cargo;
import br.com.dataa.eleicao.repositorio.CargoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoServico {

    private CargoRepositorio cargoRepositorio;

    @Autowired
    CargoServico(CargoRepositorio cargoRepositorio) {
        this.cargoRepositorio = cargoRepositorio;
    }

    public List<CargoDTO> listarTodos() {
        List<Cargo> entidades = cargoRepositorio.findAll();
        List<CargoDTO> dtos = new ArrayList<>();

        entidades.forEach(entidade -> dtos.add(entidade.paraDTO()));

        return dtos;
    }

    public CargoDTO buscarPorId(Long id) {
        Cargo entidade = cargoRepositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Não foi encontrado nenhum cargo com ID" + id)
        );

        return entidade.paraDTO();
    }

    public CargoDTO criarCargo(CargoDTO dto) {
        Cargo entidadeParaSalvar = dto.paraEntidade();

        Cargo entidadeSalva = cargoRepositorio.save(entidadeParaSalvar);

        return entidadeSalva.paraDTO();
    }

    public CargoDTO modificar(Long id, CargoDTO cargoDTO) {
        Cargo entidadeParaModificar = cargoRepositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Não foi encontrado nenhum cargo com ID" + id)
        );

        CargoDTO novoDTO = entidadeParaModificar.paraDTO();
        novoDTO.setNomeCargo(cargoDTO.getNomeCargo());

        Cargo novaEntidade = cargoRepositorio.save(novoDTO.paraEntidade());

        return novaEntidade.paraDTO();
    }
}
