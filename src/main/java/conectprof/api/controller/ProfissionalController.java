package conectprof.api.controller;

import conectprof.api.profissional.DadosProfissionalDto;
import conectprof.api.profissional.ProfissionalEntity;
import conectprof.api.profissional.ProfissionalListagemDto;
import conectprof.api.profissional.ProfissionalRepository;
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

}
