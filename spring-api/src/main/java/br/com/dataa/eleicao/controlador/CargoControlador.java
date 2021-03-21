package br.com.dataa.eleicao.controlador;

import br.com.dataa.eleicao.dto.CargoDTO;
import br.com.dataa.eleicao.servico.CargoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cargo")
public class CargoControlador {

    private CargoServico cargoServico;

    @Autowired
    CargoControlador(CargoServico cargoServico) {
        this.cargoServico = cargoServico;
    }

    @GetMapping(value = "/listar")
    public List<CargoDTO> listarTodos() {
        return cargoServico.listarTodos();
    }

    @GetMapping(value = "/{id}")
    public CargoDTO listarPorId(@PathVariable Long id) {
        return cargoServico.buscarPorId(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public CargoDTO criarCargo(@RequestBody CargoDTO dto) {
        return cargoServico.criarCargo(dto);
    }

    @PutMapping(value = "/{id}")
    public CargoDTO modificar(@PathVariable Long id, @RequestBody CargoDTO cargoDTO) {
        return cargoServico.modificar(id, cargoDTO);
    }
}
