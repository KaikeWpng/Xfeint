package br.com.senac.api.repositorios;

import br.com.senac.api.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoR extends JpaRepository<Produto, Long>{
}
