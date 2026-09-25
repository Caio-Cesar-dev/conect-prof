package conectprof.api.controller;

import conectprof.api.profissional.*;
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
@RequestMapping("profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrarProfissional(@Valid @RequestBody DadosProfissionalDto dados, UriComponentsBuilder uriBuilder){

        var profissional = new ProfissionalEntity(dados);
        repository.save(profissional);
        var uri = uriBuilder.path("/profissionais/{id}").buildAndExpand(profissional.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProfissionalDto(profissional));
    }

    @GetMapping
    public ResponseEntity<Page<ProfissionalListagemDto>> listagemProfissionais(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(ProfissionalListagemDto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarProfissional(@Valid @RequestBody DadosAtualizacaoProfissionalDto dados){
        var profissional = repository.getReferenceById(dados.id());
        profissional.atualizaInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProfissionalDto(profissional));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirProfissional(@PathVariable Long id){
        var profissional = repository.getReferenceById(id);
        profissional.excluirProfissional();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharProfissional(@PathVariable Long id){
        var profissional = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProfissionalDto(profissional));
    }

}
