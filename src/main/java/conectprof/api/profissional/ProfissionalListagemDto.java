package conectprof.api.profissional;

public record ProfissionalListagemDto(
        Long id,
        String nome,
        String email,
        String telefone,
        Especialidade especialidade) {

    public ProfissionalListagemDto(ProfissionalEntity dados){
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getTelefone(), dados.getEspecialidade());
    }
}
