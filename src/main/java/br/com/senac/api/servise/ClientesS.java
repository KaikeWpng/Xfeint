package br.com.senac.api.servise;

import br.com.senac.api.controllers.dtos.ClientesRequestDTO;
import br.com.senac.api.entidades.Clientes;
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

}
