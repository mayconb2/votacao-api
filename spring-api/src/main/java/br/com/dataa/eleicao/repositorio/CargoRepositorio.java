package br.com.dataa.eleicao.repositorio;

import br.com.dataa.eleicao.entidade.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepositorio extends JpaRepository<Cargo, Long> {
}
