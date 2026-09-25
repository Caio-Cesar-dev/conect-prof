package conectprof.api.domain.profissional;

import conectprof.api.domain.endereco.DadosEnderecoDto;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfissionalDto(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEnderecoDto endereco) {
}
