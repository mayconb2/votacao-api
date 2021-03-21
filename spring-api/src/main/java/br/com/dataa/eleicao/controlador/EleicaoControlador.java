package br.com.dataa.eleicao.controlador;

import br.com.dataa.eleicao.dto.EleicaoDTO;
import br.com.dataa.eleicao.servico.EleicaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/eleicao")
public class EleicaoControlador {

    private EleicaoServico eleicaoServico;

    @Autowired
    EleicaoControlador(EleicaoServico eleicaoServico) {
        this.eleicaoServico = eleicaoServico;
    }

    @GetMapping(value ="listar")
    public List<EleicaoDTO> listarTodos() {
        return eleicaoServico.listarTodos();
    }

}
