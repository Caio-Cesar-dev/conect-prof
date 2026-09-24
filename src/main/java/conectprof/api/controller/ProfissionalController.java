package conectprof.api.controller;

import conectprof.api.profissional.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository repository;

    @Transactional
    @PostMapping
    public void cadastrarProfissional(@Valid @RequestBody DadosProfissionalDto dados){
        repository.save(new ProfissionalEntity(dados));
    }

    @GetMapping
    public Page<ProfissionalListagemDto> listagemProfissionais(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(ProfissionalListagemDto::new);
    }

    @PutMapping
    @Transactional
    public void atualizarProfissional(@Valid @RequestBody DadosAtualizacaoProfissionalDto dados){
        var profissional = repository.getReferenceById(dados.id());
        profissional.atualizaInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirProfissional(@PathVariable Long id){
        var profissional = repository.getReferenceById(id);
        profissional.excluirProfissional();
    }

}
