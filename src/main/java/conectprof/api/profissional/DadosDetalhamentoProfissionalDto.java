package conectprof.api.profissional;

import conectprof.api.endereco.Endereco;

public record DadosDetalhamentoProfissionalDto(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Especialidade especialidade,
        Endereco endereco) {

    public DadosDetalhamentoProfissionalDto (ProfissionalEntity profissional){
        this(profissional.getId(), profissional.getNome(), profissional.getEmail(), profissional.getTelefone(),
                profissional.getCpf(), profissional.getEspecialidade(), profissional.getEndereco());

    }
}
