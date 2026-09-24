package conectprof.api.profissional;

import conectprof.api.endereco.DadosEnderecoDto;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfissionalDto(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEnderecoDto endereco) {
}
