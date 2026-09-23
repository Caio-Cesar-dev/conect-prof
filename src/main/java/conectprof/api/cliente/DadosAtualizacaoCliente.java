package conectprof.api.cliente;

import conectprof.api.endereco.DadosEnderecoDto;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long id, String nome, String telefone, DadosEnderecoDto endereco) {
}
