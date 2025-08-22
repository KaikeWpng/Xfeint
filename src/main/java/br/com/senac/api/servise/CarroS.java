package br.com.senac.api.servise;

import br.com.senac.api.controllers.dtos.CarroRequestDTO;
import br.com.senac.api.entidades.Carro;
import br.com.senac.api.repositorios.CarroR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroS {

    @Autowired
    private CarroR carroR;

    public List<Carro> listaTodos() {
        return carroR.findAll();
    }

    public Carro criar(CarroRequestDTO carro) {
        Carro carroPersist = new Carro();
        carroPersist.setMarca(carro.getMarca());
        carroPersist.setModelo(carro.getModelo());

        return carroR.save(carroPersist);
    }

    public Carro atualizar(Long id, CarroRequestDTO carro) throws Exception {
        if (!carroR.existsById(id)) {
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
