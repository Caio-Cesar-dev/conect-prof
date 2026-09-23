package conectprof.api.controller;


import conectprof.api.cliente.ClienteEntity;
import conectprof.api.cliente.ClienteRepository;
import conectprof.api.cliente.DadosCadastroClienteDto;
import conectprof.api.cliente.DadosListagemClientesDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroClienteDto dados){
        repository.save(new ClienteEntity(dados));
    }

    @GetMapping
    public Page<DadosListagemClientesDto> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemClientesDto::new);
    }
}
