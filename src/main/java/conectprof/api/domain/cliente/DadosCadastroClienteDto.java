package conectprof.api.domain.cliente;

import conectprof.api.domain.endereco.DadosEnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroClienteDto(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido")
        String email,
        @NotBlank(message = "CPF é obrigatório")
        @Pattern(regexp = "^(\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$", message = "CPF em formato inválido.")
        String cpf,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid
        DadosEnderecoDto endereco) {
}
