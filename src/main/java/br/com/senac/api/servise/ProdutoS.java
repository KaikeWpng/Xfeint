package br.com.senac.api.servise;

import br.com.senac.api.controllers.dtos.PessoaRequestDTO;
import br.com.senac.api.controllers.dtos.ProdutoRequestDTO;
import br.com.senac.api.entidades.Produto;
import br.com.senac.api.repositorios.ProdutoR;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoS {

    private ProdutoR produtoR;

    public List<Produto> listarTodos() {
        return produtoR.findAll();
    }

    public Produto criar(ProdutoRequestDTO produto) {
        Produto produtoPersist = new Produto();
        produtoPersist.setNome(produto.getNome());
        produtoPersist.setDescricao(produto.getDescricao());

        return produtoR.save(produtoPersist);
    }

}
