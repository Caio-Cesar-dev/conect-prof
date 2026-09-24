package conectprof.api.controller;

import conectprof.api.fornecedor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<DadosListagemFornecedorDto> listarFornecedores(@PageableDefault(sort = {"nomeFantasia"}, size = 10) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemFornecedorDto::new);
    }

    @PutMapping
    @Transactional
    public void atualizarFornecedor(@RequestBody @Valid DadoAtualizacaoFornecedorDto dados){
        var fornecedor = repository.getReferenceById(dados.id());
        fornecedor.atualizarFornecedor(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirFornecedor(@PathVariable Long id){
        var fornecedor = repository.getReferenceById(id);
        fornecedor.excluir();
    }


}
