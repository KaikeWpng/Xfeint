package br.com.senac.api.servise;

import br.com.senac.api.controllers.ProdutoC;
import br.com.senac.api.controllers.dtos.PessoaRequestDTO;
import br.com.senac.api.controllers.dtos.ProdutoRequestDTO;
import br.com.senac.api.entidades.Pessoa;
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
    public Produto atualizar(Long id, ProdutoRequestDTO produto) throws Exception {
        if (!produtoR.existsById(id)) {
            throw new Exception("Registro não encontrado");
        } else {
            Produto produtoPersist = new Produto();
            produtoPersist.setNome(produto.getNome());
            produtoPersist.setDescricao(produto.getDescricao());
            produtoPersist.setId(id);

            return produtoR.save(produtoPersist);
        }

    }
    public void excluir(Long id) throws Exception {
        if (!produtoR.existsById(id)) {
            throw new Exception("Registro não encontrado para exclusão");
        }

        produtoR.deleteById(id);
    }
}
