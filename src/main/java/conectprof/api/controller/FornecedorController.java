package conectprof.api.controller;

import conectprof.api.fornecedor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoFornecedorDto> cadastrarFornecedor(@RequestBody @Valid DadosFornecedorDto dadosFornecedor, UriComponentsBuilder uriBuider){
        var fornecedor = new FornecedorEntity(dadosFornecedor);
        repository.save(fornecedor);
        var uri = uriBuider.path("/fornecedores/{id}").buildAndExpand(fornecedor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoFornecedorDto(fornecedor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemFornecedorDto>> listarFornecedores(@PageableDefault(sort = {"nomeFantasia"}, size = 10) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemFornecedorDto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarFornecedor(@RequestBody @Valid DadoAtualizacaoFornecedorDto dados){
        var fornecedor = repository.getReferenceById(dados.id());
        fornecedor.atualizarFornecedor(dados);

        return ResponseEntity.ok(new DadosDetalhamentoFornecedorDto(fornecedor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirFornecedor(@PathVariable Long id){
        var fornecedor = repository.getReferenceById(id);
        fornecedor.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharFornecedor(@PathVariable Long id){
        var fornecedor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoFornecedorDto(fornecedor));
    }


}
