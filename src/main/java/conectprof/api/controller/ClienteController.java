package conectprof.api.controller;


import conectprof.api.cliente.ClienteEntity;
import conectprof.api.cliente.ClienteRepository;
import conectprof.api.cliente.DadosCadastroClienteDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastroCliente(@RequestBody @Valid DadosCadastroClienteDto dados){
        repository.save(new ClienteEntity(dados));
    }
}
