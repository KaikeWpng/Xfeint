package br.com.senac.api.servise;

import br.com.senac.api.controllers.dtos.ClientesRequestDTO;
import br.com.senac.api.controllers.dtos.PessoaRequestDTO;
import br.com.senac.api.entidades.Clientes;
import br.com.senac.api.entidades.Pessoa;
import br.com.senac.api.repositorios.ClientesR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesS {

    @Autowired
    private ClientesR clientesR;

    public void criar(ClientesRequestDTO cliente) {
        Clientes clientePersist = new Clientes();
        clientePersist.setNome(cliente.getNome());
        clientePersist.setSobrenome(cliente.getSobrenome());
        clientePersist.setEmail(cliente.getEmail());
        clientePersist.setDocumento(cliente.getDocumento());

        clientesR.save(clientePersist);
    }

    public List<Clientes> listarTodos() {
        return clientesR.findAll();
    }

    public Clientes atualizar(Long id, ClientesRequestDTO clientes) throws Exception {
        if (!clientesR.existsById(id)) {
            throw new Exception("Registro não encontrado");
        } else {
            Clientes clientespersist = new Clientes();
            clientespersist.setNome(clientes.getNome());
            clientespersist.setSobrenome(clientes.getSobrenome());
            clientespersist.setEmail(clientes.getEmail());
            clientespersist.setDocumento(clientes.getDocumento());
            clientespersist.setId(id);

            return clientesR.save(clientespersist);
        }

    }
    public void excluir(Long id) throws Exception {
        if (!clientesR.existsById(id)) {
            throw new Exception("Registro não encontrado para exclusão");
        }

        clientesR.deleteById(id);
    }
}
