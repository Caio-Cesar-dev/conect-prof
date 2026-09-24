package conectprof.api.profissional;

import conectprof.api.endereco.DadosEnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosProfissionalDto(
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$", message = "CPF formato inválido")
        String cpf,
        @NotNull
        Especialidade especialidade,
        @Valid
        @NotNull
        DadosEnderecoDto endereco) {
}
