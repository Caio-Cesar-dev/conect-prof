package conectprof.api.domain.fornecedor;

import conectprof.api.domain.endereco.DadosEnderecoDto;
import jakarta.validation.constraints.NotNull;

public record DadoAtualizacaoFornecedorDto(@NotNull Long id, String nomeFantasia, String telefone, DadosEnderecoDto endereco) {
}
