package br.com.dataa.eleicao.servico;

import br.com.dataa.eleicao.dto.EleicaoDTO;
import br.com.dataa.eleicao.entidade.Eleicao;
import br.com.dataa.eleicao.repositorio.CargoRepositorio;
import br.com.dataa.eleicao.repositorio.EleicaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EleicaoServico {

    private EleicaoRepositorio eleicaoRepositorio;
    private CargoRepositorio cargoRepositorio;

    @Autowired
    EleicaoServico(EleicaoRepositorio eleicaoRepositorio, CargoRepositorio cargoRepositorio) {
        this.eleicaoRepositorio = eleicaoRepositorio;
        this.cargoRepositorio = cargoRepositorio;
    }

    public List<EleicaoDTO> listarTodos() {
        List<EleicaoDTO> dtos = new ArrayList<>();

        List<Eleicao> todasEntidades = eleicaoRepositorio.findAll();

        todasEntidades.forEach(entidade -> dtos.add(entidade.paraDTO()));

        return dtos;
    }

    public EleicaoDTO buscaPorId(Long id) {
        Eleicao entidade = eleicaoRepositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Não foi encontrada nenhuma eleição com Id" + id)
        );

        EleicaoDTO dto = entidade.paraDTO();

        return dto;
    }

    public EleicaoDTO criarEleicao(EleicaoDTO dto) {
        Eleicao entidadeParaSalvar = dto.paraEntidade(cargoRepositorio);

        Eleicao entidadeSalva = eleicaoRepositorio.save(entidadeParaSalvar);

        EleicaoDTO dtoRetorno = entidadeSalva.paraDTO();

        return dtoRetorno;
    }
}
