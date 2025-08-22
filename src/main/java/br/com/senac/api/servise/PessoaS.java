package br.com.senac.api.servise;

import br.com.senac.api.controllers.dtos.CarroRequestDTO;
import br.com.senac.api.controllers.dtos.PessoaRequestDTO;
import br.com.senac.api.entidades.Carro;
import br.com.senac.api.entidades.Pessoa;
import br.com.senac.api.repositorios.PessoaR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaS {

    @Autowired
    private PessoaR pessoaR;

    public List<Pessoa> listarTodos() {
        return pessoaR.findAll();
    }

    public Pessoa criar(PessoaRequestDTO pessoa) {
        Pessoa pessoaPersist = new Pessoa();
        pessoaPersist.setNome(pessoa.getNome());
        pessoaPersist.setSobrenome(pessoa.getSobrenome());

        return pessoaR.save(pessoaPersist);
    }

    public Carro atualizar(Long id, PessoaRequestDTO carro) throws Exception {
        if (!pessoaR.existsById(id)) {
            throw new Exception("Registro não encontrado");
        } else {
            Carro carroPersist = new Carro();
            carroPersist.setMarca(carro.getMarca());
            carroPersist.setModelo(carro.getModelo());
            carroPersist.setId(id);

            return carroR.save(carroPersist);
        }

    }
}
