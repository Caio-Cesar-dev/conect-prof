package conectprof.api.fornecedor;

import conectprof.api.endereco.DadosEnderecoDto;
import jakarta.validation.constraints.NotNull;

public record DadoAtualizacaoFornecedorDto(@NotNull Long id, String nomeFantasia, String telefone, DadosEnderecoDto endereco) {
}
