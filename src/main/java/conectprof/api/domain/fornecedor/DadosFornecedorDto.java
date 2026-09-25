package conectprof.api.domain.fornecedor;

import conectprof.api.domain.endereco.DadosEnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosFornecedorDto(

        @NotBlank String nomeFantasia,
        @NotBlank @Pattern(regexp = "^(\\d{14}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})$", message = "CNPJ em formato inválido.") String cnpj,
        @Email @NotBlank String email,
        @NotBlank String telefone,
        @NotNull @Valid DadosEnderecoDto endereco) {
}
