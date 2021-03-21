package br.com.dataa.eleicao.controlador;

import br.com.dataa.eleicao.dto.EleicaoDTO;
import br.com.dataa.eleicao.servico.EleicaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/eleicao")
public class EleicaoControlador {

    private EleicaoServico eleicaoServico;

    @Autowired
    EleicaoControlador(EleicaoServico eleicaoServico) {
        this.eleicaoServico = eleicaoServico;
    }

    @GetMapping(value ="/listar")
    public List<EleicaoDTO> listarTodos() {
        return eleicaoServico.listarTodos();
    }

    @GetMapping(value = "/{id}")
    public EleicaoDTO listarPorID(@PathVariable Long id) {
        return eleicaoServico.buscaPorId(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public EleicaoDTO criarEleicao(@RequestBody EleicaoDTO dto ) {
        return eleicaoServico.criarEleicao(dto);
    }



}
