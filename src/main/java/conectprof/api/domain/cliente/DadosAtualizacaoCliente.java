package conectprof.api.domain.cliente;

import conectprof.api.domain.endereco.DadosEnderecoDto;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long id, String nome, String telefone, DadosEnderecoDto endereco) {
}
