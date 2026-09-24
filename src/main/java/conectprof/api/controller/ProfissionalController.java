package conectprof.api.controller;

import conectprof.api.profissional.DadosProfissionalDto;
import conectprof.api.profissional.ProfissionalEntity;
import conectprof.api.profissional.ProfissionalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
