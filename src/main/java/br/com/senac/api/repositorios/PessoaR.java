package br.com.senac.api.repositorios;

import br.com.senac.api.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaR extends JpaRepository<Pessoa, Long> {
}
