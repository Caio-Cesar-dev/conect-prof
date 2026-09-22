package conectprof.api.cliente;

import conectprof.api.endereco.DadosEnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroClienteDto(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^(\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$", message = "CPF em formato inválido.")
        String cpf,
        @NotBlank
        String telefone,
        @NotNull
        @Valid
        DadosEnderecoDto endereco) {
}
