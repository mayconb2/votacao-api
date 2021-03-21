package br.com.dataa.eleicao.repositorio;

import br.com.dataa.eleicao.entidade.Eleicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleicaoRepositorio extends JpaRepository <Eleicao, Long> {
}
