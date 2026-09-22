package conectprof.api.controller;

import conectprof.api.fornecedor.DadosFornecedorDto;
import conectprof.api.fornecedor.FornecedorEntity;
import conectprof.api.fornecedor.FornecedorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarFornecedor(@RequestBody @Valid DadosFornecedorDto dadosFornecedor){
        repository.save(new FornecedorEntity(dadosFornecedor));
    }
}
